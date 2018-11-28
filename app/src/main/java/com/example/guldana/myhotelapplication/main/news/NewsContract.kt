package com.example.guldana.myhotelapplication.main.news

import com.example.guldana.myhotelapplication.base.BasePresenter
import com.example.guldana.myhotelapplication.base.BaseView
import com.example.guldana.myhotelapplication.models.News

interface NewsContract {
    interface View : BaseView<Presenter> {
        fun newsShow(newsList: ArrayList<News>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadNews()
    }
}