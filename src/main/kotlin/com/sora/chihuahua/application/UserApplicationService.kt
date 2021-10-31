package com.sora.chihuahua.application

import com.sora.chihuahua.domain.user.User
import com.sora.chihuahua.domain.user.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserApplicationService(
    private val userRepository: UserRepository
) {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }
    
    fun getUsers(): MutableIterable<User> {
        return userRepository.findAll()
    }
}