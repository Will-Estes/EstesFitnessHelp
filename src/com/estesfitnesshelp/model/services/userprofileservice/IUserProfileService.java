package com.estesfitnesshelp.model.services.userprofileservice;

import com.estesfitnesshelp.model.domain.UserProfile;
import com.estesfitnesshelp.model.services.IService;
import com.estesfitnesshelp.model.services.exception.UserProfileException;

/*
 * @author Will Estes
 * 
 * */

public interface IUserProfileService extends IService{

	public final String NAME = "IUserProfileService";
	
	/*
	 * Authenticates that user is a valid user
	 * @param user                  contains user information to be validated
	 * 
	 * @throws UserProfileException if UserProfile is null
	 *                              if UserProfile is not valid
	 *                              if other exception occurs
	 * 
	 * @return boolean              true if valid
	 *                              false if not valid                               
	 * 
	 * */
	public boolean authenticateUser(UserProfile user)
	     throws UserProfileException;

}
