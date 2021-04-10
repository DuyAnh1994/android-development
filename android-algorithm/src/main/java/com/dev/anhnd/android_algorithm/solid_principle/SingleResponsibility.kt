package com.dev.anhnd.android_algorithm.solid_principle


/**
 * Single responsibility principle - đơn chức năng
 * " Một class chỉ nên giữ 1 trách nhiệm duy nhất, chỉ có thể sửa đổi class với 1 lý do duy nhất "
 *
 */

fun main() {
    val student = Student("Student a", 20)
    println("student: $student")

    val formatter = Formatter()
    formatter.getInfoText(student)

    val store = Store()
    store.saveToFile(student)
}

// hiện tại class thực hiện quá nhiều việc
/*
class Student(val name: String, val age: Int) {

    fun getInfoText() {
        // coding
    }

    fun saveToFile() {
        // coding
    }
}
*/

data class Student(val name: String, val age: Int)

// class chỉ cho việc hiện thị thông tin
class Formatter {
    fun getInfoText(student: Student) {
        println("get info text")
    }
}

// class chỉ cho việc lưu trữ
class Store {
    fun saveToFile(student: Student) {
        println("set to file")
    }
}
