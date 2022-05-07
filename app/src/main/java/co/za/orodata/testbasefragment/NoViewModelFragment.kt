package co.za.orodata.testbasefragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import co.za.orodata.testbasefragment.databinding.FragmentNoViewModelBinding

class NoViewModelFragment: BaseFragment<FragmentNoViewModelBinding>(
    FragmentNoViewModelBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to next
        binding.goNext.setOnClickListener {
            findNavController().navigate(R.id.action_noViewModelFragment_to_nextFragment)
        }
    }
}