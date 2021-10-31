package com.sora.chihuahua.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
internal class DogControllerTest {
    
    companion object {
        private const val API_DOGS = "/dogs"
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun getDogs() {
        this.mockMvc.get(API_DOGS)
            .andDo {
                print()
            }.andExpect {
                status { isOk() }
                jsonPath("$.[0].dogId") { exists() }
                jsonPath("$.[0].userId") { exists() }
                jsonPath("$.[0].dogName") { exists() }
                jsonPath("$.[0].genderType") { exists() }
                jsonPath("$.[0].birthDate") { exists() }
            }
    }
}