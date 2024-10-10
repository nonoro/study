package com.example.study

import com.example.study.service.TransactionServiceV1
import com.example.study.service.TransactionServiceV2
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionTest(
    @Autowired private val transactionServiceV1: TransactionServiceV1,
) {
    @DisplayName("같은 클래스내의 메서드끼리 호출할때 트랜잭션 적용 여부에 관한 테스트")
    @Test
    fun test1() {
        transactionServiceV1.transactionIsFalse1()
    }

    @DisplayName("같은 클래스내의 메서드끼리 호출할때 트랜잭션 적용 되지 않는 문제를 해결하기위한 테스트")
    @Test
    fun test2() {
        transactionServiceV1.transactionIsFalse2()
    }
}
