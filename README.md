# My Character Collection
작가들을 위한 캐릭터 정리 프로젝트   
인프런 워밍업 클럽 2기 백엔드 프로젝트 과정 미니 프로젝트

<br>
<br>

## 주요기능
- 회원가입
- 로그인 / 로그아웃
- 회원 탈퇴
- 캐릭터 등록 / 수정 / 삭제
- 캐릭터 검색
- 보유 캐릭터 수 확인

<br>
<br>

## ERD
![Mini Project Test](https://github.com/user-attachments/assets/a72b4548-a495-44b4-ab00-e855f19333cb)

<br>
<br>

## API 설계
### 1. 회원가입 
- Endpoint: /api/users/signup   
- Method: POST   
- Description: 새로운 사용자를 회원가입.   
- **Request:**   
``` json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "nickname": "johnny"
}
```
- **Response:**   
  - Status Code: 201 Created   
  - Body:   
``` json
{
  "userId": 1,
  "message": "User successfully created."
}
```
<br>

### 2. 로그인   
Endpoint: /api/users/login   
Method: POST   
Description: 사용자 로그인 처리.   
**Request:**   
``` json
{
  "email": "john@example.com",
  "password": "password123"
}
```
**Response:**   
Status Code: 200 OK   
Body:   
``` json
{
  "userId": 1,
  "message": "Login successful."
}
```

<br>

### 3. 로그아웃
Endpoint: /api/users/logout   
Method: POST   
Description: 사용자 로그아웃 처리.   
**Request:**    
없음   
**Response:**   
Status Code: 200 OK
Body:
``` json
{
  "message": "Logout successful."
}
```

<br>

### 4. 회원 탈퇴
Endpoint: /api/users/{userId}   
Method: DELETE   
Description: 사용자가 회원 탈퇴합니다.   
**Request:**    
없음   
**Response:**   
Status Code: 200 OK   
Body:   
``` json
{
  "message": "User deleted successfully."
}
```

<br>

### 5. 캐릭터 등록
Endpoint: /api/characters   
Method: POST   
Description: 새로운 캐릭터를 등록합니다.   
**Request:**
``` json
{
  "userId": 1,
  "characterName": "Warrior",
  "height": 180,
  "age": 25,
  "gender": 1,
  "personality": "Brave",
  "characterSetting": "Fantasy World",
  "keyword": "Warrior"
}
```
**Response:**
Status Code: 201 Created   
Body:   
``` json
{
  "characterId": 1,
  "message": "Character successfully created."
}
```

<br>

### 6. 캐릭터 수정
Endpoint: /api/characters/{characterId}   
Method: PUT   
Description: 기존 캐릭터의 정보를 수정합니다.   
**Request:**
``` json
{
  "characterName": "Mage",
  "height": 170,
  "age": 22,
  "gender": 2,
  "personality": "Intelligent",
  "characterSetting": "Magic Kingdom",
  "keyword": "Mage"
}
```
**Response:**
Status Code: 200 OK   
Body:   
``` json
{
  "characterId": 1,
  "message": "Character successfully updated."
}
```

<br>

### 7. 캐릭터 삭제
Endpoint: /api/characters/{characterId}   
Method: DELETE   
Description: 특정 캐릭터를 삭제합니다.   
**Response:**
Status Code: 200 OK   
Body:
``` json
{
  "message": "Character successfully deleted."
}
```

<br>

### 8. 캐릭터 검색
Endpoint: /api/characters/search   
Method: GET   
Description: 특정 조건으로 캐릭터를 검색합니다.   
**Request:**    (URL 파라미터로 전달)
예: /api/characters/search?characterName=Mage&age=22&gender=2   
**Response:**   
Status Code: 200 OK   
Body:   
``` json
[
  {
    "characterId": 1,
    "characterName": "Mage",
    "height": 170,
    "age": 22,
    "gender": 2,
    "personality": "Intelligent",
    "characterSetting": "Magic Kingdom",
    "keyword": "Mage"
  }
]
```

<br>

### 9. 보유 캐릭터 수 확인
Endpoint: /api/users/{userId}/characters/count   
Method: GET   
Description: 특정 사용자가 보유한 캐릭터 수를 확인합니다.   
**Response:**   
Status Code: 200 OK   
Body:   
``` json
{
  "userId": 1,
  "characterCount": 5
}
```
