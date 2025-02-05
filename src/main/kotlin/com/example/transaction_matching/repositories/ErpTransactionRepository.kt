package com.example.transaction_matching.repositories

import com.example.transaction_matching.entities.ErpTransaction
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ErpTransactionRepository : JpaRepository<ErpTransaction, UUID> {
}