package com.jay.cats.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base.library.ui.BaseViewModel
import com.jay.cats.api.CatApiService
import com.jay.cats.model.Cat
import com.jay.cats.model.mapper.asUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val apiService: CatApiService,
) : BaseViewModel() {

    private val _cats = MutableLiveData<List<Cat>>()
    val cats: LiveData<List<Cat>> get() = _cats

    init {
        viewModelScope.launch {
            _cats.value = apiService.getCatImages(page = 1).map { it.asUiModel() }
        }
    }

}
