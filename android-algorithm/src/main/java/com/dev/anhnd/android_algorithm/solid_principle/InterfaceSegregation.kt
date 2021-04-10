package com.dev.anhnd.android_algorithm.solid_principle


/**
 * Interface segregation principle - phân tách
 * " Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với nhiều mục đích cụ thể "
 *
 *
 */

fun main() {

}


interface Subjects {
    fun maths()
    fun chemical()
}

interface PrimarySchoolSubject {
    fun maths()
}

interface HighSchoolSubject {
    fun chemical()
}

class PrimaryStudent : PrimarySchoolSubject {
    override fun maths() {
        println("primary student to study maths")
    }

//    override fun chemical() {
//        throw Exception("primary student do not need to study chemical")
//        // học sinh tiểu học ko cần thiết phải học hóa
//    }
}

class HighStudent : PrimarySchoolSubject, HighSchoolSubject {
    override fun maths() {
        println("high student to study maths")
    }

    override fun chemical() {
        println("high student to study chemical")
    }
}

