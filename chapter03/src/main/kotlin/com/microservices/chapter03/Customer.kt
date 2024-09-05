package com.microservices.chapter03

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

@JsonInclude(Include.NON_NULL)
data class Customer(var id: Int = 0, val name: String = "",
    var telephone: Telephone? = null) {

        data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
    
    }