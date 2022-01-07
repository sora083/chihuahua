package com.sora.chihuahua.controller

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@Disabled("TODO: APIのモック化が必要")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class YoutubeControllerTest {

    companion object {
        private const val API_YOUTUBE_SEARCH = "/youtube/search?query=english"
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun search() {
        this.mockMvc
            .get(API_YOUTUBE_SEARCH)
            .andDo {
                print()
            }
            .andExpect {
                status { isOk() }
            }
    }
}
