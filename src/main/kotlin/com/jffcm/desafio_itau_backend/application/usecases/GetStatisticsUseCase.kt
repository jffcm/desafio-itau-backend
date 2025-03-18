package com.jffcm.desafio_itau_backend.application.usecases

import com.jffcm.desafio_itau_backend.application.gateways.TransactionRepository
import java.util.DoubleSummaryStatistics

class GetStatisticsUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(seconds: Long): DoubleSummaryStatistics {
        return transactionRepository.getStatistics(seconds)
    }
}