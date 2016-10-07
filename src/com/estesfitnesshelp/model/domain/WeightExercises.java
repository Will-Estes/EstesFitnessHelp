
package com.estesfitnesshelp.model.domain;

import java.io.Serializable;

/*
 * Class WeightExercise holds the weight lifting exercises and 
 * their associated body parts and type
 * 
 * @author Will Estes
 * */

public class WeightExercises implements Serializable{
	
	/*Serializable using default serialVersionUID */
	private static final long serialVersionUID = 6197257423283153538L;
	/*The exercise name*/
	private String exercise; 
	/*The body part worked by the exercise*/
	private String bodyPart; 
	/*Isolation vs. compound movement*/
	private String type;     
	
	/*Constructor*/
	public WeightExercises(String exercise, String bodyPart, String type){
		this.exercise = exercise;
		this.bodyPart = bodyPart;
		this.type = type;
	}
	
	/*Gets the exercise
	 * @return exercise*/
	public String getExercise() {
		return exercise;
	}
	
	/*Sets the exercise
	 * @param exercise  name of exercise*/
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	
	/*Gets the associated body part
	 * @return bodyPart*/
	public String getBodyPart() {
		return bodyPart;
	}
	
	/*Sets the body part
	 * @param bodyPart  body part performing lift*/
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	
	/*Gets the type of exercise
	 * @return type*/
	public String getType() {
		return type;
	}
	
	/*Sets the type of exercise
	 * @param type  must be Isolation or Compound*/
	public void setType(String type) {
		this.type = type;
	}
	
	/*Checks to see if inputs are valid
	 * @return  true if valid, false otherwise*/
	public boolean validate() {
		if(exercise == null) return false;
		if(bodyPart == null) return false;
		if(type == null || !type.equalsIgnoreCase("Isolation") 
				|| !type.equalsIgnoreCase("Compound")) return false;
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
		result = prime * result
				+ ((bodyPart == null) ? 0 : bodyPart.hashCode());
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
		WeightExercises other = (WeightExercises) obj;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (bodyPart == null) {
			if (other.bodyPart != null)
				return false;
		} else if (!bodyPart.equals(other.bodyPart))
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
	  strBfr.append("exercise :");
	  strBfr.append(exercise);
	  strBfr.append("\nbodyPart :");
	  strBfr.append(bodyPart);
	
	  return strBfr.toString();
	}
} // End WeightExercises
