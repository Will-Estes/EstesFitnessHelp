package com.estesfitnesshelp.model.business.factory;

import static org.junit.Assert.*;

import com.estesfitnesshelp.model.services.factory.ServiceFactory;

import junit.framework.TestCase;

@SuppressWarnings("unused")
public class ServiceFactoryTest extends TestCase{

	ServiceFactory serviceFactory;
	
	public void setUp() throws Exception{
		serviceFactory = ServiceFactory.getInstance();
	}
	
	public void testInstance() {
		assertNotNull(serviceFactory);
		System.out.println("Business:ServiceFactoryTest:Passed");
	}
	
}
