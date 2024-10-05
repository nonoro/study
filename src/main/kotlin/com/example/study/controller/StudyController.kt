package com.example.study.controller

import com.example.study.aop.LogExecutionTime
import com.example.study.service.MyService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger { }

@RestController
class StudyController(
    private val myService: MyService
) {
    @LogExecutionTime
    @GetMapping("/test")
    fun filterTest() {
        log.info { "컨트롤러: 요청 처리" }
    }

    @GetMapping("/test2")
    fun beanTest() {
        myService.get()
    }
}
