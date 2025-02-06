package com.example.transaction_matching.service

import com.example.transaction_matching.repositories.BankTransactionRepository
import com.plaid.client.request.PlaidApi
import org.springframework.stereotype.Service

@Service
class BankTransactionService(
    private val bankTransactionRepository: BankTransactionRepository,
    private val plaidApi: PlaidApi) {

    fun syncTransactionsAndSaveToDb(itemId: String, accessToken: String) : Boolean {
        println("Item Id: $itemId Access Token: $accessToken")
        return true
    }
}