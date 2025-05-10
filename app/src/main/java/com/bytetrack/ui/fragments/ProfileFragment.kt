package com.bytetrack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bytetrack.databinding.FragmentProfileBinding
import com.bytetrack.data.model.UserProfile
import com.bytetrack.ui.viewmodels.ProfileViewModel

class ProfileFragment : Fragment() {
    
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: ProfileViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        
        setupObservers()
        setupClickListeners()
        return binding.root
    }
    
    private fun setupObservers() {
        viewModel.userProfile.observe(viewLifecycleOwner) { userProfile ->
            binding.nameInput.setText(userProfile.name)
            binding.ageInput.setText(userProfile.age.toString())
            binding.heightInput.setText(userProfile.height.toString())
            binding.weightInput.setText(userProfile.weight.toString())
            binding.calorieGoalInput.setText(userProfile.dailyCalorieGoal.toString())
            binding.themeSwitch.isChecked = userProfile.theme == "dark"
        }
    }
    
    private fun setupClickListeners() {
        binding.connectAppsButton.setOnClickListener {
            // TODO: Implement connection to fitness apps
        }
        
        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val theme = if (isChecked) "dark" else "light"
            viewModel.updateTheme(theme)
        }
        
        binding.premiumButton.setOnClickListener {
            // TODO: Navigate to premium subscription screen
        }
    }
    
    override fun onPause() {
        super.onPause()
        saveUserProfile()
    }
    
    private fun saveUserProfile() {
        val currentProfile = viewModel.userProfile.value ?: UserProfile()
        val updatedProfile = currentProfile.copy(
            name = binding.nameInput.text.toString(),
            age = binding.ageInput.text.toString().toIntOrNull() ?: 0,
            height = binding.heightInput.text.toString().toFloatOrNull() ?: 0f,
            weight = binding.weightInput.text.toString().toFloatOrNull() ?: 0f,
            dailyCalorieGoal = binding.calorieGoalInput.text.toString().toIntOrNull() ?: 2000
        )
        viewModel.updateUserProfile(updatedProfile)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 