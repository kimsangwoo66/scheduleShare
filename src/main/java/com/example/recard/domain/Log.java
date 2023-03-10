package com.example.recard.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Log{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long log_id;


    @Column(nullable = false, length = 50)
    private String userAction;

    @CreationTimestamp
    private Timestamp createAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
