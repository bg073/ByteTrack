package com.bytetrack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bytetrack.databinding.FragmentHomeBinding
import com.bytetrack.ui.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: HomeViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        
        setupObservers()
        return binding.root
    }
    
    private fun setupObservers() {
        viewModel.todayCalories.observe(viewLifecycleOwner) { calories ->
            binding.caloriesValue.text = calories?.toString() ?: "0"
        }
        
        viewModel.userProfile.observe(viewLifecycleOwner) { userProfile ->
            binding.dailyGoalValue.text = "${userProfile.dailyCalorieGoal}"
            
            // Calculate calories remaining
            val consumed = viewModel.todayCalories.value ?: 0
            val remaining = userProfile.dailyCalorieGoal - consumed
            binding.caloriesRemainingValue.text = "$remaining"
        }
        
        viewModel.waterIntake.observe(viewLifecycleOwner) { waterAmount ->
            binding.waterIntakeValue.text = "${waterAmount ?: 0} ml"
        }
    }
    
    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 