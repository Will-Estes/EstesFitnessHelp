package com.estesfitnesshelp.model.services.weightexerciseservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.estesfitnesshelp.model.domain.WeightExercises;
import com.estesfitnesshelp.model.services.exception.WeightExercisesException;


/*
 * @author Will Estes
 * */

public class WeightExerciseImpl implements IWeightExerciseService{
	
	/*Verifies if exercise exists
	 * @param exercise    contains name, bodypart, and type
	 * 
	 * @return boolean    true if exists, false otherwise
	 * */
	public boolean checkExercise(WeightExercises exercise) 
	  throws WeightExercisesException {
		boolean isSuccess = false;
		
		try {
			if(exercise != null){
				ObjectInputStream inObj = 
						new ObjectInputStream(new FileInputStream("WeightExercises.txt"));
				exercise = (WeightExercises)inObj.readObject();
				inObj.close();
				isSuccess = true;
				System.out.println("Weight Exercise Found");
			} else {
				throw new WeightExercisesException("Error: No Exercise Exists");
			}
		} catch (FileNotFoundException fnfe){
			throw new WeightExercisesException("Error: File not found");
		} catch (IOException ioe){
			throw new WeightExercisesException("Error: IO Exception");
		} catch (ClassNotFoundException e) {
			throw new WeightExercisesException("Error: Class Not Found");
		} finally {
			if(exercise == null){
				System.out.println("Error: exercise == null");
			}
		}
		return isSuccess;
	}

	/*
	 * Stores exercise to file
	 * 
	 * @param WeightExercises    contains name, bodypart, and type
	 * 
	 * @return boolean     true if valid, false otherwise
	 * */
	public boolean storeExercise(WeightExercises weightExercise) 
	  throws WeightExercisesException{
		boolean isSuccess = false;
		
		try {
			if(weightExercise != null){
				ObjectOutputStream outFile = 
						new ObjectOutputStream(new FileOutputStream("WeightExercises.txt"));
				outFile.writeObject(weightExercise);
				outFile.flush();
				outFile.close();
				isSuccess = true;
				System.out.println("Weight Exercise Stored");
			} else {
				throw new WeightExercisesException("Error: WeightExercise is null");
			}
		
		} catch (FileNotFoundException fnfe){
			throw new WeightExercisesException("Error: File not found");
		} catch (IOException ioe){
			throw new WeightExercisesException("Error: IO Exception");
		} finally {
			if(weightExercise == null){
				System.out.println("Error: weightExercise == null");
			}
		}
	return isSuccess;
	
	}
}
