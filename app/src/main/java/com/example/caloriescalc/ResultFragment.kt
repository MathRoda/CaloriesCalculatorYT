package com.example.caloriescalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.caloriescalc.databinding.FragmentInformationBinding
import com.example.caloriescalc.databinding.FragmentResultBinding
import com.example.caloriescalc.model.SharedViewModel


class ResultFragment : Fragment() {
    private var binding: FragmentResultBinding? = null
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentResultBinding.inflate(inflater, container , false)
        binding = fragmentBinding
        return fragmentBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
           resultFragment = this@ResultFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

}