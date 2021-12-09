package com.jay.cats.data

import androidx.paging.PagingData
import com.jay.cats.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatRepository {

    fun letCatsFlow(): Flow<PagingData<Cat>>

}