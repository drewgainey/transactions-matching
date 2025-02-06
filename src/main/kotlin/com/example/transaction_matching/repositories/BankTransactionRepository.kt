package com.example.transaction_matching.repositories

import com.example.transaction_matching.entities.BankTransaction
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BankTransactionRepository : JpaRepository<BankTransaction, UUID> {
}