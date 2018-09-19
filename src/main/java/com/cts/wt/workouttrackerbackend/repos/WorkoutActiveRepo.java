package com.cts.wt.workouttrackerbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.wt.workouttrackerbackend.entities.WorkoutActive;

public interface WorkoutActiveRepo extends JpaRepository<WorkoutActive, Integer>{
	public WorkoutActive findById(int id);
}
