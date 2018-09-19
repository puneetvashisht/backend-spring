package com.cts.wt.workouttrackerbackend.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.wt.workouttrackerbackend.entities.Workout;
import com.cts.wt.workouttrackerbackend.entities.WorkoutActive;
import com.cts.wt.workouttrackerbackend.repos.CategoriesRepo;
import com.cts.wt.workouttrackerbackend.repos.WorkoutActiveRepo;
import com.cts.wt.workouttrackerbackend.repos.WorkoutRepo;

@RestController
@CrossOrigin("*")
public class WorkoutActiveController {
	
	@Autowired
	WorkoutActiveRepo workoutActiveRepo;
	
	@Autowired
	WorkoutRepo workoutRepo;
	
	@Autowired
	CategoriesRepo categoryRepo;
	
	@PostMapping("/workoutactive/start")
	public ResponseEntity<Void> startWorkoutActive(@RequestBody WorkoutActive workoutActive){
		
//		System.out.println(workoutActive.getCategory());
//		if(workoutActive.getCategory().getId()!=0){
//			Category category = categoryRepo.findById(workoutActive.getCategory().getId());
//			workoutActive.setCategory(category);
//		}
		
		if(workoutActive.getWorkout().getId()!=0){
			Workout workout =  workoutRepo.findById(workoutActive.getWorkout().getId());
			workoutActive.setWorkout(workout);
		}
		Date currentDate = new Date();
		workoutActive.setStartTime(currentDate);
		workoutActive.setStartDate(currentDate);
		workoutActiveRepo.save(workoutActive);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.CREATED);
		return rs;
		
	}
	
	@GetMapping("/workoutactive/end/{workoutid}")
	public ResponseEntity<Void> endWorkoutActive(@PathVariable("workoutid") int workoutid){
		
		WorkoutActive workoutActive = workoutActiveRepo.findById(workoutid);
		Date currentDate = new Date();
		workoutActive.setEndDate(currentDate);
		workoutActive.setEndTime(currentDate);
		workoutActive.setStatus(false);
		workoutActiveRepo.save(workoutActive);
		ResponseEntity<Void> rs = new ResponseEntity<>(HttpStatus.OK);
		return rs;
		
	}
	
	@GetMapping("/workoutactive/{id}")
	public WorkoutActive fetchCategory(@PathVariable("id") int id){
		WorkoutActive workoutActive = workoutActiveRepo.findById(id);
		return workoutActive;
		
	}

}
