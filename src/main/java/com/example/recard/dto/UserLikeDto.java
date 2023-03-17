package com.example.recard.dto;

import com.example.recard.domain.Schedule;
import com.example.recard.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLikeDto {

    private Long like_id;

    private Schedule schedule;

    private User user;
}
