package com.jay.cats.data

import com.jay.cats.api.GetCatImagesResponse

interface CatRemoteDataSource {

    suspend fun getCatImages(page: Int): List<GetCatImagesResponse>

}