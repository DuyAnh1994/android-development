package com.dev.anhnd.android_algorithm.solid_principle


/**
 * Open-Closed principle - đóng mở
 * " Có thể thoải mái mở rộng 1 class, nhưng không được sửa đổi bên trong class đó "
 *
 */

fun main() {

}

/*
class Employee(val name: String, val rank: Int) {

    fun salary() {
        if (rank > 2) {
            println("salary: 1000$")
        } else {
            println("salary: 800$")
        }
    }
}
*/

open class Employee(val name: String) {

    open fun salary() {
        println("salary")
    }
}

class Business(name: String) : Employee(name) {
    override fun salary() {
        println("salary: 1000$")
    }
}

class Marketing(name: String) : Employee(name) {
    override fun salary() {
        println("salary: 800$")
    }
}
