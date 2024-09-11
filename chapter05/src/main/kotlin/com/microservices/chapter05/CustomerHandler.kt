package com.microservices.chapter05

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import java.net.URI


@Component
class CustomerHandler(val customerService: CustomerService) {

    fun get(serverRequest: ServerRequest) =
        customerService.getCustomer(serverRequest.pathVariable("id").toInt())
            .flatMap { ok().body(fromValue(it)) }
            .switchIfEmpty(notFound().build())

    fun create(serverRequest: ServerRequest) = 
        customerService.createCustomer(serverRequest.bodyToMono())
            .flatMap { created(URI.create("/customer/${it.id}")).build() }
            
}