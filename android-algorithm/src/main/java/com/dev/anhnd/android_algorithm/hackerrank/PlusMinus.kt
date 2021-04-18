package com.dev.anhnd.android_algorithm.hackerrank

import java.text.DecimalFormat

fun plusMinus(arr: Array<Int>) {
    val size = arr.size
    var positive = 0.0
    var negative = 0.0
    var zero = 0.0
    arr.forEach { v ->
        when {
            v > 0 -> {
                ++positive
            }
            v < 0 -> {
                ++negative
            }
            else -> {
                ++zero
            }
        }
    }
    val formatter = DecimalFormat("#0.000000")
    println("${formatter.format(positive / size)} \n${formatter.format(negative / size)}\n${formatter.format(zero / size)}")
}

fun main() {
    val arr = arrayOf(1, 1, 0, -1, -1)
    plusMinus(arr)
}
