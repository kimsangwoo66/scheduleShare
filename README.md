# scheduleShare

## 🖥 프로젝트 소개
주말 스케줄 공유 서비스 프로젝트 입니다.

시연 영상: https://www.youtube.com/watch?v=v8lKyQWaRMg
<br/>

## 🗓 개발 기간
* 23.01.31 ~ 23.03.30

## 🧑‍🤝‍🧑 팀 멤버
 🧑‍💻 김상우(kimsangwoo66)
+ 엔터티 설계, 통합 및 형상관리, 로그인, 회원가입, 마이페이지, 메인페이지, 스케줄등록, 스케줄 상세, 마이 스케줄함 페이지, 하트 스케줄함 페이지


 👩‍💻 백소영(Soiiii)
+ 스케줄 등록 - 카테고리 선택, db 테이블 설계, wbs 관리 
<br/>

## 📚 기술 스택

#### 프론트 엔드
+ Html

+ Css

+ JavaScript(Jquery)

+ Jsp


#### 백엔드
+ Spring Boot

+ Spring Data JPA

+ Spring Security

+ Mysql 

## 🛠 개발 환경

+ IntelliJ
+ Mysql WorkBench

## ▶ 주요 기능

#### 로그인
- 아이디 & 비밀번호 검증
- 로그인 시 쿠키 및 세션 생성

#### 회원가입
- 아이디 중복 체크
- 닉네임 중복 체크
- 비밀번호 확인

#### 마이 페이지
- 마이 이미지 수정

#### 메인 페이지
- 스케줄 페이징
- 스케줄 슬라이드


#### 스케줄 등록
- 카테고리 선택
- 등록 완료

#### 스케줄 상세
- 스케줄 수정
- 스케줄 삭제
- 하트 추가
- 하트 감소

#### 마이 스케줄함 페이지
- 스케줄 페이징

#### 하트 스케줄함 페이지
- 스케줄 페이징

## 회고
+ https://deep-longship-e47.notion.site/Ajax-2-contenttype-postmapping-e125191cc3934f44848fac74b19d09fa
+ https://deep-longship-e47.notion.site/setter-builder-cecaa8afce294c2d9666de2e64790b6d



<br/>


## config

서버에 설정값을 추가해줘야 합니다.

#### [Application.properties]
####server external path setting .. for upload imgs##

resource.path=" 이미지를 저장할 서버 경로 "

img.path=/img/**




#### [Mysql]
DB에 수동으로 직접 값 insert 필요

INSERT INTO recard.Category (category_id,name) VALUES
(1,'수업'),
(2,'팀플'),
(3,'식사'),
(4,'음주'),
(5,'일'),
(6,'데이트'),
(7,'스터디'),
(8,'동아리'),
(9,'운동'),
(10,'여행');