package com.estesfitnesshelp.model.services.weightexerciseservice;

import com.estesfitnesshelp.model.domain.WeightExercises;
import com.estesfitnesshelp.model.services.IService;
import com.estesfitnesshelp.model.services.exception.WeightExercisesException;

/*
 * @author Will Estes
 * */
public interface IWeightExerciseService extends IService{
	
	public final String NAME = "IWeightExerciseService";
	/*Verifies if exercise exists
	 * @param exercise    contains name, bodypart, and type
	 * 
	 * @return boolean    true if exists, false otherwise
	 * */
	public boolean checkExercise(WeightExercises exercise)
	  throws WeightExercisesException;
	
	/*
	 * Stores exercise to file
	 * 
	 * @param WeightExercises    contains name, bodypart, and type
	 * 
	 * @return boolean     true if valid, false otherwise
	 * */
	public boolean storeExercise(WeightExercises weightExercise) 
			  throws WeightExercisesException;
}
