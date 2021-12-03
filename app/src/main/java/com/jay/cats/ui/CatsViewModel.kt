package com.jay.cats.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.base.library.ui.BaseViewModel
import com.jay.cats.api.CatApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val apiService: CatApiService,
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            apiService.getCatImages(page = 1).map { Log.d("jay", "passed: ${it.url}") }
        }
    }

}
