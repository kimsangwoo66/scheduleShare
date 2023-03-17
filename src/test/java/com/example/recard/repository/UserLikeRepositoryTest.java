package com.example.recard.repository;

import com.example.recard.domain.Schedule;
import com.example.recard.domain.UserLike;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserLikeRepositoryTest {

    @Autowired UserLikeRepository userLikeRepository;

    @Autowired ScheduleRepository scheduleRepository;


    @Test
    public void test(){
        //given


        //when


        //then


    }
}
