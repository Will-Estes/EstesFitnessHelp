package com.estesfitnesshelp.model.services.cardiologservice;

import com.estesfitnesshelp.model.domain.CardioLog;
import com.estesfitnesshelp.model.services.IService;
import com.estesfitnesshelp.model.services.exception.CardioLogException;

/*
 * @author Will Estes
 * */
public interface ICardioLogService extends IService{

	public final String NAME = "ICardioLogService";
	
	/*sets the date of the CardioLog
	 * @param year   year of log
	 * @param month  month of log
	 * @param day    day of log
	 * 
	 * @return boolean  true if valid, false otherwise*/
	public boolean setDate(int year, int month, int day)
	  throws CardioLogException;
	
	/* stores the cardio log in the file
	 * @param cardioLog   contains minutes and seconds
	 * 
	 * @return boolean    true if valid, false otherwise
	 * */
	public boolean storeCLog(CardioLog cardioLog)
	  throws CardioLogException;
	
	/*verifies if log exists
	 * @param cardioLog   contains minuts and seconds
	 * 
	 * @return boolean    true if valid, false otherwise
	 * */
	public CardioLog getCLog(CardioLog cardioLog)
	  throws CardioLogException;
}
