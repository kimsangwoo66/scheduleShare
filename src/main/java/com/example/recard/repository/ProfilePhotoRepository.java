package com.example.recard.repository;

import com.example.recard.domain.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Long> {

    // p는 profilePhoto 객체 에서 p의 user객체의 userid랑 비교 해서 조회해야함
    // Optional로 jpa가 쿼리를 반환할 때 null값 허용
    // 유저의 프로필 사진을 찾기 위한 쿼리
    @Query("select p from ProfilePhoto p where p.user.user_id = :user_id")
    Optional<ProfilePhoto> findByUserId(@Param("user_id") Long user_id);






}
