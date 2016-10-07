package com.estesfitnesshelp.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeightExercisesTest {

	@Test
	public void test() {
		WeightExercises exercise1 = new WeightExercises("Bench Press", "Chest", "Compound");
		WeightExercises exercise2 = new WeightExercises("Deadlift", "Back", "Compound");
		if(exercise1.validate()){
			System.out.println("TRUE");
		}
		if(exercise2.validate()){
			System.out.println("TRUE");
		}
		assertNotSame(exercise1, exercise2);
	}
}
