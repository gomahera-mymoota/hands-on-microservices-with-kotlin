package com.microservices.chapter03

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class JsonExamplesController {

    @GetMapping("/json")
    fun getJson() = ComplexObject(object1 = SimpleObject("more", "complex"))
}