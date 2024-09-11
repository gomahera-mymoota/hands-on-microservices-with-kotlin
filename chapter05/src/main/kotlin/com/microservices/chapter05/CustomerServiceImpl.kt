package com.microservices.chapter05

import reactor.core.publisher.Mono
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired


@Service
class CustomerServiceImpl : CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int) = customerRepository.findById(id)

    override fun createCustomer(customer: Mono<Customer>) = customerRepository.create(customer)

}