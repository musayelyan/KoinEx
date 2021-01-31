package com.example.koinex.ex1

import com.example.koinex.ex2.AppPreferences
import com.example.koinex.ex2.AppPreferences2
import com.example.koinex.ex3.Car
import com.example.koinex.ex3.DefaultEngine
import com.example.koinex.ex3.Engine
import com.example.koinex.ex4.ConfigRepo
import com.example.koinex.ex4.ConfigRepoImpl
import com.example.koinex.ex4.HTTPClient
import com.example.koinex.simple.HelloMessageData
import com.example.koinex.simple.HelloServiceImpl
import com.example.koinex.viewmodel_ex.*
import com.example.koinex.zvExample.BMWEngine
import com.example.koinex.zvExample.MercEngine
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
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

    //1-in tarberak
    single<ConfigRepo> { ConfigRepoImpl() }
    //single { HTTPClient(ConfigRepoImpl().serverUrl) }
    // 2-rd tarberak - properties
    single { HTTPClient(getProperty("server_url")) }

}

//Ex2
@OptIn(KoinApiExtension::class)
val applicationModule = module {
    single { AppPreferences(androidContext()) }
    single { AppPreferences2() }
}

//Ex3
val carModule = module {
    factory<Engine> { DefaultEngine() }
    factory { Car(get()) }
}

// simple Example
val helloModule = module {
    factory { HelloMessageData() }
    factory { HelloServiceImpl(get()) }
}

val zvExampleModuls = module {
//    factory<com.example.koinex.zvExample.Engine> { MercEngine() }
//    factory<com.example.koinex.zvExample.Engine> { BMWEngine() }
    factory<com.example.koinex.zvExample.Engine> { BMWEngine() }
    factory<com.example.koinex.zvExample.Engine>(override = true) { MercEngine() }

    factory { com.example.koinex.zvExample.Car(get()) }
}

