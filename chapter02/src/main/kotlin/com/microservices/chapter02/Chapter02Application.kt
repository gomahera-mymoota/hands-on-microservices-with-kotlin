package com.microservices.chapter02

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

// @SpringBootApplication
// class Chapter02Application

// 1
// @Controller
// class FirstController(val exampleService: ExampleService) {
// 	@RequestMapping(value = arrayOf("/user/{name}"), method = arrayOf(RequestMethod.GET))
// 	@ResponseBody
// 	fun hello(@PathVariable name: String) = exampleService.getHello(name)
// }

// 2
// @Controller
// class FirstController {
// 	@Autowired
// 	lateinit var service: ExampleService

// 	@RequestMapping(value = arrayOf("/user/{name}"), method = arrayOf(RequestMethod.GET))
// 	@ResponseBody
// 	fun hello(@PathVariable name: String) = service.getHello(name)
// }


@SpringBootApplication
class Chapter02Application {

	@Bean
	@ConditionalOnExpression("#{'\${service.message.type}'=='simple'}")
	fun exampleService(): ServiceInterface = ExampleService()

	@Bean
	@ConditionalOnExpression("#{'\${service.message.type}'=='advanced'}")
	fun advancedService(): ServiceInterface = AdvancedService()

}

@Controller
class FirstController {

	@Autowired
	lateinit var service: ServiceInterface

	@RequestMapping(value = arrayOf("/user/{name}"), method = arrayOf(RequestMethod.GET))
	@ResponseBody
	fun hello(@PathVariable name: String) = service.getHello(name)	

}

fun main(args: Array<String>) {
	runApplication<Chapter02Application>(*args)
}
