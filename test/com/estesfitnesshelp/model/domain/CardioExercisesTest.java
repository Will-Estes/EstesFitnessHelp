package com.estesfitnesshelp.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardioExercisesTest {

	@Test
	public void test() {
		CardioExercises exercise1 = new CardioExercises("TreadMill");
		CardioExercises exercise2 = new CardioExercises("Bicycle");
		if(exercise1.validate()){
			System.out.println("TRUE");
		}
		if(exercise2.validate()){
			System.out.println("TRUE");
		}
		assertNotSame(exercise1, exercise2);
	}

}
