package com.example.recard.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class ProfilePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;


    @Column(nullable = false, length = 200)
    private String physicalPath;

    @Column(nullable = false, length = 200)
    private String fileName;

    @CreationTimestamp
    private Timestamp createAt;


    private Timestamp deleteAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;

}
