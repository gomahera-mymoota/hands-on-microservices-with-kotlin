package com.microservice.chapter06.discoveryserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class DiscoveryserverApplication

fun main(args: Array<String>) {
	runApplication<DiscoveryserverApplication>(*args)
}
