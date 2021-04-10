package com.dev.anhnd.android_algorithm.solid_principle


/**
 * Liskov substitution principle - thay thế
 * " Trong một chương trình, các object của class con có thể thay thế class cha mà không làm thay
 * đổi tính đúng đắn của chương trình "
 *
 * Note: đây là nguyên tắt khó và trừu tượng nhất trong 5 nguyên tắc solid
 */

fun main() {

    /*val birds = listOf(Eagle(), Penguin())
    birds.forEach {
        it.fly()
    }*/

    val rectangle: Shape = Rectangle(2, 3)
    rectangle.area()

    val square: Shape = Square()
    square.apply {
        width = 2
        height = 3
        area() // this error
    }
}


//region Example 1: class con throw exception
abstract class Bird() {
    abstract fun fly()
}

class Eagle : Bird() {
    override fun fly() {
        println("Eagle fly")
    }
}

class Penguin : Bird() {
    override fun fly() {
        throw Exception("Penguin can't fly")
    }
}
//endregion


//region Example 2: class con thay đổi hành vi class cha

/*open class Rectangle(open var width: Int = 0,
                     open var height: Int = 0) {

    fun area() {
        println("area = width * height = $width * $height = " + width * height)
    }
}

class Square : Rectangle() {

    override var width: Int = 0
        get() = super.width
        set(value) {
            super.height = value
            super.width = value
            field = value
        }

    override var height: Int = 0
        get() = super.height
        set(value) {
            super.height = value
            super.width = value
            field = value
        }
}*/



abstract class Shape(open var width: Int = 0,
                     open var height: Int = 0) {

    fun area() {
        println("area = width * height = $width * $height = " + width * height)
    }
}

class Rectangle(width: Int, height: Int) : Shape(width, height)

class Square : Shape() {

    override var width: Int = 0
        get() = super.width
        set(value) {
            super.height = value
            super.width = value
            field = value
        }

    override var height: Int = 0
        get() = super.height
        set(value) {
            super.height = value
            super.width = value
            field = value
        }
}

//endregion

