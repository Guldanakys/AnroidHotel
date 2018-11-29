package com.example.guldana.myhotelapplication.di

import com.example.guldana.myhotelapplication.login.LoginContract
import com.example.guldana.myhotelapplication.login.LoginPresenter
import com.example.guldana.myhotelapplication.main.bookings.BookingsContract
import com.example.guldana.myhotelapplication.main.bookings.BookingsPresenter
import com.example.guldana.myhotelapplication.main.hotelRooms.RoomsContract
import com.example.guldana.myhotelapplication.main.hotelRooms.RoomsPresenter
import com.example.guldana.myhotelapplication.main.news.NewsContract
import com.example.guldana.myhotelapplication.main.news.NewsPresenter
import com.example.guldana.myhotelapplication.register.RegistrationContract
import com.example.guldana.myhotelapplication.register.RegistrationPresenter
import org.koin.dsl.module.module

val appModule = module {

    factory { (view: LoginContract.View) -> LoginPresenter(view) as LoginContract.Presenter }
    factory { (view: RegistrationContract.View) -> RegistrationPresenter(view) as RegistrationContract.Presenter }
    factory { (view: NewsContract.View) -> NewsPresenter(view) as NewsContract.Presenter }
    factory { (view: RoomsContract.View) -> RoomsPresenter(view) as RoomsContract.Presenter }
    factory { (view: BookingsContract.View) -> BookingsPresenter(view) as BookingsContract.Presenter }
}

val hotelApp = listOf(appModule)