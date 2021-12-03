package com.jay.cats.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {

    @GET("/v1/images/search")
    suspend fun getCatImages(
        @Query("size") size: String = "full",
        @Query("limit") limit: Int = 20,
        @Query("page") page: Int,
    ): List<GetCatImagesResponse>

}