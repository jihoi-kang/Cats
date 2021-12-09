package com.jay.cats.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.base.library.ui.BaseViewModel
import com.jay.cats.data.CatRepository
import com.jay.cats.model.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val catRepository: CatRepository,
) : BaseViewModel() {

    fun fetchCats(): Flow<PagingData<Cat>> {
        return catRepository.letCatsFlow().cachedIn(viewModelScope)
    }

}
