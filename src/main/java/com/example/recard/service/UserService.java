package com.example.recard.service;

import com.example.recard.domain.ProfilePhoto;
import com.example.recard.domain.RoleType;
import com.example.recard.domain.User;
import com.example.recard.dto.UserDto;
import com.example.recard.repository.ProfilePhotoRepository;
import com.example.recard.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfilePhotoRepository profilePhotoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


//    @Transactional
//    public void userSave(User user){
//
//            String rawPassword = user.getPassword();
//            String encPassword = encoder.encode(rawPassword);
//
//            user.setPassword(encPassword);
//            user.setRole(RoleType.USER);
//            userRepository.save(user);
//
//
//    }

    @Transactional
    public void userSave(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .username(userDto.getUsername())
                .state(userDto.getState())
                .gender(userDto.getGender())
                .role(RoleType.USER)
                .build();
        userRepository.save(user);
    }

    // Controller에서 발생한 에러를 전달받아 알맞게 정재한 뒤에 다시 반환
    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(BindingResult bindingResult){
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error: bindingResult.getFieldErrors()){

            System.out.println("errorField: " + error.getField());
            String validateKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validateKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }




    public Optional<ProfilePhoto> profilePhotoFind(Long id){
        Optional<ProfilePhoto> photoInfo = profilePhotoRepository.findByUserId(id);

        return photoInfo;
    }


    @Transactional
    public void ProfilePhotoDeleteAtUpdate(ProfilePhoto profilePhoto){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        Long chIntId = profilePhoto.getProfile_id();


        // 영속화
        ProfilePhoto persistence = profilePhotoRepository.findById(chIntId).orElseThrow(()->{
            return new IllegalArgumentException("사진아이디 찾기 실패");
        });

        //삭제 시간을 현재로 업데이트
        persistence.setDeleteAt(timestamp);
        System.out.println("업데이트 체크: " + persistence.toString());

    }

    public void ProfilePhotoSave(String uploadPath, String fileName, User user){
        ProfilePhoto profilePhoto = new ProfilePhoto();

        // PhysicalPath = uploadPath + fileName
        profilePhoto.setPhysicalPath(uploadPath + fileName);
        profilePhoto.setFileName(fileName);
        profilePhoto.setUser(user);

        profilePhotoRepository.save(profilePhoto);
    }


}
