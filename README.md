# scheduleShare
주말 스케줄 공유 서비스


## config

서버에 설정값을 추가해줘야 합니다.

#### [application.properties]
####server external path setting .. for upload imgs##

resource.path=" 이미지를 저장할 서버 경로 "
img.path=/img/**


#### [details.js] ####
경로 수정 필요
document.location.href = "http://localhost:8080/auth/login"