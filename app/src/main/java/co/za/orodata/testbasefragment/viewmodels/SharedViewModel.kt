package co.za.orodata.testbasefragment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _gossip = MutableLiveData("What is going on?")
    val gossip: LiveData<String> = _gossip

    fun saveGossip(g: String) {
        _gossip.value = g
    }
}