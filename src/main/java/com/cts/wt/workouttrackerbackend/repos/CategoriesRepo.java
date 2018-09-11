package com.cts.wt.workouttrackerbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.wt.workouttrackerbackend.entities.Category;

public interface CategoriesRepo extends JpaRepository<Category, Integer>{
	public Category findById(int id);
}
