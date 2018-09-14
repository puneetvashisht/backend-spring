package com.cts.wt.workouttrackerbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.wt.workouttrackerbackend.entities.Category;
import com.cts.wt.workouttrackerbackend.entities.Workout;
import com.cts.wt.workouttrackerbackend.repos.CategoriesRepo;
import com.cts.wt.workouttrackerbackend.repos.WorkoutRepo;

@RestController
public class WorkoutController {
	
	@Autowired
	WorkoutRepo workoutRepo;
	
	@Autowired
	CategoriesRepo categoryRepo;
	
	@PostMapping("/workout")
	public ResponseEntity<Void> addCategory(@RequestBody Workout workout){
		
		System.out.println(workout.getCategory());
		if(workout.getCategory().getId()!=0){
			Category category = categoryRepo.findById(workout.getCategory().getId());
			workout.setCategory(category);
		}
		workoutRepo.save(workout);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return rs;
		
	}
	
	@GetMapping("/workout/{id}")
	public Workout fetchCategory(@PathVariable("id") int id){
		Workout workout = workoutRepo.findById(id);
		return workout;
		
	}

}
