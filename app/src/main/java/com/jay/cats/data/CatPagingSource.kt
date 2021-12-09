package com.jay.cats.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jay.cats.api.CatApiService
import com.jay.cats.data.CatRepositoryImpl.Companion.DEFAULT_PAGE_INDEX
import com.jay.cats.model.Cat
import com.jay.cats.model.mapper.asUiModel
import retrofit2.HttpException
import java.io.IOException

class CatPagingSource(
    private val apiService: CatApiService,
) : PagingSource<Int, Cat>() {

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        val page = params.key ?: DEFAULT_PAGE_INDEX

        return try {
            val response = apiService.getCatImages(page = page)
            LoadResult.Page(
                data = response.map { it.asUiModel() },
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}