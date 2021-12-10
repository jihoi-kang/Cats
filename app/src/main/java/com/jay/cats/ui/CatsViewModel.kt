package com.jay.cats.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.base.library.ui.BaseViewModel
import com.jay.cats.data.CatRepository
import com.jay.cats.model.Cat
import com.jay.cats.model.mapper.asUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val catRepository: CatRepository,
) : BaseViewModel() {

    fun fetchCats(): Flow<PagingData<Cat>> {
        return catRepository.letCatsFlow()
            .map { list -> list.map { it.asUiModel() } }
            .cachedIn(viewModelScope)
    }

}
