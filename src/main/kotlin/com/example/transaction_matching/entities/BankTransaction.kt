package com.example.transaction_matching.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "bank_transactions")
data class BankTransaction (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id : UUID? = UUID.randomUUID(),
    private val transactionId: String? = null,
    private val merchantName: String? = null,
    private val category: String? = null,
    private val amount: Double? = null,
    private val currency: String? = null,
    private val date: LocalDate? = null,
)