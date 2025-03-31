package com.jffcm.desafio_itau_backend.application.repository

import com.jffcm.desafio_itau_backend.application.usecases.GetStatisticsOutput
import com.jffcm.desafio_itau_backend.domain.entity.Transaction

interface TransactionRepository {
    fun receiveTransaction(transaction: Transaction)
    fun deleteAllTransactions()
    fun getStatistics(intervalInSeconds: Long): GetStatisticsOutput
}