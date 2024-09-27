package com.example.study.filter

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class MyFilter : Filter {
    override fun doFilter(
        request: ServletRequest?,
        response: ServletResponse?,
        chain: FilterChain?
    ) {
        log.info { "필터: 요청 전 처리" }
        chain?.doFilter(request, response)
        log.info { "필터: 요청 후 처리" }
    }
}
