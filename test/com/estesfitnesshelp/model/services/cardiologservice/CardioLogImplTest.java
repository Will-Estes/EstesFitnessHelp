package com.estesfitnesshelp.model.services.cardiologservice;

import junit.framework.TestCase;
import org.junit.Test;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.domain.*;
import com.estesfitnesshelp.model.services.exception.CardioLogException;
import com.estesfitnesshelp.model.services.factory.ServiceFactory;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;

public class CardioLogImplTest extends TestCase{

	private ServiceFactory serviceFactory;
	private CardioLog cardioCLog;
	private ICardioLogService cardioLogService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String propertyFileLoc = System.getProperty("prop_location");
		PropertyManager.loadProps(propertyFileLoc);
		serviceFactory = ServiceFactory.getInstance();
		cardioCLog = new CardioLog(20, 00);
		new CardioLogImpl();
		try{
			cardioLogService = 
					(ICardioLogService) serviceFactory.getService(ICardioLogService.NAME);
		} catch (ServiceLoadException sle){
			sle.printStackTrace();
			System.out.println("Failed: CardioLogImplTest: ServiceLoadException");
		}
	}
	@Test
	public void testStoreCLog() {
		try {
			assertTrue(cardioLogService.storeCLog(cardioCLog));
			System.out.println("StoreCLog Passed");
		} catch (CardioLogException e) {
			e.printStackTrace();
			System.out.println("Fail Cardio CLog Exception");
		}
	}	
		
	public void testStoreCLogImpl() {	
		CardioLogImpl CLServiceImpl;
		try {
			CLServiceImpl = (CardioLogImpl) serviceFactory.getService(CardioLogImpl.NAME);
			assertTrue(CLServiceImpl.storeCLog(cardioCLog));
			System.out.println("StoreCLogImpl Passed");
		} catch (ServiceLoadException e) {
			System.out.println("Fail Service Load Exception");
			e.printStackTrace();
		} catch (CardioLogException e) {
			e.printStackTrace();
			System.out.println("Fail CardioCLogException");
		}
	}
	
	public void testGetCLog() {
		try {
			CardioLog retrievedCLog = cardioLogService.getCLog(cardioCLog);
			assertTrue(retrievedCLog instanceof CardioLog);
			System.out.println("GetCLog Passed");
		} catch (CardioLogException e) {
			e.printStackTrace();
			System.out.println("Fail Cardio CLog Exception");
		}
	}	
		
	public void testGetCLogImpl() {	
		CardioLogImpl CLServiceImpl;
		try {
			CLServiceImpl = (CardioLogImpl) serviceFactory.getService(CardioLogImpl.NAME);
			CardioLog retrievedCLog = CLServiceImpl.getCLog(cardioCLog);
			assertTrue(retrievedCLog instanceof CardioLog);
			System.out.println("GetCLogImpl Passed");
		} catch (ServiceLoadException e) {
			System.out.println("Fail Service Load Exception");
			e.printStackTrace();
		} catch (CardioLogException e) {
			e.printStackTrace();
			System.out.println("Fail CardioCLogException");
		}
	}
	

}
