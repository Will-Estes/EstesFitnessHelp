package com.estesfitnesshelp.model.services.userprofileservice;

import com.estesfitnesshelp.model.domain.UserProfile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.estesfitnesshelp.model.services.exception.UserProfileException;

/*
 * 
 * @author Will Estes
 * */
public class UserProfileImpl implements IUserProfileService{

	public boolean authenticateUser(UserProfile user) throws UserProfileException{
		boolean isSuccess = false;

		try {
			if(user != null) {
				ObjectInputStream inObj = 
						new ObjectInputStream(new FileInputStream("UserProfile.txt"));
				user = (UserProfile)inObj.readObject();
				inObj.close();
				isSuccess = true;
		    } else {
		    	throw new UserProfileException("Fail at UserProfileException");
		    }
		} catch (FileNotFoundException fnfe) {
			throw new UserProfileException("Fail at FileNotFoundException");
		} catch (IOException ioe) {
		    throw new UserProfileException("Fail at IOException");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new UserProfileException("Fail at ClassNotFoundException");
		} finally {
			if(user == null){
				System.out.println("Error: user == null");
			}
		}
		return isSuccess;
	}

}
