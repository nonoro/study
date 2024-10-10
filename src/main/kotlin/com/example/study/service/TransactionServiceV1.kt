package com.example.study.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager



@Service
class TransactionServiceV1(
    private val transactionServiceV2: TransactionServiceV2,
) {

    @Transactional
    fun transactionIsTrue() {
        println("트랜잭션 적용된 메서드 호출")
        logTransactionStatus()
    }

    fun transactionIsFalse1() {
        println("트랜잭션이 적용되지 않은 메서드 호출")
        logTransactionStatus()
        transactionIsTrue()
    }

    fun transactionIsFalse2() {
        println("트랜잭션이 적용되지 않은 메서드 호출")
        logTransactionStatus()
        transactionServiceV2.transactionIsTrue()
    }

    private fun logTransactionStatus() {
        val isTransaction = TransactionSynchronizationManager.isActualTransactionActive()
        println("트랜잭션 유무: $isTransaction")
    }
}
