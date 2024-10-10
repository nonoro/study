package com.example.study.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager



@Service
class TransactionServiceV2 {

    @Transactional
    fun transactionIsTrue() {
        println("트랜잭션 적용된 메서드 호출")
        logTransactionStatus()
    }

    private fun logTransactionStatus() {
        val isTransaction = TransactionSynchronizationManager.isActualTransactionActive()
        println("트랜잭션 유무: $isTransaction")
    }
}
