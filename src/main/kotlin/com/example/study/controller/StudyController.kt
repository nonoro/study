package com.example.study.controller

import com.example.study.aop.LogExecutionTime
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger { }

@RestController
class StudyController {
    @LogExecutionTime
    @GetMapping("/test")
    fun filterTest() {
        log.info { "컨트롤러: 요청 처리" }
    }
}
