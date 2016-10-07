package com.estesfitnesshelp.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeightLogTest {

	@Test
	public void test() {
		WeightLog wLog1 = new WeightLog(3, 10, 205.00);
		WeightLog wLog2 = new WeightLog(3, 10, 205.00);
		if(wLog1.validate()){
			System.out.println("TRUE");
		}
		if(wLog2.validate()){
			System.out.println("TRUE");
		}
		assertNotSame(wLog1, wLog2);
	}

}
