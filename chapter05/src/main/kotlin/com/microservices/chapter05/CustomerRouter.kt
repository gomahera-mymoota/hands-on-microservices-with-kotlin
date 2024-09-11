package com.microservices.chapter05

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.router


@Component
class CustomerRouter(private val customerHandler: CustomerHandler) {

    @Bean
    fun customerRoutes() = router {
        "/customer".nest {
            GET("/{id}", customerHandler::get)
            POST("/", customerHandler::create)
        }
    }
    
}