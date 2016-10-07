package com.estesfitnesshelp.model.business.exception;

public class ServiceLoadException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8060353292645279766L;

	public ServiceLoadException(final String inMessage, final Throwable inNestedException) {
	        super(inMessage, inNestedException);
    }
}
