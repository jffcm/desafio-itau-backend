package com.jffcm.desafio_itau_backend.config;

import com.jffcm.desafio_itau_backend.application.gateways.TransactionRepository
import com.jffcm.desafio_itau_backend.application.usecases.DeleteAllTransactionsUseCase
import com.jffcm.desafio_itau_backend.application.usecases.ReceiveTransactionUseCase
import com.jffcm.desafio_itau_backend.infrastructure.gateways.InMemoryTransactionRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration;

@Configuration
class TransactionConfig {

    @Bean
    fun receiveTransactionUseCase(transactionRepository: TransactionRepository): ReceiveTransactionUseCase {
        return ReceiveTransactionUseCase(transactionRepository)
    }

    @Bean
    fun deleteAllTransactionsUseCase(transactionRepository: TransactionRepository): DeleteAllTransactionsUseCase {
        return DeleteAllTransactionsUseCase(transactionRepository)
    }

    @Bean
    fun transactionRepository(): TransactionRepository {
        return InMemoryTransactionRepository()
    }
}
