package com.cts.wt.workouttrackerbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.wt.workouttrackerbackend.entities.Workout;

public interface WorkoutRepo extends JpaRepository<Workout, Integer>{
	public Workout findById(int id);
}
