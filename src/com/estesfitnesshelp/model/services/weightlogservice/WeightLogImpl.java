package com.estesfitnesshelp.model.services.weightlogservice;

import com.estesfitnesshelp.model.domain.WeightLog;
import com.estesfitnesshelp.model.services.exception.WeightLogException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * @author Will Estes
 * */
public class WeightLogImpl implements IWeightLogService {

	private WeightLog weightLog;
	
	/*Sets the date of the weight log
	 * 
	 * @param year   year of log
	 * @param month  month of log
	 * @param day    day of log
	 * 
	 * @return boolean  true if valid, false otherwise
	 * */
	public boolean setDate(int year, int month, int day) {
		weightLog.setDate(year, month, day);
		System.out.printf("Date set to: %4d/%02d/%02d %02d:%02d:%02d\n",  // Pad with zero
		                   year, month+1, day);
		return true;
	}
	
	/*
	 * Stores log to file
	 * 
	 * @param WeightLog    contains sets, reps, and weight
	 * 
	 * @return boolean     true if valid, false otherwise
	 * */
	public boolean storeLog(WeightLog weightLog) throws WeightLogException{
		boolean isSuccess = false;
		ObjectOutputStream outFile = null;

		try {
			if(weightLog != null){
				outFile = new ObjectOutputStream(new FileOutputStream("WeightLog.txt"));
				outFile.writeObject(weightLog);
				outFile.flush();
				outFile.close();
				isSuccess = true;
				System.out.println("Weight Log Stored");
			} else {
				throw new WeightLogException("Error: WeightLog is null");
			}
		
		} catch (FileNotFoundException fnfe){
			throw new WeightLogException("Error: File not found");
		} catch (IOException ioe){
			throw new WeightLogException("Error: IO Exception");
		} finally {
			if(weightLog == null){
				System.out.println("Error: weightLog == null");
			}
		}
	return isSuccess;
	
	}
	
	/*
	 * Check to see if log exists
	 * @param weightLog    contains sets, reps, and weight
	 * 
	 * @return boolean     true if exists, false if not
	 * */
	public boolean getLog(WeightLog weightLog) throws WeightLogException {
		boolean isSuccess = false;

		try {
			if(weightLog != null){
				ObjectInputStream inObj = 
						new ObjectInputStream(new FileInputStream("WeightLog.txt"));
				weightLog = (WeightLog)inObj.readObject();
				inObj.close();
				isSuccess = true;
				System.out.println("Weight Log Found");
			} else {
				throw new WeightLogException("Error: No Log Exists");
			}
		} catch (FileNotFoundException fnfe){
			throw new WeightLogException("Error: File not found");
		} catch (IOException ioe){
			throw new WeightLogException("Error: IO Exception");
		} catch (ClassNotFoundException e) {
			throw new WeightLogException("Error: Class Not Found");
		} finally {
			if(weightLog == null){
				System.out.println("Error: weightLog == null");
			}
		}
		return isSuccess;
	}
}
