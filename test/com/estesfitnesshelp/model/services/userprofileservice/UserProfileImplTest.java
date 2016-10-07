package com.estesfitnesshelp.model.services.userprofileservice;

import junit.framework.TestCase;
import org.junit.Test;

import com.estesfitnesshelp.model.business.exception.ServiceLoadException;
import com.estesfitnesshelp.model.domain.UserProfile;
import com.estesfitnesshelp.model.services.exception.UserProfileException;
import com.estesfitnesshelp.model.services.factory.ServiceFactory;
import com.estesfitnesshelp.model.services.propertymanager.PropertyManager;

public class UserProfileImplTest extends TestCase {

	private UserProfile user;
	private ServiceFactory serviceFactory;
	private IUserProfileService userProfileService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String propertyFileLoc = System.getProperty("prop_location");
		PropertyManager.loadProps(propertyFileLoc);
		serviceFactory = ServiceFactory.getInstance();
		user = new UserProfile("Will", "Will123", 23, "WillEstes@Yahoo.com", 71.0, 215.0);
		new UserProfileImpl();
		try{
			userProfileService = 
					(IUserProfileService) 
					serviceFactory.getService(IUserProfileService.NAME);
		} catch (ServiceLoadException sle){
			sle.printStackTrace();
			System.out.println("Failed:UserProfileImplTest:ServiceLoadException");
		}
	}
	@Test
	public void testAuthenticateUser() {
		try {
			assertTrue(userProfileService.authenticateUser(user));
			System.out.println("testAuthenticateUser PASSED");
		} catch (UserProfileException e) {
			e.printStackTrace();
			System.out.println("Fail UserProfileException");
		}
	}

	public void testAuthenticateUserImpl() {
		UserProfileImpl userProfileImpl;
		try {
			userProfileImpl = 
					(UserProfileImpl) serviceFactory.getService(UserProfileImpl.NAME);
			assertTrue(userProfileImpl.authenticateUser(user));
			System.out.println("testAuthenticateUser PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Fail ServiceLoadException");
		} catch (UserProfileException e) {
			e.printStackTrace();
			System.out.println("Fail UserProfileException");
		}
	}
}
