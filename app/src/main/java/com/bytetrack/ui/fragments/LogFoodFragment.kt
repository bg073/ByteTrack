package com.bytetrack.ui.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bytetrack.databinding.FragmentLogFoodBinding
import com.bytetrack.ui.BarcodeScannerActivity
import com.bytetrack.ui.FoodDetailsActivity
import com.bytetrack.ui.viewmodels.LogFoodViewModel

class LogFoodFragment : Fragment() {
    
    private var _binding: FragmentLogFoodBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: LogFoodViewModel
    
    private val barcodeScannerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val barcode = result.data?.getStringExtra(BarcodeScannerActivity.BARCODE_RESULT)
            if (!barcode.isNullOrEmpty()) {
                // Open food details activity with the barcode
                val intent = Intent(requireContext(), FoodDetailsActivity::class.java).apply {
                    putExtra(FoodDetailsActivity.EXTRA_BARCODE, barcode)
                }
                startActivity(intent)
            }
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogFoodBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LogFoodViewModel::class.java]
        
        setupClickListeners()
        return binding.root
    }
    
    private fun setupClickListeners() {
        binding.scanBarcodeButton.setOnClickListener {
            launchBarcodeScanner()
        }
        
        binding.takePhotoButton.setOnClickListener {
            Toast.makeText(context, "Photo recognition coming soon!", Toast.LENGTH_SHORT).show()
        }
        
        binding.manualEntryButton.setOnClickListener {
            Toast.makeText(context, "Manual entry coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun launchBarcodeScanner() {
        val intent = Intent(requireContext(), BarcodeScannerActivity::class.java)
        barcodeScannerLauncher.launch(intent)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 