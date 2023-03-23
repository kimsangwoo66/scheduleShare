package com.example.recard.repository;

import com.example.recard.domain.SchedulePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchedulePhotoRepository extends JpaRepository<SchedulePhoto, Long> {


    @Query("SELECT sp FROM SchedulePhoto sp WHERE sp.schedule.schedule_id = :scheduleId")
    List<SchedulePhoto> findAllByScheduleId(@Param("scheduleId") Long scheduleId);

}
