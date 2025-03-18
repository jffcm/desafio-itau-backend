package com.jffcm.desafio_itau_backend.application.usecases;

import com.jffcm.desafio_itau_backend.domain.entities.Transaction
import com.jffcm.desafio_itau_backend.application.gateways.TransactionRepository

class ReceiveTransactionUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(transaction: Transaction) {
        transactionRepository.receiveTransaction(transaction)
    }
}