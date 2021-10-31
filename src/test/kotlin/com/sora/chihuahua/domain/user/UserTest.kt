package com.sora.chihuahua.domain.user

import com.sora.chihuahua.domain.dog.DogTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

internal class UserTest {

    @Test
    fun constructor() {
        val user = createUser()
        assertThat(user.userName).isNotNull
        assertThat(user.hashPass).isNotNull
        assertThat(user.email).isNotNull
        assertThat(user.location).isNotNull
        assertThat(user.deleteFlg).isEqualTo(0)
        assertThat(user.version).isEqualTo(0)
        assertThat(user.createdDatetime).isCloseTo(LocalDateTime.now(), within(5, ChronoUnit.SECONDS))
        assertThat(user.updatedDatetime).isCloseTo(LocalDateTime.now(), within(5, ChronoUnit.SECONDS))
    }
    
    @Test
    fun addDog() {
        val user = createUser()
        val newDog = DogTest.createDog()
        user.addDog(newDog)

        assertThat(user.dogs.size).isEqualTo(1)
        assertThat(user.dogs[0].dogName).isNotNull
    }

    companion object {
        fun createUser(): User {
            return User(
                userName = "John",
                hashPass = "aaa",
                email = "test@example.com",
                location = "Tokyo"
            )
        }
    }
}