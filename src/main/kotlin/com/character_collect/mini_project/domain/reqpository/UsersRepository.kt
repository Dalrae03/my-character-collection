package com.character_collect.mini_project.domain.reqpository

import com.character_collect.mini_project.domain.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<Users, Long> {
    fun findByEmail(email: String): Users?
}