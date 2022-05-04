package co.za.orodata.testbasefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import co.za.orodata.testbasefragment.databinding.FragmentNextBinding
import co.za.orodata.testbasefragment.viewmodels.SharedViewModel

class NextFragment: BaseWithViewModelFragment<FragmentNextBinding, SharedViewModel>(
    FragmentNextBinding::inflate
) {
    override var useSharedViewModel = false

    override fun getViewModelClass() = SharedViewModel::class.java
//    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to next
        binding.backBtn.setOnClickListener {
            sharedViewModel.saveGossip(binding.etNext.text.toString())
            findNavController().navigate(R.id.action_nextFragment_to_homeFragment)
        }

        sharedViewModel.gossip.observe(viewLifecycleOwner, { gossip ->
            binding.etNext.setText(gossip)
        })
    }
}