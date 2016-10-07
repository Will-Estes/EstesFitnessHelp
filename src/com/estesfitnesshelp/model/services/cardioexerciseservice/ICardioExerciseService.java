package com.estesfitnesshelp.model.services.cardioexerciseservice;

import com.estesfitnesshelp.model.domain.CardioExercises;
import com.estesfitnesshelp.model.services.exception.CardioExerciseException;
import com.estesfitnesshelp.model.services.IService;

/*
 * @author Will Estes
 * */

public interface ICardioExerciseService extends IService{

	public final String NAME = "ICardioExerciseService";
	/*Validates exercise exists
	 * @param exercise    contains name and type
	 * 
	 * @return boolean    true if exists, false otherwise
	 * */
	public CardioExercises checkExercise(CardioExercises exercise)
	  throws CardioExerciseException;
	
	/*Adds exercise to file
	 * @param exercise    contains name and type
	 * 
	 * @return boolean    true if added, false otherwise
	 * */
	public boolean storeCExercise(CardioExercises cardioExercise) 
	  throws CardioExerciseException;
}
