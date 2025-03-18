package com.jffcm.desafio_itau_backend.config

import com.jffcm.desafio_itau_backend.application.gateways.TransactionRepository
import com.jffcm.desafio_itau_backend.application.usecases.GetStatisticsUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StatisticsConfig {
    
    @Bean
    fun getStatisticsUseCase(transactionRepository: TransactionRepository): GetStatisticsUseCase {
        return GetStatisticsUseCase(transactionRepository)
    }
}