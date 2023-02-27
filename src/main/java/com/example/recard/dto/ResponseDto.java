package com.example.recard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//화면에 필요한 데이터를 선별하기 위해
//엔터티 내부 구현을 캡슐화 하기 위해 사용
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    private int status;

    private T data;
}
