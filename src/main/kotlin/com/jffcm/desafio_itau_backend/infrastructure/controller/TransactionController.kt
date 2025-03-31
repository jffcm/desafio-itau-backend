package com.jffcm.desafio_itau_backend.infrastructure.controller

import com.jffcm.desafio_itau_backend.application.usecases.DeleteAllTransactionsUseCase
import com.jffcm.desafio_itau_backend.application.usecases.ReceiveTransactionInput
import com.jffcm.desafio_itau_backend.application.usecases.ReceiveTransactionUseCase
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
    fun receiveTransaction(@RequestBody input: ReceiveTransactionInput): ResponseEntity<Unit> {
        receiveTransactionUseCase.execute(input)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping
    fun deleteAllTransactions(): ResponseEntity<Unit> {
        deleteAllTransactionsUseCase.execute()
        return ResponseEntity(HttpStatus.OK)
    }
}