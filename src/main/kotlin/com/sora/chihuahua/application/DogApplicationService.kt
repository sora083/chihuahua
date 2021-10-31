package com.sora.chihuahua.application

import com.sora.chihuahua.domain.dog.Dog
import com.sora.chihuahua.domain.dog.DogRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DogApplicationService(
    private val dogRepository: DogRepository
) {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    fun getDogs(): MutableIterable<Dog> {
        return dogRepository.findAll()
    }
}