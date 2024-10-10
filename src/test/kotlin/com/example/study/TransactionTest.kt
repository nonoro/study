package com.example.study

import com.example.study.service.TransactionService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionTest(
    @Autowired private val transactionService: TransactionService,
) {
    @Test
    fun test() {
        transactionService.transactionIsFalse()
    }
}
