package com.sora.chihuahua.infrastructure

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ChihuahuaImages(
    val message: List<String>,
    val status: String,
)