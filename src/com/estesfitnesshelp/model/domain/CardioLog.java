package com.estesfitnesshelp.model.domain;

import java.util.Calendar;
import java.io.Serializable;

/*
 * Class CardioLog contains the time and date of cardio completed
 * 
 * @author Will Estes
 * */
public class CardioLog implements Serializable{

	/*Serializable using default serialVersionUID*/
	private static final long serialVersionUID = 4404737677900360665L;
	/*Number of Minutes performed*/
	private Integer numMin;  
	/*Number of Seconds performed */
	private Integer numSec;  
	/*Calendar to set the date*/
	private Calendar cal = Calendar.getInstance();	
	
	/*Constructor*/
	public CardioLog(Integer numSec, Integer numMin){
		this.numSec = numSec;
		this.numMin = numMin;
	}
	
	/*Gets the number of seconds
	 * @return numSec*/
	public Integer getNumSecs() {
		return numSec;
	}
	
	/*Sets the number of seconds
	 * @param numSec  number of seconds*/
	public void setNumSecs(int numSec) {
		this.numSec = numSec;
	}
	
	/*Gets the number of minutes
	 * @return numMin*/
	public Integer getNumMin() {
		return numMin;
	}
	
	/*Sets the number of minutes
	 * @param numMin  number of minutes*/
	public void setNumMin(int numMin) {
		this.numMin = numMin;
	}
	
	/*Checks for valid inputs
	 * @return  true if valid, false otherwise*/
	public boolean validate() {
		if(numSec == null) return false;
		if(numMin == null) return false;
		return true;
	}
	
	/*Sets the date
	 * @param year   year of exercise
	 * @param month  month of exercise
	 * @param day    day of exercise
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
				+ ((numSec == null) ? 0 : numSec.hashCode());
		result = prime * result
				+ ((numMin == null) ? 0 : numMin.hashCode());
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
		CardioLog other = (CardioLog) obj;
		if (numMin == null) {
			if (other.numMin != null)
				return false;
		} else if (!numMin.equals(other.numMin))
			return false;
		if (numSec == null) {
			if (other.numSec != null)
				return false;
		} else if (!numSec.equals(other.numSec))
			return false;
		return true;
	}
	
	public String toString()
	{
	  StringBuffer strBfr = new StringBuffer();
	  strBfr.append("Number of Mins :");
	  strBfr.append(numMin);
	  strBfr.append("\nNumber of Secs :");
	  strBfr.append(numSec);
	
	  return strBfr.toString();
	}		
}
