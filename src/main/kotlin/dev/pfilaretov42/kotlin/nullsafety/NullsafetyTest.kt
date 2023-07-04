package dev.pfilaretov42.kotlin.nullsafety

fun interface MyInterface {
    fun test(param: Any): Int
}

abstract class MyAbstractClass {
    abstract fun abstractTest(param: Any): Int

    fun test(param: Any): Int {
        println("param=$param")
        return 42
    }
}

open class MyClass {
    fun test(param: Any): Int {
        println("param=$param")
        return 42
    }
}