package com.example.transaction_matching.graphql

import com.example.transaction_matching.grpc.client.GetAccessTokensClient
import com.syncledger.grpc.TokenRequest
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class BankTransactionsSyncMutation(client : GetAccessTokensClient) {
    private var client: GetAccessTokensClient? = client

    @MutationMapping
    fun bankTransactionsSync() {
        val request = TokenRequest.newBuilder()
            .setAccount("your_account_identifier")
            .build()
        var token : String  = client.getAccessTokens(request)
        println("This works")

    }
}