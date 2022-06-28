package com.iduy.gondrong.repository;

import com.iduy.gondrong.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByNameAndEntityName(String categoryName, String entityName);




    List<Category> findAllByIsActive(Boolean isActive);
}
