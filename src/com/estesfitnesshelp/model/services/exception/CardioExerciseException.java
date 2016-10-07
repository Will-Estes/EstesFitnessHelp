package com.estesfitnesshelp.model.services.exception;

public class CardioExerciseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8371249518404207767L;
	
	public CardioExerciseException(final String iMessage) {
		
		super(iMessage);
		
	}
	
	public CardioExerciseException(final String inMessage, final Throwable inNestedException) {
        super(inMessage, inNestedException);
    }
}
