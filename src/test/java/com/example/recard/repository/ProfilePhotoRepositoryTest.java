package com.example.recard.repository;

import com.example.recard.domain.ProfilePhoto;
import com.example.recard.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ProfilePhotoRepositoryTest {

    @Autowired
    ProfilePhotoRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        ProfilePhoto byUserId = profileRepository.findByfileName("dname");
        System.out.println(byUserId.toString());

    }


}
