package com.example.caloriescalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.caloriescalc.databinding.FragmentInformationBinding
import com.example.caloriescalc.databinding.FragmentStartBinding
import com.example.caloriescalc.model.SharedViewModel

class InformationFragment : Fragment() {

    private var binding: FragmentInformationBinding? = null
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentInformationBinding.inflate(inflater, container , false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            informationFragment = this@InformationFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun onResume() {
        super.onResume()

        // this is a code adapter for the drop down menu

        val activeDays = resources.getStringArray(R.array.active_days)
        val activeDaysAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_acitve_days, activeDays)
        binding!!.autoCompleteTextView.setAdapter(activeDaysAdapter)
    }

    //this function used to be bonded in the button xml code as a dataBinding
    fun goToNextScreen() {

        val age = binding?.ageEditText?.text.toString().toInt()
        sharedViewModel.setAge(age)

        val height = binding?.heightEditText?.text.toString().toDouble()
        sharedViewModel.setHeight(height)

        val weight = binding?.weightEditText?.text.toString().toDouble()
        sharedViewModel.setWeight(weight)

        val activeDays = binding!!.autoCompleteTextView.text.toString()
        sharedViewModel.setActiveDays(activeDays)

        findNavController().navigate(R.id.action_informationFragment_to_resultFragment)
    }


    }
