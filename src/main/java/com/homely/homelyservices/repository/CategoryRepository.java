package com.homely.homelyservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homely.homelyservices.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
