package com.example.recard.repository;

import com.example.recard.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category findByCategoryId(Long categoryId);
}
