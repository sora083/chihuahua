package com.sora.chihuahua.domain.dog

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

internal class DogTest {

    @Test
    fun constructor() {
        val dog = createDog()
        assertThat(dog.userId).isNotNull
        assertThat(dog.dogName).isNotNull
        assertThat(dog.genderType).isNotNull
        assertThat(dog.birthDate).isNotNull
        assertThat(dog.version).isEqualTo(0)
        assertThat(dog.createdDatetime)
            .isCloseTo(LocalDateTime.now(), Assertions.within(5, ChronoUnit.SECONDS))
        assertThat(dog.updatedDatetime)
            .isCloseTo(LocalDateTime.now(), Assertions.within(5, ChronoUnit.SECONDS))
    }

    companion object {
        fun createDog(): Dog {
            return Dog(
                userId = 1L,
                dogName = "Pochi",
                genderType = "MALE",
                birthDate = LocalDate.of(2021, 1, 1)
            )
        }
    }
}