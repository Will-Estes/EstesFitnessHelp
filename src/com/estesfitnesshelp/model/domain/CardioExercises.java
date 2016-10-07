
package com.estesfitnesshelp.model.domain;

import java.io.Serializable;

/*
 * Class CardioExercises contains the exercise name and type
 * 
 * @author Will Estes
 * */
public class CardioExercises implements Serializable{

	/*Serializable using default serialVersionUID*/
	private static final long serialVersionUID = 460248031020233242L;
	/*Name of exercise*/
	private String exercise; 
	/*Type of exercise - default of cardio*/
	private String type = "Cardio";     
	
	/*Constructor*/
	public CardioExercises(String exercise){
		this.exercise = exercise;
	}
	
	/*Gets the exercise name
	 * @return exercise*/
	public String getExercise() {
		return exercise;
	}
	
	/*Sets the exercise name
	 * @param exercise  name of exercise*/
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	/*Gets the type of exercise
	 * @return type  default of "Cardio"*/
	public String getType() {
		return type;
	}

	/*Checks to validate inputs
	 * @return  true if valid, false otherwise*/
	public boolean validate() {
		if(exercise == null) return false;
		if(type == null || !type.equalsIgnoreCase("Cardio")) return false;
		return true;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result
				+ ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardioExercises other = (CardioExercises) obj;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	public String toString()
	{
	  StringBuffer strBfr = new StringBuffer();
	  strBfr.append("Exercise :");
	  strBfr.append(exercise);
	  strBfr.append("\nType :");
	  strBfr.append(type);	
	  
	  return strBfr.toString();
	}	
}
