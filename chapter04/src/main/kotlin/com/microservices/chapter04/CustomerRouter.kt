package com.microservices.chapter04

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.kotlin.core.publisher.toMono

@Component
class CustomerRouter {

    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/customer".nest {
                GET("/") {
//                    ServerResponse.ok().body("hello world".toMono(), String::class.java)
//                    ok().body("hello world".toMono(), String::class.java)   // 타입 추론에 의한 간략화
                    ok().body(Customer(1, "functional web").toMono(), Customer::class.java)
                }
            }
        }
    }

}