package com.sora.chihuahua.infrastructure

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class DogApi(
    private val dogApiRestTemplate: RestTemplate,
) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)!!
        private const val GET_CHIHUAHUA_IMAGES = "/breed/chihuahua/images"
    }

    fun getChihuahuas(): ChihuahuaImages {
        log.info("get chihuahua images")
        val startTime = System.currentTimeMillis()
        val response = dogApiRestTemplate.getForEntity(GET_CHIHUAHUA_IMAGES, ChihuahuaImages::class.java)
        log.info("get chihuahua images response: $response。execution time: ${System.currentTimeMillis() - startTime} msec")
        return response.body!!
    }
}