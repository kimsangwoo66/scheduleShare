# scheduleShare
주말 휴식 스케줄 추천 서비스



## config

서버별 파일 업로드 경로 변경 필요 

#### [UserApiController]

* String uploadPath = "서버 외부 경로"
* ex) String uploadPath = "/Users/kk/Desktop/study/img/";



#### [application.properties]


##save in server external path.. use in MvcConfig##

추가 

resource.path=file:서버 외부 경로

img.path=/img/**

ex)

   resource.path=file:/Users/kk/Desktop/study/img/

   img.path=/img/**
