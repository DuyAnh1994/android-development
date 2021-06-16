package com.dev.anhnd.android_algorithm

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one: Deferred<Unit> = async {
            delay(1000)
            println("1")
        }
        val two: Deferred<Unit> = async {
            println("2")
        }
        println("$one   $two")
    }
    println("time: $time")
}

