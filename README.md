# scheduleShare

## 🖥 프로젝트 소개
주말 스케줄 공유 서비스 프로젝트 입니다.

유툽링크:
<br/>

## 🗓 개발 기간
* 23.01.31 ~ 23.03.30

## 🧑‍🤝‍🧑 팀 멤버
 🧑‍💻 김상우(kimsangwoo66)


 👩‍💻 백소영(Soiiii)
<br/>

## 📚 기술 스택

## 🛠 개발 환경

## ▶ 주요 기능


## config

서버에 설정값을 추가해줘야 합니다.

#### [application.properties]
####server external path setting .. for upload imgs##

resource.path=" 이미지를 저장할 서버 경로 "
img.path=/img/**


#### [details.js] ####
경로 수정 필요
document.location.href = "http://localhost:8080/auth/login"


#### [mysql]
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