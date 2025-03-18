package com.jffcm.desafio_itau_backend.application.gateways

import com.jffcm.desafio_itau_backend.domain.entities.Transaction
import java.util.DoubleSummaryStatistics

interface TransactionRepository {
    fun receiveTransaction(transaction: Transaction)
    fun deleteAllTransactions()
    fun getStatistics(intervalInSeconds: Long): DoubleSummaryStatistics
}