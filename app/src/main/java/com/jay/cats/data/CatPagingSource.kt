package com.jay.cats.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jay.cats.api.CatApiService
import com.jay.cats.api.GetCatImagesResponse
import com.jay.cats.data.CatRepositoryImpl.Companion.DEFAULT_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class CatPagingSource(
    private val apiService: CatApiService,
) : PagingSource<Int, GetCatImagesResponse>() {

    override fun getRefreshKey(state: PagingState<Int, GetCatImagesResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetCatImagesResponse> {
        val page = params.key ?: DEFAULT_PAGE_INDEX

        return try {
            val data = apiService.getCatImages(page = page, limit = params.loadSize)
            LoadResult.Page(
                data = data,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}