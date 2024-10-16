package com.character_collect.mini_project.presentation.dto


data class CharacterDTO(
    val characterName: String,
    val height: Int,
    val age: Int,
    val gender: String,
    val personality: String,
    val characterSetting: String,
    val createDate: String,
    val Keywords: List<KeywordDTO>
)