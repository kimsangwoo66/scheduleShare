package com.example.recard.repository;

import com.example.recard.domain.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {

    @Query("select l from UserLike l where l.schedule.schedule_id = :schedule_id and l.user.user_id = :user_id")
    Optional<UserLike> findByScheduleIdAndUserId(@Param("schedule_id") Long schedule_id, @Param("user_id") Long user_id);
}
