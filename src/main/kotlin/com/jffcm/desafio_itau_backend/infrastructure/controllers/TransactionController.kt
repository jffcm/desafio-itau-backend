package com.jffcm.desafio_itau_backend.infrastructure.controllers

import com.jffcm.desafio_itau_backend.domain.entities.Transaction
import com.jffcm.desafio_itau_backend.application.usecases.DeleteAllTransactionsUseCase
import com.jffcm.desafio_itau_backend.application.usecases.ReceiveTransactionUseCase
import com.jffcm.desafio_itau_backend.infrastructure.dto.TransactionDTO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transacao")
class TransactionController(
    private val receiveTransactionUseCase: ReceiveTransactionUseCase,
    private val deleteAllTransactionsUseCase: DeleteAllTransactionsUseCase,
) {

    @PostMapping
    fun receiveTransaction(@Valid @RequestBody dto: TransactionDTO): ResponseEntity<Unit> {
        val transaction = Transaction(dto.valor, dto.dataHora)
        receiveTransactionUseCase.execute(transaction)

        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping
    fun deleteAllTransactions(): ResponseEntity<Unit> {
        deleteAllTransactionsUseCase.execute()

        return ResponseEntity(HttpStatus.OK)
    }
}