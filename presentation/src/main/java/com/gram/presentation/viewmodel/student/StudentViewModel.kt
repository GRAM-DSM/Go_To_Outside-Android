package com.gram.presentation.viewmodel.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(
) : ViewModel() {

    init {
        getPassData()
    }

    private val _shouldShowProgressBar = MutableLiveData(true)
    val shouldShowProgressBar: LiveData<Boolean>
        get() = _shouldShowProgressBar

    private fun getPassData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {

            }.onSuccess {
                _shouldShowProgressBar.postValue(false)

            }.onFailure {

            }.also {
            }
        }
    }
}
}