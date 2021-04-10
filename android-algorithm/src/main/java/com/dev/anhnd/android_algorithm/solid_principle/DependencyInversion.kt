package com.dev.anhnd.android_algorithm.solid_principle

/**
 * Dependency Inversion Principle - đảo ngược sự phụ thuộc
 * " 1. Các module cấp cao không nên phụ thuộc vào các modules cấp thấp. Cả 2 nên phụ thuộc vào
 *  interface
 *   2. Interface không nên chi tiết quá. Các class giao tiếp với nhau thông qua interface"
 *
 * Trong android sử dụng:
 *  + dagger (đã cũ) - hilt (suggestion từ google dựa trên dagger)
 *  + koin (phát triển trên kotlin) để loại bỏ sự phụ thuộc giữa các module.
 * Cả 2 cách trên đều đã có example cụ thể và đã được fix bug liên quan đến lifecycle
 *
 */


fun main() {
    val mySQL = MySQLConnection()
    val mongodb = MongodbConnection()
    DatabaseConfig(mySQL)
    DatabaseConfig(mongodb)
}

interface DBConnect {
    fun connect()
}

class MySQLConnection : DBConnect {
    override fun connect() {
        println("mysql connection")
    }
}

class MongodbConnection : DBConnect {
    override fun connect() {
        println("mongodb connection")
    }
}

class DatabaseConfig(connect: DBConnect) {
    init {
        connect.connect()
    }
}
