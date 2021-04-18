package com.dev.anhnd.android_algorithm.hackerrank

fun staircase(n: Int) {
    var line = 1
    while (line <= n) {
        val builder = StringBuilder("")
        val empty = n - line
        for (j in 1..empty) {
            builder.append(" ")
        }
        for (i in 1..line) {
            builder.append("#")
        }
        println("$builder")
        line++
    }
}

fun main() {
    staircase(3)
}