package com.cts.wt.workouttrackerbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.wt.workouttrackerbackend.entities.Category;
import com.cts.wt.workouttrackerbackend.repos.CategoriesRepo;

@RestController
@CrossOrigin("*")
public class CategoriesController {
	
	@Autowired
	CategoriesRepo categoriesRepo;
	
	@PostMapping("/category")
	public ResponseEntity<Void> addCategory(@RequestBody Category category){
		categoriesRepo.save(category);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return rs;
		
	}
	
	@GetMapping("/category/{id}")
	public Category fetchCategory(@PathVariable("id") int id){
		Category category = categoriesRepo.findById(id);
		System.out.println(category);
		return category;
		
		
	}

}
