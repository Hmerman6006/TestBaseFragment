package co.za.orodata.testbasefragment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.orodata.testbasefragment.R

class SharedViewModel: ViewModel() {

    private var _gossip = MutableLiveData("What?")
    val gossip: LiveData<String> = _gossip

    fun saveGossip(g: String) {
        _gossip.value = g
    }
}