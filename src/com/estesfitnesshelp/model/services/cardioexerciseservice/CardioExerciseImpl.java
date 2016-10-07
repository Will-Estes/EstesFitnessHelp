package com.estesfitnesshelp.model.services.cardioexerciseservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.estesfitnesshelp.model.domain.CardioExercises;
import com.estesfitnesshelp.model.services.exception.CardioExerciseException;

/*
 * @author Will Estes
 * */
public class CardioExerciseImpl implements ICardioExerciseService{
	
	/*Validates exercise exists
	 * @param exercise    contains name and type
	 * 
	 * @return boolean    true if exists, false otherwise
	 * */
	public CardioExercises checkExercise(CardioExercises exercise) 
	  throws CardioExerciseException{
		
		try {
			if(exercise != null){
				ObjectInputStream inObj = 
						new ObjectInputStream(new FileInputStream("CardioExercises.txt"));
				exercise = (CardioExercises)inObj.readObject();
				inObj.close();
			} else {
				throw new CardioExerciseException("Error: No Exercise Exists");
			}
		} catch (FileNotFoundException fnfe){
			throw new CardioExerciseException("Error: File not found");
		} catch (IOException ioe){
			throw new CardioExerciseException("Error: IO Exception");
		} catch (ClassNotFoundException e) {
			throw new CardioExerciseException("Error: Class Not Found");
		} finally {
			if(exercise == null){
				System.out.println("Error: exercise == null");
			}
		}
		return exercise;
	}
	
	/*Adds exercise to file
	 * @param exercise    contains name and type
	 * 
	 * @return boolean    true if added, false otherwise
	 * */
	public boolean storeCExercise(CardioExercises cardioExercise) throws CardioExerciseException{
		boolean isSuccess = false;
		
		try {
			if(cardioExercise != null){
				ObjectOutputStream outFile = 
						new ObjectOutputStream(new FileOutputStream("CardioExercises.txt"));
				outFile.writeObject(cardioExercise);
				outFile.flush();
				outFile.close();
				isSuccess = true;
			} else {
				throw new CardioExerciseException("Error: CardioExercise is null");
			}
		
		} catch (FileNotFoundException fnfe){
			throw new CardioExerciseException("Error: File not found");
		} catch (IOException ioe){
			throw new CardioExerciseException("Error: IO Exception");
		} finally {
			if(cardioExercise == null){
				System.out.println("Error: cardioExercise == null");
			}
		}
		return isSuccess;
	}

}
