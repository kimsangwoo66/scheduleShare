package com.example.recard.repository;

import com.example.recard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// JpaRepository<User, Integer> -> User테이블로 관리하는 리포지토리
// user테이블의 primary key

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);





}
