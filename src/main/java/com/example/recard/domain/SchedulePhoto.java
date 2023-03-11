package com.example.recard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
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

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;



}
