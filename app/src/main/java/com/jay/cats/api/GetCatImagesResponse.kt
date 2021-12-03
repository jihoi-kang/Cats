package com.jay.cats.api

import com.google.gson.annotations.SerializedName

data class GetCatImagesResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String
)