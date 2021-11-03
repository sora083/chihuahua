package com.sora.chihuahua.infrastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@Disabled
@SpringBootTest
internal class DogApiTest {

    @Autowired
    private lateinit var dogApi: DogApi

    @Test
    fun getChihuahuas() {
        val response = dogApi.getChihuahuas()

        // assert
        print(response)
        assertThat(response.message).isNotEmpty
        assertThat(response.status).isEqualTo("success")
    }
}