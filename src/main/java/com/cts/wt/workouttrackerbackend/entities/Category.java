package com.cts.wt.workouttrackerbackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="workout_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(unique=true)
	String name;
//	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
//	List<Workout> workouts;
	
//	public List<Workout> getWorkouts() {
//		return workouts;
//	}
//	public void setWorkouts(List<Workout> workouts) {
//		this.workouts = workouts;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	

}
