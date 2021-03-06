package com.example.koinex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koinex.ex1.Student
import com.example.koinex.ex2.AppPreferences
import com.example.koinex.ex2.AppPreferences.Companion.PROFILE_NAME
import com.example.koinex.ex2.AppPreferences2
import com.example.koinex.ex4.HTTPClient
import com.example.koinex.simple.HelloServiceImpl
import com.example.koinex.viewmodel_ex.GameScreenViewModel
import com.example.koinex.viewmodel_ex.MyViewModel
import com.example.koinex.zvExample.Car
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.java.KoinJavaComponent.getKoin

@KoinApiExtension
class MainActivity : AppCompatActivity() {
    private val preferences: AppPreferences by inject()
    private val preferences2: AppPreferences2 by inject()
    private val helloServiceImpl: HelloServiceImpl by inject()

    private val myViewModel: MyViewModel by viewModel()
    private val gameScreenViewModel: GameScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentArsen = get<Student>()
        studentArsen.beSmart()

        //val preferences = get<AppPreferences>()
        //preferences.saveProfileName("Artur")
        preferences.saveProfileName("Artur")
        println(preferences.getProfileName(PROFILE_NAME))
        preferences2.saveProfileName("Musayelyan")
        println(preferences2.getProfileName(PROFILE_NAME))

//        val car = get<Car>()
//        car.carWork()

        //view model example
        //val helloServiceImpl: HelloServiceImpl = get<>()
        println(helloServiceImpl.sayHello())
        println(myViewModel.sayHello())
        println(gameScreenViewModel.getGames())

        // Example 4
        getKoin().setProperty("server_url", "www.vivarobet.am")
        val httpClient = get<HTTPClient>()
        httpClient.doCall()

        //ZvExample
        val car2 = get<Car>()
        car2.run()
    }
}