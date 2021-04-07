package com.ruangaldo.video_youtube.utils

import com.ruangaldo.video_youtube.model.Article

object DataDummy {

    fun generateAudioArticleListDummy(): List<Article> {
        val articles = ArrayList<Article>()
        articles.add(
            Article(
                title = "Data 1",
                thumbnail = "https://cdn.akurat.co/images/uploads/images/akurat_20200302012538_46UhIZ.jpg",
                publishedDate = "17.00 WIB",
                status = "Premium"
            )
        )
        articles.add(
            Article(
                title = "Data 2",
                thumbnail = "https://cdn.akurat.co/images/uploads/images/akurat_20200302012538_46UhIZ.jpg",
                publishedDate = "17.00 WIB",
                status = "Premium"
            )
        )
        articles.add(
            Article(
                title = "Data 3",
                thumbnail = "https://cdn.akurat.co/images/uploads/images/akurat_20200302012538_46UhIZ.jpg",
                publishedDate = "17.00 WIB",
                status = "Premium"
            )
        )
        articles.add(
            Article(
                title = "Data 4",
                thumbnail = "https://cdn.akurat.co/images/uploads/images/akurat_20200302012538_46UhIZ.jpg",
                publishedDate = "17.00 WIB",
                status = "Premium"
            )
        )
        articles.add(
            Article(
                title = "Data 5",
                thumbnail = "https://cdn.akurat.co/images/uploads/images/akurat_20200302012538_46UhIZ.jpg",
                publishedDate = "17.00 WIB",
                status = "Premium"
            )
        )
        return articles
    }
}