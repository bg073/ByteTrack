package com.bytetrack.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bytetrack.data.AppDatabase
import com.bytetrack.data.model.DrinkEntry
import com.bytetrack.data.model.DrinkType
import com.bytetrack.data.repository.DrinkEntryRepository
import kotlinx.coroutines.launch
import java.util.Date

class DrinkLogViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = AppDatabase.getDatabase(application)
    private val drinkEntryRepository = DrinkEntryRepository(database.drinkEntryDao())
    
    private val _drinkEntries = MutableLiveData<List<DrinkEntry>>()
    val drinkEntries: LiveData<List<DrinkEntry>> = _drinkEntries
    
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage
    
    init {
        refreshDrinkEntries()
    }
    
    fun refreshDrinkEntries() {
        drinkEntryRepository.getDrinkEntriesForToday().observeForever { entries ->
            _drinkEntries.value = entries
        }
    }
    
    fun logDrink(type: DrinkType, amount: Float, calories: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                
                val drinkEntry = DrinkEntry(
                    date = Date(),
                    type = type,
                    amount = amount,
                    calories = calories
                )
                
                drinkEntryRepository.insertDrinkEntry(drinkEntry)
                
                // Refresh the entries after logging
                refreshDrinkEntries()
                
                _isLoading.value = false
            } catch (e: Exception) {
                _errorMessage.value = "Failed to log drink: ${e.message}"
                _isLoading.value = false
            }
        }
    }
    
    fun deleteDrinkEntry(entry: DrinkEntry) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                
                drinkEntryRepository.deleteDrinkEntry(entry)
                
                // Refresh the entries after deleting
                refreshDrinkEntries()
                
                _isLoading.value = false
            } catch (e: Exception) {
                _errorMessage.value = "Failed to delete drink entry: ${e.message}"
                _isLoading.value = false
            }
        }
    }
    
    fun clearError() {
        _errorMessage.value = null
    }
} 