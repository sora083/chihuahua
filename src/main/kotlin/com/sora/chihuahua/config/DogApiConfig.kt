package com.sora.chihuahua.config

import org.slf4j.LoggerFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class DogApiConfig {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)!!
        private const val ROOT_URL = "https://dog.ceo/api"
    }

    //@Value{"${dog.api.root-url}"}
    lateinit var rootUrl: String
    var readTimeout = Duration.ofSeconds(30)
    var connectionTimeout = Duration.ofSeconds(30)

    @Bean
    fun dogApiRestTemplate(): RestTemplate {
        return RestTemplateBuilder()
            .rootUri(ROOT_URL)
            .setReadTimeout(readTimeout)
            .setConnectTimeout(connectionTimeout)
            //.messageConverters(MappingJackson2HttpMessageConverter(objectMapper))
            .build()
    }
}