package com.estesfitnesshelp.model.services.exception;

public class CardioLogException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7014557872867521054L;

	public CardioLogException(final String iMessage) {
		
		super(iMessage);
		
	}
	
	public CardioLogException(final String inMessage, final Throwable inNestedException) {
        super(inMessage, inNestedException);
    }
}
