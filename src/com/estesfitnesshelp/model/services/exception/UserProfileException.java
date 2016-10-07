package com.estesfitnesshelp.model.services.exception;

/*
 * @author Will Estes
 * 
 * */

public class UserProfileException extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8063186667588526003L;

	public UserProfileException(final String iMessage){
		
		super(iMessage);
		
	}
	
	public UserProfileException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
	
}
