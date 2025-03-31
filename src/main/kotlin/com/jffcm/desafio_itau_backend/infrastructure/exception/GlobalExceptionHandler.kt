package com.jffcm.desafio_itau_backend.infrastructure.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<Unit> {
        e.printStackTrace()
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}