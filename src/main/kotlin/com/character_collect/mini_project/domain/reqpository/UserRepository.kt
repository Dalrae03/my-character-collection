package com.character_collect.mini_project.domain.reqpository

import com.character_collect.mini_project.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}