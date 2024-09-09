package com.microservices.chapter04

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.ServerResponse.status
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.BodyInserters.fromValue

@Component
class CustomerHandler(val customerService: CustomerService) {

    fun get(serverRequest: ServerRequest) =
        customerService.getCustomer(serverRequest.pathVariable("id").toInt())   // ok().body()가 flatMap()으로 들어감에 유의
            .flatMap { ok().body(fromValue(it)) }   // getCustomer가 Mono<Customer>를 반환하기 때문에 map을 사용하면 Mono<Mono<Customer>>가 반환되므로 flatMap을 사용함
                                                    // flatMap()을 통해 Mono<Customer>가 Mono<Response>로 변환

}