package com.example.recard.repository;

import com.example.recard.domain.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s WHERE s.user.user_id = :user_id")
    Page<Schedule> findByMyScheduleAll(Pageable pageable, @Param("user_id") Long userId);


    @Query("SELECT s FROM Schedule s WHERE s.category.category_id = :category_id")
    Page<Schedule> findByCateScheduleAll(Pageable pageable, @Param("category_id") Long categoryId);

    @Modifying
    @Query("DELETE FROM Schedule s WHERE s.schedule_id = :scheduleId")
    void deleteScheduleById(@Param("scheduleId") Long scheduleId);

}
