package com.sora.chihuahua.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WebFluxControllerTest {

    companion object {
        private const val API_FLUX = "/flux"
        private const val API_STREAM = "$API_FLUX/stream"
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun hello() {
        this.mockMvc.get(API_FLUX)
            .andDo {
                print()
            }.andExpect {
                status { isOk() }
            }
    }
//
//    @Test
//    fun stream() {
//        this.mockMvc.get(API_STREAM)
//            .andDo {
//                print()
//            }.andExpect {
//                status { isOk() }
//            }
//    }
}