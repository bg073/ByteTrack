package com.bytetrack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bytetrack.databinding.FragmentStatsBinding
import com.bytetrack.ui.viewmodels.StatsViewModel

class StatsFragment : Fragment() {
    
    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: StatsViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[StatsViewModel::class.java]
        
        setupObservers()
        return binding.root
    }
    
    private fun setupObservers() {
        // Set up daily stats
        viewModel.dailyStats.observe(viewLifecycleOwner) { stats ->
            // TODO: Update UI with daily stats
        }
        
        // Set up weekly stats
        viewModel.weeklyStats.observe(viewLifecycleOwner) { stats ->
            // TODO: Update charts with weekly data
        }
        
        // Set up monthly stats
        viewModel.monthlyStats.observe(viewLifecycleOwner) { stats ->
            // TODO: Update charts with monthly data
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 