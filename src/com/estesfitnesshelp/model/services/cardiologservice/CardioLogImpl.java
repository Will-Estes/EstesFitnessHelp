package com.estesfitnesshelp.model.services.cardiologservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.estesfitnesshelp.model.domain.CardioLog;
import com.estesfitnesshelp.model.services.exception.CardioLogException;

/*
 * @author Will Estes
 * */
public class CardioLogImpl implements ICardioLogService{

	private CardioLog cardioLog;
	
	/*Sets the date of the weight log
	 * 
	 * @param year   year of log
	 * @param month  month of log
	 * @param day    day of log
	 * 
	 * @return boolean  true if valid, false otherwise
	 * */
	public boolean setDate(int year, int month, int day) {
		cardioLog.setDate(year, month, day);	
		return true;
	}

	/*Store the cardiolog
	 * @param cardioLog    contains minutes and seconds
	 * 
	 * @return boolean     true if valid, false otherwise*/
	public boolean storeCLog(CardioLog cardioLog) throws CardioLogException{
		boolean isSuccess = false;
		ObjectOutputStream outFile = null;
		try {
			if(cardioLog != null){
				outFile = new ObjectOutputStream(new FileOutputStream("CardioLog.txt"));
				outFile.writeObject(cardioLog);
				outFile.flush();
				outFile.close();
				isSuccess = true;
				System.out.println("Cardio Log Stored");
			} else {
				throw new CardioLogException("Error: CardioLog is null");
			}
		
		} catch (FileNotFoundException fnfe){
			throw new CardioLogException("Error: File not found");
		} catch (IOException ioe){
			throw new CardioLogException("Error: IO Exception");
		} finally {
			if(cardioLog == null){
				System.out.println("Error: cardioLog == null");
			}
		}
		return isSuccess;
	}

	/*Validates if CardioLog exists
	 * @param cardioLog    contains minutes and seconds
	 * 
	 * @return boolean     true if found, false otherwise*/
	public CardioLog getCLog(CardioLog cardioLog) throws CardioLogException{
		
		try {
			if(cardioLog != null){
				ObjectInputStream inObj = 
						new ObjectInputStream(new FileInputStream("CardioLog.txt"));
				cardioLog = (CardioLog)inObj.readObject();
				inObj.close();
			} else {
				throw new CardioLogException("Error: No Log Exists");
			}
		} catch (FileNotFoundException fnfe){
			throw new CardioLogException("Error: File not found");
		} catch (IOException ioe){
			throw new CardioLogException("Error: IO Exception");
		} catch (ClassNotFoundException e) {
			throw new CardioLogException("Error: Class Not Found");
		} finally {
			if(cardioLog == null){
				System.out.println("Error: cardioLog == null");
			}
		}
		return cardioLog;
	}

}
