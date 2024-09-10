package com.microservices.chapter05

import org.springframework.data.repository.reactive.ReactiveCrudRepository


interface CustomerRepository : ReactiveCrudRepository<Customer, Int>