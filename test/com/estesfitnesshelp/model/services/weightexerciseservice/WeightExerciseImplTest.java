package com.estesfitnesshelp.model.services.weightexerciseservice;

import junit.framework.TestCase;
import org.junit.Test;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.domain.WeightExercises;
import com.estesfitnesshelp.model.services.exception.WeightExercisesException;
import com.estesfitnesshelp.model.services.factory.ServiceFactory;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;

public class WeightExerciseImplTest extends TestCase{

	private ServiceFactory serviceFactory;
	private WeightExercises exercise;
	private IWeightExerciseService weightExerciseService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String propertyFileLoc = System.getProperty("prop_location");
		PropertyManager.loadProps(propertyFileLoc);
		serviceFactory = ServiceFactory.getInstance();
		exercise = new WeightExercises("Bench Press", "Chest", "Compound");
		new WeightExerciseImpl();
		try{
			weightExerciseService = 
					(IWeightExerciseService) 
					serviceFactory.getService(IWeightExerciseService.NAME);
		} catch (ServiceLoadException sle) {
			sle.printStackTrace();
			System.out.println("Failed:WeightExerciseImplTest: ServiceLoadException");
		}
	}
	
	@Test
	public void testStoreExercise() {
		try {
			assertTrue(weightExerciseService.storeExercise(exercise));
			System.out.println("CheckExercise Passed");
		} catch (WeightExercisesException e) {
			e.printStackTrace();
			System.out.println("Fail WeightExercisesException");
		}
	}
	
	public void testStoreExerciseImpl() {
		WeightExerciseImpl WEImpl;
		try {
			WEImpl = (WeightExerciseImpl) serviceFactory.getService(WeightExerciseImpl.NAME);
			assertTrue(WEImpl.storeExercise(exercise));
			System.out.println("CheckExercise Passed");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Fail ServiceLoadException");
		} catch (WeightExercisesException e) {
			e.printStackTrace();
			System.out.println("Fail WeightExercisesException");
		}
	}
	
	public void testCheckExercise() {
		try {
			assertTrue(weightExerciseService.checkExercise(exercise));
			System.out.println("CheckExercise Passed");
		} catch (WeightExercisesException e) {
			e.printStackTrace();
			System.out.println("Fail WeightExercisesException");
		}
	}
	
	public void testCheckExerciseImpl() {
		WeightExerciseImpl WEImpl;
		try {
			WEImpl = (WeightExerciseImpl) serviceFactory.getService(WeightExerciseImpl.NAME);
			assertTrue(WEImpl.checkExercise(exercise));
			System.out.println("CheckExercise Passed");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Fail ServiceLoadException");
		} catch (WeightExercisesException e) {
			e.printStackTrace();
			System.out.println("Fail WeightExercisesException");
		}
	}


}
