package com.example.recard.dto;

import com.example.recard.domain.Category;
import com.example.recard.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDto {
    private Long schedule_id;
    private String title;
    private String content;
    private Long likeCount;

    private int state;

    private Long moneyCost;

    private int timeCost;

    @LastModifiedDate
    private Timestamp updateAt;

    private Timestamp deleteAt;

    private User user;

    private Category category;
}
