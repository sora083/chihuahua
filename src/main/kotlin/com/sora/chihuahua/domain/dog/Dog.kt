package com.sora.chihuahua.domain.dog

import lombok.Data
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.LocalDate
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

@Data
class Dog(
    @Id
    val dogId: Long? = null,

    @NotNull
    val userId: Long,

    @NotNull
    val dogName: String,

    @NotNull
    val genderType: String,

    @NotNull
    val birthDate: LocalDate
) {
    @Version
    @NotNull
    var version: Int = 0

    @CreatedDate
    @NotNull
    var createdDatetime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @NotNull
    var updatedDatetime: LocalDateTime = LocalDateTime.now()
}