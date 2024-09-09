package com.microservices.chapter04

class CustomerExistsException(override val message: String) : Exception(message)