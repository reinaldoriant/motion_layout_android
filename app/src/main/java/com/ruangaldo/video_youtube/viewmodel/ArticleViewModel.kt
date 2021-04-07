package com.ruangaldo.video_youtube.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruangaldo.video_youtube.model.Article
import com.ruangaldo.video_youtube.utils.DataDummy

class ArticleViewModel : ViewModel() {

    fun getDummyAudioArticles(): LiveData<List<Article>> {
        val audioArticleResults = MutableLiveData<List<Article>>()
        audioArticleResults.postValue(DataDummy.generateAudioArticleListDummy())
        return audioArticleResults
    }
}