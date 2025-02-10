package com.example.transaction_matching.grpc.client

import com.syncledger.grpc.GetAccessTokensGrpc
import com.syncledger.grpc.TokenRequest
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.stereotype.Component

@Component
class GetAccessTokensClient {
    private var chanel: ManagedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
        .usePlaintext().build()

    fun getAccessTokens(tokenRequest: TokenRequest) : String {
        GetAccessTokensGrpc.newBlockingStub(chanel).getTokens(tokenRequest).let {
            return it.accessToken
        }
    }
}