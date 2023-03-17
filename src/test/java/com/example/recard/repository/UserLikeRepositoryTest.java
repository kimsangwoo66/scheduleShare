package com.example.recard.repository;

import com.example.recard.domain.UserLike;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserLikeRepositoryTest {

    @Autowired UserLikeRepository userLikeRepository;

    @Autowired ScheduleRepository scheduleRepository;


    @Test
    public void test(){
        //given
        Optional<UserLike> likeObj = userLikeRepository.findByScheduleIdAndUserId(1L, 3L);


        //when
        if(likeObj.isEmpty())
        {
            System.out.println("값존재 x");
        }

        //then


    }
}
