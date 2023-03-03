package com.example.recard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//클라이언트의 요청에 대한 응답 데이터 표현식
//엔터티 내부 구현을 캡슐화 하기 위해 사용
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    private int status;

    private T data;
}
