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
internal class UserControllerTest {

    companion object {
        private const val API_USERS = "/users"
    }
    
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun getUsers() {
        this.mockMvc.get(API_USERS)
            .andDo {
                print()
            }.andExpect {
                status { isNotFound() }
                jsonPath("$.[0].userId") { exists() }
                jsonPath("$.[0].userName") { exists() }
                jsonPath("$.[0].hashPass") { exists() }
                jsonPath("$.[0].email") { exists() }
                jsonPath("$.[0].location") { exists() }
                jsonPath("$.[0].deleteFlg") { exists() }
                jsonPath("$.[0].dogs") { exists() }
            }
    }
}