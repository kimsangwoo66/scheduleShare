package com.example.recard.repository;

import com.example.recard.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<엔터티 클래스, primary key의 타입>
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
