package co.za.orodata.testbasefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.IllegalArgumentException

/**
 * Base fragment with ViewBinding
 * */
abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
): Fragment() {

    private var _binding: VB? = null

    val binding: VB
    get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        if (_binding == null) {
            throw IllegalArgumentException("Uninitialised binding exception")
        }

        return binding.root
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}