package com.example.recard.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Like {

    //기본키 직접 할당해야함
    // Member member = new Member();
    //member.setId("1"); // 기본키 직접 할당
    //EntityManager.persist(member);
    @Id
    private Integer like_id;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;

}
