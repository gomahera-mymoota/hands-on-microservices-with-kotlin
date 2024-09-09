package com.microservices.chapter04

import org.springframework.stereotype.Component
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.ServerResponse.status
import org.springframework.web.reactive.function.BodyInserters.fromValue

@Component
class CustomerHandler(val customerService: CustomerService) {

    fun get(serverRequest: ServerRequest) =
        customerService.getCustomer(serverRequest.pathVariable("id").toInt())
            .flatMap { ok().body(fromValue(it)) }
            .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())    // status() 함수를 이용한 404 NOT FOUND 응답

    fun search(serverRequest: ServerRequest) = 
        ok().body(customerService.searchCustomers(
            serverRequest.queryParam("nameFilter").orElse("")), Customer::class.java)

}