package com.jffcm.desafio_itau_backend.application.usecases;

import com.jffcm.desafio_itau_backend.application.repository.TransactionRepository
import com.jffcm.desafio_itau_backend.domain.entity.Transaction
import java.time.OffsetDateTime

class ReceiveTransactionUseCase(private val transactionRepository: TransactionRepository) {
    fun execute(input: ReceiveTransactionInput) {
        val transaction = Transaction(input.valor, input.dataHora)
        transactionRepository.receiveTransaction(transaction)
    }
}

data class ReceiveTransactionInput(
    val valor: Double,
    val dataHora: OffsetDateTime
)