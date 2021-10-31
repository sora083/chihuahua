package com.sora.chihuahua.domain.dog

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DogRepository : CrudRepository<Dog, Long>