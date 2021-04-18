package com.dev.anhnd.android_algorithm.hackerrank

import kotlin.math.abs


fun miniMaxSum(arr: Array<Int>) {
    var min = 0
    var max = 0
    arr.sort()
    arr.forEachIndexed { i, v ->
        println("$v")
        if (i < arr.size - 1) {
            min += v
        }
        if (i > 0) {
            max += v
        }
    }
    println("${abs(min)} ${abs(max)}")
}

fun main() {
//    val arr = arrayOf(1, 3, 5, 7, 9)
    val arr = arrayOf(256741038, 623958417, 467905213 ,714532089, 938071625)
    miniMaxSum(arr)
}