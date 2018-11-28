package com.example.guldana.myhotelapplication.main.news

import com.example.guldana.myhotelapplication.models.News
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NewsPresenter(override var view: NewsContract.View?) :
        NewsContract.Presenter {

    val mDatabase = FirebaseDatabase.getInstance().getReference("newses")

    override fun loadNews() {
        val newsList = ArrayList<News>()
        mDatabase.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(n in p0.children){
                        val news = n.getValue(News::class.java)
                        newsList.add(news!!)
                    }
                }
                view?.newsShow(newsList)
            }
        })

    }

}