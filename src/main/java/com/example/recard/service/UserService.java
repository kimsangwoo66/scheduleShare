package com.example.recard.service;

import com.example.recard.domain.RoleType;
import com.example.recard.domain.User;
import com.example.recard.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    Logger log;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Transactional
    public void userSave(User user){

            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword);

            user.setPassword(encPassword);
            user.setRole(RoleType.USER);
            userRepository.save(user);


    }


}
