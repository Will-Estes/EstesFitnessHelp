package com.estesfitnesshelp.model.services.factory;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.services.IService;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;


public class ServiceFactory {

	private ServiceFactory() {}
	private static ServiceFactory serviceFactoryInstance;

	//check to make sure only one instantiation exists
	public static ServiceFactory getInstance() {
		if(serviceFactoryInstance == null){
			serviceFactoryInstance = new ServiceFactory();
		}
		return serviceFactoryInstance;
	}
	
	//Pass in service name
	//returns whether or not service name can be found
	public IService getService(String name) throws ServiceLoadException {
		try {
			Class<?> c = Class.forName(getImplName(name));
			return (IService)c.newInstance();
		} catch (Exception e) {
			throw new ServiceLoadException(name + " not loaded", e);
		}
	}
	
	//go to property manager and search for property value by name passed
	private String getImplName (String name){
		return PropertyManager.getPropValue(name);
	}
}
