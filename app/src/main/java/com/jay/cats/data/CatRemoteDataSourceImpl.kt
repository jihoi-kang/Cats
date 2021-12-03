package com.jay.cats.data

import com.jay.cats.api.CatApiService
import com.jay.cats.api.GetCatImagesResponse
import javax.inject.Inject

class CatRemoteDataSourceImpl @Inject constructor(
    private val apiService: CatApiService,
) : CatRemoteDataSource {

    override suspend fun getCatImages(page: Int): List<GetCatImagesResponse> =
        apiService.getCatImages(page = page)

}