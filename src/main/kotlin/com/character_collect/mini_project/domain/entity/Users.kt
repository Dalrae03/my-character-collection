package com.character_collect.mini_project.domain.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime


@Entity
class Users(
    name: String,
    email: String,
    password: String,
    nickname: String,
    signupDateTime: LocalDateTime
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long? = null

    var name: String = name
    var email: String = email
    var password: String = password
    var nickname: String = nickname

    @CreatedDate  //JPA엔티티가 생성된 시간을 자동으로 세팅
    @Column(nullable = false, updatable = false)  //이 필드는 값이 항상 있어야하고, 업데이트가 불가하다. (값이 변경되면 jpa에서 오류가 날것이다.)
    var signupDateTime: LocalDateTime = LocalDateTime.now()


    @OneToMany(
        targetEntity = Character::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]  //all로 인해서 experience가 영속성에 들어가면서 얘가 가지고있는 디테일들도 같이 들어감. 같이 인서트 쿼리가 남
    )  //영속성 콘텍스트와 관련있다. 이 엔티티에서 영속성 콘텍스트에 들어가거나 빠지거나 변화가 있었을 때 그 자식엔티티도 같이 넣어주냐 빼주냐 정하는 옵션 (ALL은 모든 변화에다가 자식엔티티도 똑같이 적용한다고 하는 것)
    @JoinColumn(name = "user_id")  //맵핑의 기준이 뭔지, 그 맵핑의 기준이 되는 컬럼을 알려주는 기능을 함
    var characters: MutableList<Character> = mutableListOf()  //var은 변경가능 변수, val은 변수 참조 자체를 변경할 수 없다는데... 솔직히 잘 몰겠다...
    //사용자가 소유한 캐릭터 목록들


    fun update(
        name: String,
        email: String,
        password: String,
        nickname: String
    ) {
        this.name = name
        this.email = email
        this.password = password
        this.nickname = nickname
    }

    fun addCharacter(characters: MutableList<Character>?) {
        if (characters != null) {
            this.characters.addAll(characters)
        }
    }


}