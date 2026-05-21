package com.example.jdr_android

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform