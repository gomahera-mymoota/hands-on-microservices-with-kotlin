package com.microservices.chapter06.configserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer


@SpringBootApplication
@EnableConfigServer
class ConfigserverApplication

fun main(args: Array<String>) {
	runApplication<ConfigserverApplication>(*args)
}
