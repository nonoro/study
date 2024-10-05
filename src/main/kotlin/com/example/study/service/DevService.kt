package com.example.study.service

class DevService : MyService {
    override fun get() {
        println("DevService 입니다")
    }

    override fun save(information: String) {
    }

    override fun delete(id: Long) {
    }

    override fun update(id: Long, updatedInformation: String) {
    }
}
