package com.character_collect.mini_project.domain.reqpository

import com.character_collect.mini_project.domain.entity.Keyword
import org.springframework.data.jpa.repository.JpaRepository

interface KeywordRepository : JpaRepository<Keyword, Long> {
    fun findByKeywordName(keywordName: String): Keyword?
}