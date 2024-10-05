package com.example.study.service

interface MyService {
    fun get()

    fun save(information: String)

    fun delete(id: Long)

    fun update(id: Long, updatedInformation: String)
}
