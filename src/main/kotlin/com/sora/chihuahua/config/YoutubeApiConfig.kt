package com.sora.chihuahua.config

import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class YoutubeApiConfig {

    companion object {
        /** Global instance of the HTTP transport.  */
        private val httpTransport: HttpTransport = NetHttpTransport()

        /** Global instance of the JSON factory.  */
        private val jsonFactory: JacksonFactory = JacksonFactory()
    }

    @Bean
    fun youtubeApi(): YouTube {
        return YouTube.Builder(httpTransport, jsonFactory) { }.setApplicationName("youtube-eng")
            .build()
    }
}
