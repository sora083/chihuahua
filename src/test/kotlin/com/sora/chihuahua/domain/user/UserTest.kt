package com.sora.chihuahua.domain.user

import com.sora.chihuahua.domain.dog.Dog
import com.sora.chihuahua.domain.user.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class UserTest {

    @Test
    fun addDogs() {
        val user = createUser()
        val newDog = Dog(
            userId = 1L,
            dogName = "Pochi",
            genderType = "MALE",
            birthDate = LocalDate.of(2021, 1, 1)
        )
        user.addDogs(newDog)

        assertThat(user.dogs.size).isEqualTo(1)
        assertThat(user.dogs[0].dogName).isEqualTo("Pochi")
    }

    private fun createUser(): User {
        return User(
            userName = "John",
            hashPass = "aaa",
            email = "test@example.com",
            location = "Tokyo",
            deleteFlg = 0
        )
    }
}