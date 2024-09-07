package com.microservices.chapter04

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body

@Component
class CustomerHandler(val customerService: CustomerService) {

    fun get(serverRequest: ServerRequest) =
//        ok().body(customerService.getCustomer(1), Customer::class.java)
    // nullable 객체를 반환하지 않도록 CustomerService 클래스를 구현했으므로 body()에서 클래스를 지정할 필요가 없다
    ok().body(customerService.getCustomer(serverRequest.pathVariable("id").toInt()))

}