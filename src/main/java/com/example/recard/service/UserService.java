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

    // Controller에서 발생한 에러를 전달받아 알맞게 정재한 뒤에 다시 리턴
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



    @Transactional
    public Optional<ProfilePhoto> profilePhotoFind(Long id){
        Optional<ProfilePhoto> photoInfo = profilePhotoRepository.findByUserId(id);

        //Optional<ProfilePhoto> photoInfo = profilePhotoRepository.findById(id);

        return photoInfo;
    }


    @Transactional
    public void ProfilePhotoDelete(ProfilePhoto profilePhoto){

        Long chIntId = profilePhoto.getProfile_id();
        profilePhotoRepository.deleteById(chIntId);

//        // 영속화
//        ProfilePhoto persistence = profilePhotoRepository.findById(chIntId).orElseThrow(()->{
//            return new IllegalArgumentException("사진아이디 찾기 실패");
//        });


    }

    @Transactional
    public void ProfilePhotoSave(String uploadPath, String fileName, User user){
        ProfilePhoto profilePhoto = new ProfilePhoto();

        // PhysicalPath = uploadPath + fileName
        profilePhoto.setPhysicalPath(uploadPath + fileName);
        profilePhoto.setFileName(fileName);
        profilePhoto.setUser(user);

        profilePhotoRepository.save(profilePhoto);
    }


}
