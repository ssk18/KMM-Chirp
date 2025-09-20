package com.ssk.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform