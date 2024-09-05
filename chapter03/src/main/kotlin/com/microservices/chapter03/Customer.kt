package com.microservices.chapter03

data class Customer(var id: Int = 0, val name: String = "",
    var telephone: Telephone? = null) {

        data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
    
    }