package com.microservices.chapter03

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class Chapter03Application 

fun main(args: Array<String>) {
	runApplication<Chapter03Application>(*args)
}
