package com.estesfitnesshelp.model.domain;

import java.util.Calendar;
import java.io.Serializable;

/*
 * Class WeightLog contains info weight lifting logs
 * 
 * @author Will Estes
 * */

public class WeightLog implements Serializable{

	/*Serializable default serialVersionUID*/
	private static final long serialVersionUID = -6132707424732278443L;
	/*Number of sets performed*/
	private Integer numSets;  
	/*Number of reps performed per set*/
	private Integer numReps;  
	/*weight performed per rep*/
	private Double weight; 
	/*Calendar date of log*/
	private Calendar cal = Calendar.getInstance();
	
	/*Constructor*/
	public WeightLog(Integer numSets, Integer numReps, Double weight){
		this.numSets = numSets;
		this.numReps = numReps;
		this.weight = weight;
	}
	
	/*Gets number of sets
	 * @return numSets*/
	public Integer getNumSets() {
		return numSets;
	}
	
	/*Sets the number of sets
	 * @param numSets  number of sets*/
	public void setNumSets(int numSets) {
		this.numSets = numSets;
	}
	
	/*Gets the number of reps
	 * @return numReps*/
	public Integer getNumReps() {
		return numReps;
	}
	
	/*Sets the number of reps
	 * @param numReps  number of reps*/
	public void setNumReps(int numReps) {
		this.numReps = numReps;
	}
	
	/*Gets the amount of weight
	 * @return weight*/
	public Double getWeight() {
		return weight;
	}
	
	/*Sets the amount of weight
	 * @param weight  amount of weight*/
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/*validates inputs
	 * @return  true if valid, false otherwise*/
	public boolean validate() {
		if(numSets == null) return false;
		if(numReps == null) return false;
		if(weight == null) return false;
		return true;
	}	
	
	/*Sets the date of the log
	 * @param year   year of log
	 * @param month  month of log
	 * @param day    day of log
	 * */
	public void setDate(int year, int month, int day){
	    year = cal.get(Calendar.YEAR);
	    month = cal.get(Calendar.MONTH);      // 0 to 11
	    day = cal.get(Calendar.DAY_OF_MONTH);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numSets == null) ? 0 : numSets.hashCode());
		result = prime * result
				+ ((numReps == null) ? 0 : numReps.hashCode());
		result = prime * result
				+ ((weight == null) ? 0 : weight.hashCode());
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
		WeightLog other = (WeightLog) obj;
		if (numReps == null) {
			if (other.numReps != null)
				return false;
		} else if (!numReps.equals(other.numReps))
			return false;
		if (numSets == null) {
			if (other.numSets != null)
				return false;
		} else if (!numSets.equals(other.numSets))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	public String toString()
	{
	  StringBuffer strBfr = new StringBuffer();
	  strBfr.append("numReps :");
	  strBfr.append(numReps);
	  strBfr.append("\nnumSets :");
	  strBfr.append(numSets);
	
	  return strBfr.toString();
	}	
} //End WeightLog
