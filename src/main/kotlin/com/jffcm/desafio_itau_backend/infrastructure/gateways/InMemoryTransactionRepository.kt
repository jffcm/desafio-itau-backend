package com.jffcm.desafio_itau_backend.infrastructure.gateways;

import com.jffcm.desafio_itau_backend.application.gateways.TransactionRepository
import com.jffcm.desafio_itau_backend.domain.entities.Transaction
import java.time.OffsetDateTime
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

class InMemoryTransactionRepository: TransactionRepository {
    private val transactions = ConcurrentLinkedQueue<Transaction>()

    override fun receiveTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    override fun deleteAllTransactions() {
        transactions.clear()
    }

    override fun getStatistics(intervalInSeconds: Long): DoubleSummaryStatistics {
        val now = OffsetDateTime.now()

        return transactions.filter { transaction -> transaction.dataHora.isAfter(now.minusSeconds(intervalInSeconds)) }
            .fold(DoubleSummaryStatistics()) { statistics, transaction ->
                statistics.accept(transaction.valor!!)
                statistics
            }
    }
}
