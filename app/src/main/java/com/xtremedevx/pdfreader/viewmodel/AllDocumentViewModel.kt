package com.xtremedevx.pdfreader.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtremedevx.pdfreader.data.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllDocumentViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    fun fetchPdf() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllDocumentFromStorage()
        }
    }
}