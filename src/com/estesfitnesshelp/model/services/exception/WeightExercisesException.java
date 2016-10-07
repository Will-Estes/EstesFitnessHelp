package com.estesfitnesshelp.model.services.exception;

public class WeightExercisesException extends Exception{

	/**
	 * @author Will Estes
	 */
	private static final long serialVersionUID = 6014906830120560188L;

	public WeightExercisesException(final String iMessage) {
		
		super(iMessage);
		
	}
	
	public WeightExercisesException(final String inMessage, final Throwable inNestedException) {
        super(inMessage, inNestedException);
    }
}
