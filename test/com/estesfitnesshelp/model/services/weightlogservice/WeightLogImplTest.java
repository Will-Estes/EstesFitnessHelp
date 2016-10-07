package com.estesfitnesshelp.model.services.weightlogservice;

import junit.framework.TestCase;
import org.junit.Test;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.domain.*;
import com.estesfitnesshelp.model.services.exception.WeightLogException;
import com.estesfitnesshelp.model.services.factory.ServiceFactory;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;

public class WeightLogImplTest extends TestCase{

	private WeightLog weightLog;
	private ServiceFactory serviceFactory;
	private IWeightLogService weightLogService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String propertyFileLoc = System.getProperty("prop_location");
		PropertyManager.loadProps(propertyFileLoc);
		serviceFactory = ServiceFactory.getInstance();
		weightLog = new WeightLog(4, 10, 205.0);
		new WeightLogImpl();
		try {
			weightLogService = 
					(IWeightLogService) serviceFactory.getService(IWeightLogService.NAME);
		} catch (ServiceLoadException sle) {
			sle.printStackTrace();
			System.out.println("Failed: WeightLogImplTest: ServiceLoadException");
		}
		
	}
	
	@Test
	public void testStoreLog() {
		try {
			assertTrue(weightLogService.storeLog(weightLog));
			System.out.println("StoreLog Passed");
		} catch (WeightLogException e) {
			e.printStackTrace();
			System.out.println("Fail Weight Log Exception");
		}
	}	
		
	public void testStoreLogImpl() {	
		WeightLogImpl WLServiceImpl;
		try {
			WLServiceImpl = (WeightLogImpl) serviceFactory.getService(WeightLogImpl.NAME);
			assertTrue(WLServiceImpl.storeLog(weightLog));
			System.out.println("StoreLogImpl Passed");
		} catch (ServiceLoadException e) {
			System.out.println("Fail Service Load Exception");
			e.printStackTrace();
		} catch (WeightLogException e) {
			e.printStackTrace();
			System.out.println("Fail WeightLogException");
		}
	}
	
	public void testGetLog() {
		try {
			assertTrue(weightLogService.getLog(weightLog));
			System.out.println("Get Log Passed");
		} catch (WeightLogException e) {
			e.printStackTrace();
			System.out.println("Fail Weight Log Exception");
		}
	}	
		
	public void testGetLogImpl() {	
		WeightLogImpl WLServiceImpl;
		try {
			WLServiceImpl = (WeightLogImpl) serviceFactory.getService(WeightLogImpl.NAME);
			assertTrue(WLServiceImpl.getLog(weightLog));
			System.out.println("GetLogImpl Passed");
		} catch (ServiceLoadException e) {
			System.out.println("Fail Service Load Exception");
			e.printStackTrace();
		} catch (WeightLogException e) {
			e.printStackTrace();
			System.out.println("Fail WeightLogException");
		}
	}

}
