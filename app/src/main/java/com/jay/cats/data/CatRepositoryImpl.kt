package com.jay.cats.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jay.cats.api.CatApiService
import com.jay.cats.api.GetCatImagesResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val apiService: CatApiService,
) : CatRepository {

    override fun letCatsFlow(): Flow<PagingData<GetCatImagesResponse>> {
        return Pager(
            config = getDefaultPageConfig(),
            pagingSourceFactory = { CatPagingSource(apiService = apiService) }
        ).flow
    }

    private fun getDefaultPageConfig(): PagingConfig =
        PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)

    companion object {
        const val DEFAULT_PAGE_INDEX = 1
        const val DEFAULT_PAGE_SIZE = 20
    }

}