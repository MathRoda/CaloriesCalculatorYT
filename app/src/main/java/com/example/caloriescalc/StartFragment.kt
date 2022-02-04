package com.example.caloriescalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.caloriescalc.databinding.FragmentStartBinding
import com.example.caloriescalc.model.SharedViewModel


class StartFragment : Fragment() {

    private var binding:FragmentStartBinding? = null
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container , false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            startFragment = this@StartFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    //this function used to be bonded in the button xml code as a dataBinding
    fun goToNextScreen() {

        val gymName = binding?.nameEnterEditText?.text.toString()
        sharedViewModel.setGymName(gymName)
        findNavController().navigate(R.id.action_startFragment_to_informationFragment)
    }

}