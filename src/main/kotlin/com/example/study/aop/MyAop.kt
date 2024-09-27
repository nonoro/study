package com.example.study.aop

import io.github.oshai.kotlinlogging.KotlinLogging
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.aspectj.lang.ProceedingJoinPoint

private val log = KotlinLogging.logger {}

@Aspect
@Component
class MyAop {
    @Around("@annotation(LogExecutionTime)")
    fun executionTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()
        log.info { "AOP: 실행된 메서드 명: ${joinPoint.signature} / 시작시간: ${start}ms" }

        val proceed = joinPoint.proceed()

        val end = System.currentTimeMillis()
        log.info { "AOP: 실행된 메서드 명: ${joinPoint.signature} / 종료시간: ${end}ms" }

        return proceed
    }
}
