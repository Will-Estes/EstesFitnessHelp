package com.estesfitnesshelp.model.services.factory;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.estesfitnesshelp.model.services.weightexerciseservice.*;
import com.estesfitnesshelp.model.services.weightlogservice.*;
import com.estesfitnesshelp.model.services.cardiologservice.*;
import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.services.cardioexerciseservice.*;
import com.estesfitnesshelp.model.services.userprofileservice.*;

public class ServiceFactoryTest {
	ServiceFactory serviceFactory;
	
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
	}
	
	
	@Test
	public void testGetUserProfileService() {
		IUserProfileService userProfile;
		try {
			userProfile = (IUserProfileService) serviceFactory.getService(IUserProfileService.NAME);
			assertTrue(userProfile instanceof UserProfileImpl);
			System.out.println("Passed 1");
		} catch (ServiceLoadException e){
			System.out.println("Failed 1");
			e.printStackTrace();
		}
	}
	@Test
	public void testGetWeightExerciseService() {
		IWeightExerciseService WExercise;
		try {
			WExercise = (IWeightExerciseService) 
				serviceFactory.getService(IWeightExerciseService.NAME);
			assertTrue(WExercise instanceof WeightExerciseImpl);
			System.out.println("Passed 2");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Failed 2");
		}
	}
	@Test
	public void testGetCardioExerciseService() {
		ICardioExerciseService CExercise;
		try {
			CExercise = (ICardioExerciseService) 
				serviceFactory.getService(ICardioExerciseService.NAME);
			assertTrue(CExercise instanceof CardioExerciseImpl);
			System.out.println("Passed 3");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Fail 3");
		}
	}
	@Test
	public void testGetWeightLogService() {
		IWeightLogService WLog;
		try {
			WLog = (IWeightLogService)
					serviceFactory.getService(IWeightLogService.NAME);
			assertTrue(WLog instanceof WeightLogImpl);
			System.out.println("Passed 4");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Failed 4");
		}
	}
	@Test
	public void testGetCardioLogService() {
		ICardioLogService CLog;
		try {
			CLog = (ICardioLogService) 
				serviceFactory.getService(ICardioLogService.NAME);
			assertTrue(CLog instanceof CardioLogImpl);
			System.out.println("Passed 5");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Failed 5");
		}
	}
}
