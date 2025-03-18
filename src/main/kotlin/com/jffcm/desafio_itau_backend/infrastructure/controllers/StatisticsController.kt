package com.jffcm.desafio_itau_backend.infrastructure.controllers;

import com.jffcm.desafio_itau_backend.application.usecases.GetStatisticsUseCase
import com.jffcm.desafio_itau_backend.infrastructure.dto.StatisticsDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estatistica")
public class StatisticsController(
    private val getStatisticsUseCase: GetStatisticsUseCase,
) {

    @GetMapping
    fun getStatistics(): ResponseEntity<StatisticsDTO> {
        val statistics = getStatisticsUseCase.execute(60)
        return ResponseEntity(StatisticsDTO(statistics), HttpStatus.OK)
    }
}
