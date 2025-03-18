package com.jffcm.desafio_itau_backend.infrastructure.dto

import java.util.DoubleSummaryStatistics

class StatisticsDTO(
    private val statistics: DoubleSummaryStatistics,
) {
    val count = statistics.count
    val sum = statistics.sum
    val avg = statistics.average
    val min =  if (statistics.min == Double.MIN_VALUE) 0.0 else statistics.min
    val max = if (statistics.max == Double.MAX_VALUE) 0.0 else statistics.max
}