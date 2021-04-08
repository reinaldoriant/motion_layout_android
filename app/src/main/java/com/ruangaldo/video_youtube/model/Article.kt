package com.ruangaldo.video_youtube.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val title: String,
    val thumbnail: String,
    val publishedDate: String,
    val status: String
) : Parcelable