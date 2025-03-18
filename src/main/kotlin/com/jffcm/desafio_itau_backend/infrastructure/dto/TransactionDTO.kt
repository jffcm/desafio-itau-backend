package com.jffcm.desafio_itau_backend.infrastructure.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.PositiveOrZero
import java.time.OffsetDateTime

data class TransactionDTO(
    @field:NotNull
    @field:PositiveOrZero
    val valor: Double?,

    @field:NotNull
    @field:PastOrPresent
    val dataHora: OffsetDateTime
)
