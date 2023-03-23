package com.example.recard.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@ToString(exclude = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class SchedulePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sphoto_id;

    @Column(nullable = false, length = 200)
    private String physicalPath;

    @Column(nullable = false, length = 200)
    private String fileName;

    @Column(nullable = false, length = 200)
    private String originFileName;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;



}
