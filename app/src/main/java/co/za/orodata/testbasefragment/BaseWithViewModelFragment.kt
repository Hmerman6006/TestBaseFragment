package co.za.orodata.testbasefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.IllegalArgumentException

abstract class BaseWithViewModelFragment<VB: ViewBinding, VM: ViewModel>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
): Fragment() {

    open var useSharedViewModel: Boolean = false

    private lateinit var _sharedViewModel: VM
    protected abstract fun getViewModelClass(): Class<VM>

    val sharedViewModel: VM
        get() = _sharedViewModel

    private var _binding: VB? = null

    val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeData()
    }

    open fun setUpViews() {}

    open fun observeView() {}

    open fun observeData() {}

    private fun init() {
        _sharedViewModel = if (useSharedViewModel) {
            ViewModelProvider(requireActivity()).get(
                getViewModelClass()
            )
        } else {
            ViewModelProvider(this).get(getViewModelClass())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}