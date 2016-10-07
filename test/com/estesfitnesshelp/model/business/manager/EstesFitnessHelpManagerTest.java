package com.estesfitnesshelp.model.business.manager;

import org.junit.Test;

import com.estesfitnesshelp.model.domain.CardioLog;
import com.estesfitnesshelp.model.domain.WeightLog;
import com.estesfitnesshelp.model.services.cardiologservice.ICardioLogService;
import com.estesfitnesshelp.model.services.weightlogservice.IWeightLogService;
import junit.framework.TestCase;

public class EstesFitnessHelpManagerTest extends TestCase{

	private EstesFitnessHelpManager fitnessHelpManager;
	private WeightLog weightLog;
	private CardioLog cardioLog;
	
	@Test
	protected void setUp() throws Exception{
		super.setUp();
		fitnessHelpManager = EstesFitnessHelpManager.getInstance();
		weightLog = new WeightLog(4, 10, 200.0);
		cardioLog = new CardioLog(30, 45);
	}

	public final void testPerformWeightLogAction(){
		boolean action = false;
		action = fitnessHelpManager.performWeightLogAction("LogWorkout", weightLog);
		assertTrue(action);	
	}
	
	public final void testStoreWeightLog() {
		boolean action = false;
		action = fitnessHelpManager.storeLog(IWeightLogService.NAME, weightLog);
		assertTrue(action);
	}
	public final void testGetWeightLog() {
		boolean action = false;
		action = fitnessHelpManager.getLog(IWeightLogService.NAME, weightLog);
		assertTrue(action);
	}
	
	public final void testStoreCardioLog() {
		boolean action = false;
		action = fitnessHelpManager.storeCLog(ICardioLogService.NAME, cardioLog);
		assertTrue(action);
	}
}
