package com.example.koinex.ex4

class ConfigRepoImpl : ConfigRepo {
    val serverUrl = "My Server url"
    override fun getServerConfig(): String = serverUrl

}