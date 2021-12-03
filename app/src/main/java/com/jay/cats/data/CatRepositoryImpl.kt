package com.jay.cats.data

import com.jay.cats.api.GetCatImagesResponse
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val catRemoteDataSource: CatRemoteDataSource,
) : CatRepository {

    override suspend fun getCatImages(page: Int): List<GetCatImagesResponse> =
        catRemoteDataSource.getCatImages(page = page)
}