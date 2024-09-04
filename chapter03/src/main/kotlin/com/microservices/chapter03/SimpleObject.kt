package com.microservices.chapter03

class SimpleObject {
    public val name = "hello"
    private val place = "world"
    private val planet = "earth"

    public fun getPlace() = place
    public fun getLocation() = planet
}