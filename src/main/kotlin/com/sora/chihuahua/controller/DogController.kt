package com.sora.chihuahua.controller

import com.sora.chihuahua.application.DogApplicationService
import com.sora.chihuahua.config.SwaggerConfig
import com.sora.chihuahua.domain.dog.Dog
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dogs")
@Validated
@Api(tags = [SwaggerConfig.TAG_DOG])
class DogController(
    private val dogApplicationService: DogApplicationService
) {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @GetMapping
    @ApiOperation(value = "Get dogs list")
    fun getDogs(
    ): MutableIterable<Dog> {
        return dogApplicationService.getDogs()
    }
}