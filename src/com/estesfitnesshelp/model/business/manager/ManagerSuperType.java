package com.estesfitnesshelp.model.business.manager;

import com.estesfitnesshelp.model.business.exception.PropFileNotFoundException;
import com.estesfitnesshelp.model.domain.CardioLog;
import com.estesfitnesshelp.model.domain.WeightLog;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;

/**
 * What you're seeing below, is called a static initializer block,
 * which gets executed at the time when the class that contains it or extends it is referenced.
 * 
 * What we hope to achieve in this application is that when the EstesFitnessHelpManager(which extends this class)
 * is referenced, we want the application properties to be loaded up so the properties contents are available
 * for use by all tiers under the business tier.
 * Reference site on static initializer block:
 * http://www.developer.com/java/other/article.php/2238491/The-Essence-of-OOP-using-Java-Static-Initializer-Blocks.htm
 * 
 **/

public abstract class ManagerSuperType {

	static {
		try {
			ManagerSuperType.loadProps();
		} catch (PropFileNotFoundException propertyFileLocation){
			System.out.println("Properties file failed. Program Exit");
			System.exit(1);
		}
	}
	
	public abstract boolean performWeightLogAction(String commandString, WeightLog weightLog); 
	public abstract boolean performCardioLogAction(String commandString, CardioLog cLog);

	//Loads the properties file for use from this layer and down
	public static void loadProps() throws PropFileNotFoundException{
		String propertyFileLocation = "config\\application.properties";
		PropertyManager.loadProps(propertyFileLocation);
	}
}
