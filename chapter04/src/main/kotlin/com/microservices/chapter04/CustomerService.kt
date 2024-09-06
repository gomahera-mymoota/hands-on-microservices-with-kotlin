package com.microservices.chapter04

interface CustomerService {

    fun getCustomer(id: Int): Customer?
    fun searchCustomers(nameFilter: String): List<Customer>
    
}