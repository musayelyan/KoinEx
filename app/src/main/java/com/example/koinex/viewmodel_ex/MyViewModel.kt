package com.example.koinex.viewmodel_ex

import androidx.lifecycle.ViewModel

class MyViewModel(private val repo: HelloRepository) : ViewModel() {

    fun sayHello() = repo.giveHello()
}