package com.microservices.chapter04

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.kotlin.core.publisher.toMono

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
@Component
class CustomerRouter {

    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/customer".nest {
                GET("/") {
                    it: ServerRequest ->
                        ok().body(Customer(1, "functional web").toMono(), Customer::class.java)
                }
            }
        }
    }

}