package com.character_collect.mini_project.domain.reqpository

import com.character_collect.mini_project.domain.entity.Character
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository : JpaRepository<Character, Long> {
    fun findByCharacterName(characterName: String): List<Character>
}