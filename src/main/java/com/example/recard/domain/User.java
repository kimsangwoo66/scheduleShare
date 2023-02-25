package com.example.recard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data //getter setter 생성
@Entity //엔터티 클래스 등록
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임
    private Long user_id;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 5)
    private int gender;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 5)
    private int state;

    //DB가 인식할 수 있는 타입으로 변경 ->Enumerated 사용
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private Timestamp createAt;



}
