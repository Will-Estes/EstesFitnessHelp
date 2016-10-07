package com.estesfitnesshelp.model.business.manager;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.domain.CardioLog;
import com.estesfitnesshelp.model.domain.WeightLog;
import com.estesfitnesshelp.model.services.exception.CardioLogException;
import com.estesfitnesshelp.model.services.exception.WeightLogException;
import com.estesfitnesshelp.model.services.factory.ServiceFactory;
import com.estesfitnesshelp.model.services.weightlogservice.IWeightLogService;
import com.estesfitnesshelp.model.services.cardiologservice.ICardioLogService;


/**
 *  This Manager class provides two key functionalities:
 *  1. Has the properties files loaded by the PropertyManager
 *  2. Calls the ServiceFactory class and executes the services being
 *     requested by the controller.
 **/

public class EstesFitnessHelpManager extends ManagerSuperType{

	private static EstesFitnessHelpManager instanceOf;
	
	//Keep constructor private to avoid outside callers
	private EstesFitnessHelpManager(){
		
	}
	
	//Assures that there is only one EstesFitnessHelpManager constructed
	public static synchronized EstesFitnessHelpManager getInstance(){
		if(instanceOf == null){
			instanceOf = new EstesFitnessHelpManager();
		} 
		return instanceOf;
	}

	//Method to call the weightLogAction - both get and log
	@Override
	public boolean performWeightLogAction(String commandString, WeightLog weightLog) {
		boolean action = false;
		if (commandString.equalsIgnoreCase("LogWorkout")){
			action = storeLog(IWeightLogService.NAME, weightLog);
		} else if (commandString.equalsIgnoreCase("GetLog")){
			action = getLog(IWeightLogService.NAME, weightLog);
		} 
		return action;
	}
	
	//Method to call the cardioLogAction
	public boolean performCardioLogAction(String commandString, CardioLog cardioLog){
		boolean action = false;
		if (commandString.equalsIgnoreCase("SaveCLog")){
			action = storeCLog(ICardioLogService.NAME, cardioLog);
		}
		return action;
	}
	
	//Method to store weightLog
	public boolean storeLog(String commandString, WeightLog weightLog){
		boolean isStored = false;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IWeightLogService iWeightLogService;
		
		try {
			iWeightLogService = (IWeightLogService) 
					serviceFactory.getService(commandString);
			isStored = iWeightLogService.storeLog(weightLog);
		} catch (ServiceLoadException sle) {
			sle.printStackTrace();
			System.out.println("EstesFitnessHelpManager - storeLog failed");
		} catch (WeightLogException e) {
			e.printStackTrace();
			System.out.println("EstesFitnessHelpManager - storeLog failed");
		}
		
		return isStored;
	}
	
	//Method to get weightLog
	public boolean getLog(String commandString, WeightLog weightLog){
		boolean isStored = false;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IWeightLogService iWeightLogService;
		
		try {
			iWeightLogService = (IWeightLogService) 
					serviceFactory.getService(commandString);
			isStored = iWeightLogService.getLog(weightLog);
		} catch (ServiceLoadException sle) {
			sle.printStackTrace();
			System.out.println("EstesFitnessHelpManager - Get Log failed");
		} catch (WeightLogException e) {
			e.printStackTrace();
			System.out.println("EstesFitnessHelpManager - Get Log failed");
		}
		
		return isStored;
	}	
	
	//Method to store CardioLog using the factory to verify the service
	public boolean storeCLog(String commandString, CardioLog cLog){
		boolean isStored = false;
		
		//create single instance of service factory
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ICardioLogService iCardioLogService;
		
		//attempt to get the ICardioLogService in the service factory
		try {
			iCardioLogService = (ICardioLogService) 
					serviceFactory.getService(commandString);
			isStored = iCardioLogService.storeCLog(cLog);
		} catch (ServiceLoadException sle) {
			sle.printStackTrace();
			System.out.println("EstesFitnessHelpManager - storeCLog failed");
		} catch (CardioLogException e) {
			e.printStackTrace();
			System.out.println("EstesFitnessHelpManager - storeCLog failed");
		}
		
		return isStored;
	}
	
}
