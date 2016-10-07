package com.estesfitnesshelp.model.services.cardioexerciseservice;

import junit.framework.TestCase;
import org.junit.Test;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.domain.*;
import com.estesfitnesshelp.model.services.exception.CardioExerciseException;
import com.estesfitnesshelp.model.services.factory.ServiceFactory;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;

public class CardioExerciseImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private CardioExercises exercise;
	private ICardioExerciseService cardioExerciseService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String propertyFileLoc = System.getProperty("prop_location");
		PropertyManager.loadProps(propertyFileLoc);
		serviceFactory = ServiceFactory.getInstance();
		exercise = new CardioExercises("TreadMill");
		new CardioExerciseImpl();
		try{
			cardioExerciseService = 
					(ICardioExerciseService) serviceFactory.getService(ICardioExerciseService.NAME);
		} catch (ServiceLoadException sle) {
			sle.printStackTrace();
			System.out.println("Failed:CardioExerciseImplTest:ServiceLoadException");
		}
	}
	
	@Test
	public void testStoreCExercise() {
		try {
			assertTrue(cardioExerciseService.storeCExercise((CardioExercises) exercise));
			System.out.println("CheckExercise Passed");
		} catch (CardioExerciseException e) {
			e.printStackTrace();
			System.out.println("Fail CardioExerciseException");
		} 
	}
	
	public void testStoreExerciseImpl(){
		CardioExerciseImpl EXSvcImpl;
		try {
			EXSvcImpl = (CardioExerciseImpl) serviceFactory.getService(CardioExerciseImpl.NAME);
			assertTrue(EXSvcImpl.storeCExercise((CardioExercises) exercise));
			System.out.println("CheckExerciseImpl Passed");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Fail at ServiceLoadException");
		} catch (CardioExerciseException e) {
			e.printStackTrace();
			System.out.println("Fail at CardioExerciseException");
		}
	}
	
	public void testCheckExercise() {
		try {
			CardioExercises retExercise = 
					cardioExerciseService.checkExercise(exercise);
			assertTrue(retExercise instanceof CardioExercises);
			System.out.println("CheckExercise Passed");
		} catch (CardioExerciseException e) {
			e.printStackTrace();
			System.out.println("Fail CardioExerciseException");
		} 
	}
	
	public void testCheckExerciseImpl(){
		CardioExerciseImpl EXSvcImpl;
		try {
			EXSvcImpl = (CardioExerciseImpl) serviceFactory.getService(CardioExerciseImpl.NAME);
			CardioExercises retExercise = EXSvcImpl.checkExercise(exercise);
			assertTrue(retExercise instanceof CardioExercises);
			System.out.println("CheckExerciseImpl Passed");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Fail at ServiceLoadException");
		} catch (CardioExerciseException e) {
			e.printStackTrace();
			System.out.println("Fail at CardioExerciseException");
		}
	}

}
