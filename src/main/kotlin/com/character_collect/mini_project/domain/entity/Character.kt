package com.character_collect.mini_project.domain.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate

@Entity
class Character(
    characterName: String,
    height: Int,
    age: Int,
    gender: String,
    personality: String,
    characterSetting: String,
    createDate: LocalDate
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    var id: Long? = null

    var characterName: String = characterName
    var height: Int = height
    var age: Int = age
    var gender: String = gender

    //JPA에서 String 타입 필드는 기본적으로 VARCHAR 타입으로 매핑
    //매우 긴 텍스트(예: 설명이 길거나 문단 단위로 저장해야 할 경우)를 포함하는 경우, 다음과 같이 @Lob 애노테이션을 추가하여 CLOB(대용량 문자 데이터)로 저장
    @Column(name = "personality", columnDefinition = "TEXT")
    @Lob
    var personality: String = personality

    @Column(name = "characterSetting", columnDefinition = "TEXT")
    @Lob
    var characterSetting: String = characterSetting

    @CreatedDate  //JPA엔티티가 생성된 시간을 자동으로 세팅
    @Column(nullable = false, updatable = false)  //이 필드는 값이 항상 있어야하고, 업데이트가 불가하다. (값이 변경되면 jpa에서 오류가 날것이다.)
    var createDate: LocalDate = LocalDate.now()


    @OneToMany(
        mappedBy = "character",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST]  //all로 인해서 experience가 영속성에 들어가면서 얘가 가지고있는 디테일들도 같이 들어감. 같이 인서트 쿼리가 남
    )  //영속성 콘텍스트와 관련있다. 이 엔티티에서 영속성 콘텍스트에 들어가거나 빠지거나 변화가 있었을 때 그 자식엔티티도 같이 넣어주냐 빼주냐 정하는 옵션 (ALL은 모든 변화에다가 자식엔티티도 똑같이 적용한다고 하는 것)
    var characterKeywords: MutableList<CharacterKeyword> = mutableListOf()  //캐릭터가 가지고있는 키워드 리스트들

    fun update(
        characterName: String,
        height: Int,
        age: Int,
        gender: String,
        personality: String,
        characterSetting: String
    ) {
        this.characterName = characterName
        this.height = height
        this.age = age
        this.gender = gender
        this.personality = personality
        this.characterSetting = characterSetting
    }

}