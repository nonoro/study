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
}
