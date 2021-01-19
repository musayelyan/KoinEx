package com.example.koinex.ex1

import com.example.koinex.ex2.AppPreferences
import com.example.koinex.ex2.AppPreferences2
import com.example.koinex.ex3.Car
import com.example.koinex.ex3.DefaultEngine
import com.example.koinex.ex3.Engine
import com.example.koinex.simple.HelloMessageData
import com.example.koinex.simple.HelloServiceImpl
import com.example.koinex.viewmodel_ex.HelloRepository
import com.example.koinex.viewmodel_ex.HelloRepositoryImpl
import com.example.koinex.viewmodel_ex.MyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module

//Ex 1, viemmodelEx
val appModule = module {
    single { SchoolCourse() }
    factory { Friend() }
    factory { Student(get(), get()) }
    factory { Teacher() }
    factory { School(get()) }
    //factory { Person(get(),) }

    single<HelloRepository> { HelloRepositoryImpl() }
    viewModel { MyViewModel(get()) }
}

//Ex2
@OptIn(KoinApiExtension::class)
val applicationModule = module {
    single { AppPreferences(androidContext()) }
    single { AppPreferences2() }
}

//Ex3
val carModule = module {
    factory { DefaultEngine() as Engine }
    factory { Car(get()) }
}

// simple Example
val helloModule = module {
    factory { HelloMessageData() }
    factory { HelloServiceImpl(get()) }
}

