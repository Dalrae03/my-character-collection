package com.character_collect.mini_project.domain.entity

import jakarta.persistence.*

@Entity
class Keyword(keywordName: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    var id: Long? = null

    var keywordName: String = keywordName
}