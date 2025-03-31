package com.jffcm.desafio_itau_backend.infrastructure.controller;

import com.jffcm.desafio_itau_backend.application.usecases.GetStatisticsOutput
import com.jffcm.desafio_itau_backend.application.usecases.GetStatisticsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estatistica")
class StatisticsController(private val getStatisticsUseCase: GetStatisticsUseCase) {
    @GetMapping
    fun getStatistics(): ResponseEntity<GetStatisticsOutput> {
        val output = getStatisticsUseCase.execute(60)
        return ResponseEntity(output, HttpStatus.OK)
    }
}
