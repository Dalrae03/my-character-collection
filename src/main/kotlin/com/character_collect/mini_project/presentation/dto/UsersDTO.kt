package com.character_collect.mini_project.presentation.dto

import com.character_collect.mini_project.domain.entity.Users
import java.time.LocalDateTime

data class UsersDTO(
    val name: String,
    val email: String,
    val password: String,
    val nickname: String,
    val signupDateTime: LocalDateTime,
    val haveCharacters: List<CharacterDTO>, // 캐릭터 리스트
    val haveCharactersCount: Int
) {
    constructor(users: Users, characters: List<CharacterDTO>) : this(
        name = users.name,
        email = users.email,
        password = users.password,
        nickname = users.nickname,
        signupDateTime = users.signupDateTime,
        haveCharacters = characters,
        haveCharactersCount = characters.size
    )
}