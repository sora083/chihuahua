package com.sora.chihuahua.controller

import com.sora.chihuahua.config.SwaggerConfig
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.*
import java.util.stream.Stream


@RestController
@RequestMapping("/flux")
@Api(tags = [SwaggerConfig.TAG_DEMO])
class HelloController {

    @GetMapping
    @ApiOperation(value = "Get flux demo")
    fun hello(): Flux<String> {
        return Flux.just("Hello", "World")
    }

    @GetMapping("/stream")
    @ApiOperation(value = "Get stream by flux demo")
    fun stream(): Flux<Map<String, Int>> {
        val stream: Stream<Int> = Stream.iterate(0) { i -> i + 1 }
        return Flux.fromStream(stream)
            .map { i -> Collections.singletonMap("value", i) }
    }
}