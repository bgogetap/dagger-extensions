package com.brandongogetap.daggerextensions.sample.counter

class Counter {

    private var count = 0

    fun getCount() = count

    fun incrementAndGetCount() = ++count
}