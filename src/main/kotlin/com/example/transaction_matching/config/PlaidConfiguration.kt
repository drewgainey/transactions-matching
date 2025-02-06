package com.example.transaction_matching.config

import com.plaid.client.ApiClient
import com.plaid.client.request.PlaidApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PlaidConfiguration {
    @Value("\${plaid.clientId}")
    private val clientId: String? = null

    @Value("\${plaid.secret}")
    private val secret: String? = null

    @Bean
    fun plaidApi(): PlaidApi {
        val apiKeys = HashMap<String, String?>()
        apiKeys["clientId"] = clientId
        apiKeys["secret"] = secret
        val apiClient = ApiClient(apiKeys)
        apiClient.setPlaidAdapter(ApiClient.Sandbox)
        return apiClient.createService(PlaidApi::class.java)
    }
}