package com.example.koinex.ex1

import com.example.koinex.ex2.AppPreferences
import com.example.koinex.ex2.AppPreferences2
import com.example.koinex.ex3.Car
import com.example.koinex.ex3.DefaultEngine
import com.example.koinex.ex4.ConfigRepo
import com.example.koinex.ex4.ConfigRepoImpl
import com.example.koinex.ex4.HTTPClient
import com.example.koinex.simple.HelloMessageData
import com.example.koinex.simple.HelloServiceImpl
import com.example.koinex.viewmodel_ex.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.qualifier.named
import org.koin.dsl.module

//Ex 1, viemmodelEx, Ex4
val appModule = module {
    single { SchoolCourse() }
    factory { Friend() }
    factory { Student(get(), get()) }
    factory { Teacher() }
    factory { School(get()) }
    //factory { Person(get(),) }

    single<HelloRepository> { HelloRepositoryImpl() }
    viewModel { MyViewModel(get()) }
    factory<GameRepository> { GameRepositoryImpl() }
    viewModel { GameScreenViewModel(get()) }

    single<ConfigRepo> { ConfigRepoImpl() }
    //1-in tarberak
    //single { HTTPClient(ConfigRepoImpl().serverUrl) }
    // 2-rd tarberak - properties
    single { (named("serverUrl")) }
    single { HTTPClient(getProperty("serverUrl")) }

}

//Ex2
@OptIn(KoinApiExtension::class)
val applicationModule = module {
    single { AppPreferences(androidContext()) }
    single { AppPreferences2() }
}

//Ex3
val carModule = module {
    factory { DefaultEngine() }
    factory { Car(get()) }
}

// simple Example
val helloModule = module {
    factory { HelloMessageData() }
    factory { HelloServiceImpl(get()) }
}

