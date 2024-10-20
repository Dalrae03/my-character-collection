package com.character_collect.mini_project.presentation.dto

import com.character_collect.mini_project.domain.entity.Character
import java.time.LocalDate


data class CharacterDTO(
    val characterName: String,
    val height: Int,
    val age: Int,
    val gender: String,
    val personality: String,
    val characterSetting: String,
    val createDate: LocalDate,
    val characterKeywords: List<KeywordDTO>?
) {
    constructor(character: Character) : this(
        characterName = character.characterName,
        height = character.height,
        age = character.age,
        gender = character.gender,
        personality = character.personality,
        characterSetting = character.characterSetting,
        createDate = character.createDate,
        // Character 엔티티에서 characterKeywords를 통해 KeywordDTO로 변환
        characterKeywords = character.characterKeywords.map { it.keyword }.map { KeywordDTO(it) }
        //.characterKeywords.map { KeywordDTO(it.keyword) } 이렇게도 쓸 수 있는듯?
    )
}