package com.example.study.config

import com.example.study.interceptor.MyInterceptor
import com.example.study.service.DevService
import com.example.study.service.MyService
import com.example.study.service.ProdService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebConfig : WebMvcConfigurer {
    @Value("\${app.environment}")
    lateinit var environment: String

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(MyInterceptor())
            .addPathPatterns("/**")
    }

    @Bean
    fun myService(): MyService {
        return when (environment) {
            "dev" -> DevService("개발환경")
            "prod" -> ProdService("운영환경")
            else -> throw IllegalArgumentException("존재하지 않는 환경입니다: $environment")
        }
    }
}
