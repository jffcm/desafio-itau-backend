package com.jffcm.desafio_itau_backend.application.usecases

import com.jffcm.desafio_itau_backend.application.repository.TransactionRepository

class GetStatisticsUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(intervalInSeconds: Long): GetStatisticsOutput {
        return transactionRepository.getStatistics(intervalInSeconds)
    }
}

data class GetStatisticsOutput(
    val count: Long,
    val sum: Double,
    val avg: Double,
    val min: Double,
    val max: Double
)

