package com.sora.chihuahua.domain.user

import com.sora.chihuahua.domain.AuditEntity
import com.sora.chihuahua.domain.dog.Dog
import lombok.Data
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.MappedCollection
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

@Data
data class User(
    @Id
    val userId: Long? = null,

    @NotNull
    val userName: String,

    @NotNull
    val hashPass: String,

    @NotNull
    val email: String,

    val location: String,

    val deleteFlg: Int = 0
) {
    @MappedCollection(idColumn = "user_id", keyColumn = "user_id")
    var dogs: MutableList<Dog> = mutableListOf()

    @Version
    @NotNull
    var version: Int = 0

    @CreatedDate
    @NotNull
    var createdDatetime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @NotNull
    var updatedDatetime: LocalDateTime = LocalDateTime.now()

    fun addDogs(newDog: Dog) {
        this.dogs.add(newDog)
    }
}