package co.za.orodata.testbasefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import co.za.orodata.testbasefragment.databinding.FragmentHomeBinding
import co.za.orodata.testbasefragment.viewmodels.SharedViewModel

class HomeFragment: BaseWithViewModelFragment<FragmentHomeBinding, SharedViewModel>(
    FragmentHomeBinding::inflate
) {
    override var useSharedViewModel = true

    override fun getViewModelClass() = SharedViewModel::class.java

//    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to next
        binding.startOrderBtn.setOnClickListener {
            sharedViewModel.saveGossip(binding.etHome.text.toString())
            findNavController().navigate(R.id.action_homeFragment_to_noViewModelFragment)
        }

        sharedViewModel.gossip.observe(viewLifecycleOwner, { gossip ->
            binding.etHome.setText(gossip)
        })
    }
}