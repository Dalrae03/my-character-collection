package com.character_collect.mini_project.domain.reqpository

import com.character_collect.mini_project.domain.entity.CharacterKeyword
import com.character_collect.mini_project.domain.entity.Keyword
import org.springframework.data.jpa.repository.JpaRepository

//조회 api - 로그인, 캐릭터이름으로 검색, 키워드로 검색.

interface CharacterKeywordRepository : JpaRepository<CharacterKeyword, Long> {
    //keyword 파라미터가 Keyword 엔티티 타입인 이유 - 연관된 데이터베이스 테이블에서 키워드와 관련된 캐릭터들을 찾기 위해 Keyword 엔티티 자체를 사용해야 하기 때문
    fun findByKeyword(keyword: Keyword): List<CharacterKeyword>
}

