package com.character_collect.mini_project.presentation.service

import com.character_collect.mini_project.domain.reqpository.CharacterKeywordRepository
import com.character_collect.mini_project.domain.reqpository.CharacterRepository
import com.character_collect.mini_project.domain.reqpository.KeywordRepository
import com.character_collect.mini_project.domain.reqpository.UsersRepository
import com.character_collect.mini_project.presentation.dto.CharacterDTO
import com.character_collect.mini_project.presentation.dto.KeywordDTO
import com.character_collect.mini_project.presentation.dto.UsersDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val usersRepository: UsersRepository,
    private val characterRepository: CharacterRepository,
    private val keywordRepository: KeywordRepository,
    private val characterKeywordRepository: CharacterKeywordRepository
) {
    @Transactional
    fun getUsers(): List<UsersDTO> {
        val users = usersRepository.findAll()  //users는 List<Users> 타입
        return users.map { UsersDTO(it, it.characters.map { character -> CharacterDTO(character) }) }
        //UserDTO에서 constructor(users: Users, characters: List<CharacterDTO>)이기 때문에 userDTO전환시 인자 두개가 들어가야함
        //character -> CharacterDTO(character) - Users 객체에 속한 캐릭터 리스트를 CharacterDTO로 변환하는 작업
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<CharacterDTO> {
        val character = characterRepository.findAll()
        return character.map { CharacterDTO(it) }
    }


    @Transactional
    fun getKeywords(): List<KeywordDTO> {
        val keywords = keywordRepository.findAll()
        return keywords.map { KeywordDTO(it) }
    }
}