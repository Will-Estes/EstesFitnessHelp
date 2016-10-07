package com.estesfitnesshelp.model.services.exception;

/*
 * 
 *@author Will Estes 
 * */

public class WeightLogException extends Exception{
	
	private static final long serialVersionUID = 4640262892287791215L;

	public WeightLogException(final String iMessage) {
		
		super(iMessage);
		
	}
	
	public WeightLogException(final String inMessage, final Throwable inNestedException) {
        super(inMessage, inNestedException);
    }
}
