package com.cts.wt.workouttrackerbackend.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity(name="workout_active")
public class WorkoutActive {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date startDate;

	@Temporal(TemporalType.TIME)
	@Column(nullable=true)
	private Date startTime;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date endDate;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable=true)
	private Date endTime;
	
	String comment;
	
	@Type(type="true_false")
	boolean status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Workout workout;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	
	
	
	
	
	

}
