package com.estesfitnesshelp.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardioLogTest {

	@Test
	public void test() {
		CardioLog cLog1 = new CardioLog(30,00);
		CardioLog cLog2 = new CardioLog(30,00);
		if(cLog1.validate()){
			System.out.println("TRUE");
		}
		if(cLog2.validate()){
			System.out.println("TRUE");
		}
		assertNotSame(cLog1, cLog2);
	}

}
