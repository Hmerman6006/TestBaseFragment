package co.za.orodata.testbasefragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import co.za.orodata.testbasefragment.databinding.FragmentSharedBinding
import co.za.orodata.testbasefragment.viewmodels.SharedViewModel

class SharedFragment: BaseWithViewModelFragment<FragmentSharedBinding, SharedViewModel>(
    FragmentSharedBinding::inflate
) {
    override var useSharedViewModel = true  // share ViewModel

    override fun getViewModelClass() = co.za.orodata.testbasefragment.viewmodels.SharedViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to next
        binding.goHome.setOnClickListener {
            sharedViewModel.saveGossip(binding.etShared.text.toString())
            findNavController().navigate(R.id.action_sharedFragment_to_homeFragment)
        }

        sharedViewModel.gossip.observe(viewLifecycleOwner, { gossip ->
            binding.etShared.setText(gossip)
        })
    }
}