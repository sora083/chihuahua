package com.sora.chihuahua.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Tag
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.DocExpansion
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfig {

    companion object {
        const val TAG_DOG = "Dog"
        const val TAG_USER = "User"
        const val TAG_DEMO = "Demo"
    }

    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.OAS_30)
            .apiInfo(
                ApiInfoBuilder()
                    .title("Chihuahua")
                    .version("1.0")
                    .build()
            )
            .consumes(setOf("application/json"))
            .produces(setOf("application/json"))
             .tags(
                 Tag(TAG_DOG, "ドッグ", 1),
                 Tag(TAG_USER, "ユーザー", 2),
                 Tag(TAG_DEMO, "デモ", 3),
             )
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.sora.chihuahua.controller"))
            .build()
    }

    @Bean
    fun uiConfig(): UiConfiguration =
        UiConfigurationBuilder.builder().deepLinking(true)
            .docExpansion(DocExpansion.LIST)
            .build()
}