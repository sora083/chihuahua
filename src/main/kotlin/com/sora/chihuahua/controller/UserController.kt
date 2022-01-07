package com.sora.chihuahua.controller

import com.sora.chihuahua.application.UserApplicationService
import com.sora.chihuahua.config.SwaggerConfig
import com.sora.chihuahua.domain.user.User
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
@Validated
@Api(tags = [SwaggerConfig.TAG_USER])
class UserController(
    private val userApplicationService: UserApplicationService
) {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @GetMapping
    @ApiOperation(value = "Get users list")
    fun getUsers(
    ): MutableIterable<User> {
        return userApplicationService.getUsers()
    }
}