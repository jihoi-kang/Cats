package com.jay.cats.model.mapper

import com.jay.cats.api.GetCatImagesResponse
import com.jay.cats.model.Cat

fun GetCatImagesResponse.asUiModel(): Cat = Cat(imageUrl = url)