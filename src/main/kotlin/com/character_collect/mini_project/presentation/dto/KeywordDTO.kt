package com.character_collect.mini_project.presentation.dto

import com.character_collect.mini_project.domain.entity.Keyword

data class KeywordDTO(
    val keywordName: String,
    val hasCharacters: List<CharacterDTO>
) {
    constructor(keyword: Keyword) : this(
        keywordName = keyword.keywordName,
        hasCharacters = keyword.hasCharacters.mapNotNull { it.character?.let { character -> CharacterDTO(character) } }
        //mapNotNull을 사용하여 hasCharacters 리스트에서 null이 아닌 값만 매핑하도록 했고, let을 사용하여 CharacterDTO로 변환하는 로직을 추가

    )
}