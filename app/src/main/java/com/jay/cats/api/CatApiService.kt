package com.jay.cats.api

import com.jay.cats.data.CatRepositoryImpl.Companion.DEFAULT_PAGE_SIZE
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {

    @GET("/v1/images/search")
    suspend fun getCatImages(
        @Query("size") size: String = "full",
        @Query("limit") limit: Int = DEFAULT_PAGE_SIZE,
        @Query("page") page: Int,
    ): List<GetCatImagesResponse>

}