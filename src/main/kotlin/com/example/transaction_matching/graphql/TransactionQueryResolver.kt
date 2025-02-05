package com.example.transaction_matching.graphql

import com.example.transaction_matching.entities.ErpTransaction
import com.example.transaction_matching.repositories.ErpTransactionRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class TransactionQueryResolver(private val transactionRepository: ErpTransactionRepository)   {
    @QueryMapping
    fun allTransactions(): List<ErpTransaction> = transactionRepository.findAll()
}