package com.example.study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class EqualsTest {

    @DisplayName("동일성과 동등성 테스트")
    @Test
    fun `동일성과 동등성 검사`() {
        data class Person(val name: String, val age: Int)

        val person1 = Person("김영철", 10)
        val person2 = person1 // person1과 동일한 객체를 참조
        val person3 = Person("김영철", 10) // 새로운 객체 생성

        assertAll(
            // 동일성 테스트
            { assertThat(person1 === person2).isTrue() }, // 동일한 객체 참조
            { assertThat(person1 === person3).isFalse() }, // 서로 다른 객체 참조

            // 동등성 테스트
            { assertThat(person1 == person3).isTrue() }, // 내용이 동일 (Person 이 data 클래스이기 때문에 자동으로 equals(), hashCode() 생성)
            { assertThat(person1.name == person3.name).isTrue() }, // 이름 비교
            { assertThat(person1.age == person3.age).isTrue() } // 나이 비교
        )
    }

    @DisplayName("엔티티 동일성 테스트")
    @Test
    fun `엔티티의 동일성 검사`() {
        data class User(
            val id: Long,
            val name: String,
            val email: String
        ) {
            // 식별자를 사용한 동일성 판단
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is User) return false

                return id == other.id // id가 동일한지 확인
            }

            override fun hashCode(): Int {
                return id.hashCode()
            }
        }

        val user1 = User(1, "김영철", "kim@example.com")
        val user2 = User(1, "홍길동", "hong@example.com")
        val user3 = User(2, "김영철", "kim@example.com")

        assertThat(user1 == user2).isTrue() // true: 동일한 id를 가짐
        assertThat(user1 == user3).isFalse() // false: 다른 id를 가짐
    }
}
