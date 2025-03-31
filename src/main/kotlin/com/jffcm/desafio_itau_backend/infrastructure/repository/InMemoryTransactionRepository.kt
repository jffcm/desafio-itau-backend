package com.jffcm.desafio_itau_backend.infrastructure.repository;

import com.jffcm.desafio_itau_backend.application.repository.TransactionRepository
import com.jffcm.desafio_itau_backend.application.usecases.GetStatisticsOutput
import com.jffcm.desafio_itau_backend.domain.entity.Transaction
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentLinkedQueue

class InMemoryTransactionRepository: TransactionRepository {
    private val transactions = ConcurrentLinkedQueue<Transaction>()

    override fun receiveTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    override fun deleteAllTransactions() {
        transactions.clear()
    }

    override fun getStatistics(intervalInSeconds: Long): GetStatisticsOutput {
        val now = OffsetDateTime.now()
        val recentTransactions = transactions.filter { it.dataHora.isAfter(now.minusSeconds(intervalInSeconds)) }

        val count = recentTransactions.size.toLong()
        val sum = recentTransactions.sumOf { it.valor }
        val min = recentTransactions.minOfOrNull { it.valor } ?: 0.0
        val max = recentTransactions.maxOfOrNull { it.valor } ?: 0.0
        val avg = if (count > 0) sum / count else 0.0

        return GetStatisticsOutput(count, sum, avg, min, max)
    }
}
