package com.character_collect.mini_project.domain

import com.character_collect.mini_project.domain.entity.Character
import com.character_collect.mini_project.domain.entity.CharacterKeyword
import com.character_collect.mini_project.domain.entity.Keyword
import com.character_collect.mini_project.domain.entity.Users
import com.character_collect.mini_project.domain.reqpository.CharacterRepository
import com.character_collect.mini_project.domain.reqpository.KeywordRepository
import com.character_collect.mini_project.domain.reqpository.UsersRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime

@Component
@Profile(value = ["default"])
class DataInitializer (
    private val characterRepository: CharacterRepository,
    private val usersRepository: UsersRepository,
    private val keywordRepository: KeywordRepository,
    //private val characterKeywordRepository: CharacterKeywordRepository
) {
    @PostConstruct
    fun initialize() {
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val user1 = Users(
            name = "Jessy",
            email = "yejin@example.com",
            password = "password123",
            nickname = "Dal",
            signupDateTime = LocalDateTime.now()
        )

        val character1 = Character(
            characterName = "나가",
            height = 175,
            age = 18,
            gender = "남",
            personality = "지극히 평범한 고등학생, 초반에는 소심한 성격을 가지고있다.",
            characterSetting = "염력 최강자로 주인공 포지션을 가지고있다.",
            createDate = LocalDate.now()
        )
        //characterRepository.save(character1)

        user1.addCharacter(mutableListOf(character1))
        usersRepository.save(user1)


        val keyword1 = Keyword(keywordName = "초능력자")
        val keyword2 = Keyword(keywordName = "주인공")
        keywordRepository.saveAll(mutableListOf(keyword1, keyword2))
        //println("키워드 저장 완료")

        character1.characterKeywords.addAll(
            mutableListOf(
                CharacterKeyword(character = character1, keyword = keyword1),
                CharacterKeyword(character = character1, keyword = keyword2)
            )
        )



    }


}