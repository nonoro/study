package com.example.study.service

import io.github.oshai.kotlinlogging.KotlinLogging

private val log = KotlinLogging.logger {}

class DevService(
    private val message: String
) : MyService {
    override fun get() {
        log.info { "DevService 입니다" }
        log.info { "message: $message" }
    }

    override fun save(information: String) {
    }

    override fun delete(id: Long) {
    }

    override fun update(id: Long, updatedInformation: String) {
    }
}
