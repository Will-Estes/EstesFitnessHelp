package com.estesfitnesshelp.model.services.weightlogservice;

import com.estesfitnesshelp.model.domain.WeightLog;
import com.estesfitnesshelp.model.services.IService;
import com.estesfitnesshelp.model.services.exception.WeightLogException;

/*
 * 
 * @author Will Estes
 * */
public interface IWeightLogService extends IService{

	public final String NAME = "IWeightLogService";
	
	/*Sets the date of the log
	 * @param year   year of the log
	 * @param month  month of log
	 * @param day    day of log
	 * 
	 * @return boolean   true if valid, false if not valid*/
	public boolean setDate(int year, int month, int day)
	  throws WeightLogException;
	
	/*Stores the log to the file
	 * @param weightLog   contains the number of sets, reps, and weight
	 * 
	 * @return boolean    true if valid, false otherwise*/
	public boolean storeLog(WeightLog weightLog)
	  throws WeightLogException;
	
	/*Gets the log from the file
	 * @param weightLog    contains the number of sets, reps, and weight
	 * 
	 * @return boolean     true if valid, false otherwise*/
	public boolean getLog(WeightLog weightLog)
			  throws WeightLogException;
}
