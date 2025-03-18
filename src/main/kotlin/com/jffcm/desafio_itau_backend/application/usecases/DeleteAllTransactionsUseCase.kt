package com.jffcm.desafio_itau_backend.application.usecases;

import com.jffcm.desafio_itau_backend.application.gateways.TransactionRepository

class DeleteAllTransactionsUseCase(private val transactionRepository: TransactionRepository) {
    fun execute() {
        transactionRepository.deleteAllTransactions()
    }
}
