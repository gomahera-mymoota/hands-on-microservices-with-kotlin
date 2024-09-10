package com.microservices.chapter05

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import jakarta.annotation.PostConstruct


@Component
class DatabaseInitializer {

    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    @PostConstruct
    fun initData() {
        mongoOperations.collectionExists("Customers").subscribe {
            if (it != true) {
                mongoOperations.createCollection("Customers").subscribe {
                    println("  :::  Customers collection created")
                }
            } else println("  :::  Customers collection already exists")                
        }
    }

}