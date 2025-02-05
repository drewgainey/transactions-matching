package com.example.transaction_matching.entities

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "erp_transactions")
data class ErpTransaction (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = UUID.randomUUID(),
    val erpTransactionId: String = "",
    val amount: Double = 0.0,
    val description: String = ""
)