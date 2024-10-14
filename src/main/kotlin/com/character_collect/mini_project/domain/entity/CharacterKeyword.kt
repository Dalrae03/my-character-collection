package com.character_collect.mini_project.domain.entity

import jakarta.persistence.*

@Entity
class CharacterKeyword(character: Character, keyword: Keyword) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characterKeyword_id")
    var id: Long? = null

    @ManyToOne(targetEntity = Character::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = true)  //조인의 기준이 되는 칼럼이 프로젝트 아이디이다.
    var character: Character? = character

    @ManyToOne(targetEntity = Keyword::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "Keyword_id", nullable = false)
    var keyword: Keyword = keyword
}