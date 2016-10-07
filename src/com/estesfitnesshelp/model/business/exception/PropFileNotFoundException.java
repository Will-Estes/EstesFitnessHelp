package com.estesfitnesshelp.model.business.exception;

public class PropFileNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6914885026778919148L;

	public PropFileNotFoundException(final String inMessage, final Throwable inNestedException) {
        super(inMessage, inNestedException);
	}
	
}
