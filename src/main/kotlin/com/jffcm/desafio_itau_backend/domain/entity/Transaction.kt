package com.jffcm.desafio_itau_backend.domain.entity

import java.time.OffsetDateTime

class Transaction(val valor: Double, val dataHora: OffsetDateTime) {
    init {
        require(valor >= 0) { "The 'valor' field must be greater than or equal to 0." }
        require(!dataHora.isAfter(OffsetDateTime.now())) { "The 'dataHora' field cannot be in the future." }
    }
}