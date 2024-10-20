package com.character_collect.mini_project.domain.entity

import jakarta.persistence.*

@Entity
class Keyword(keywordName: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    var id: Long? = null

    var keywordName: String = keywordName

    @OneToMany(
        mappedBy = "keyword",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST]  //all로 인해서 experience가 영속성에 들어가면서 얘가 가지고있는 디테일들도 같이 들어감. 같이 인서트 쿼리가 남
    )  //영속성 콘텍스트와 관련있다. 이 엔티티에서 영속성 콘텍스트에 들어가거나 빠지거나 변화가 있었을 때 그 자식엔티티도 같이 넣어주냐 빼주냐 정하는 옵션 (ALL은 모든 변화에다가 자식엔티티도 똑같이 적용한다고 하는 것)
    var hasCharacters: MutableList<CharacterKeyword> = mutableListOf()
}