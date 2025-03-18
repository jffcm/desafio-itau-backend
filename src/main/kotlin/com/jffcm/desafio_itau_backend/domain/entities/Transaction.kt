package com.jffcm.desafio_itau_backend.domain.entities

import java.time.OffsetDateTime

data class Transaction(val valor: Double?, val dataHora: OffsetDateTime)