package com.estesfitnesshelp.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.estesfitnesshelp.model.services.cardioexerciseservice.CardioExerciseImplTest;
import com.estesfitnesshelp.model.services.cardiologservice.CardioLogImplTest;
import com.estesfitnesshelp.model.services.factory.ServiceFactoryTest;
import com.estesfitnesshelp.model.services.userprofileservice.UserProfileImplTest;
import com.estesfitnesshelp.model.services.weightexerciseservice.WeightExerciseImplTest;
import com.estesfitnesshelp.model.services.weightlogservice.WeightLogImplTest;

@RunWith(Suite.class)
@SuiteClasses({ServiceFactoryTest.class, CardioExerciseImplTest.class, CardioLogImplTest.class, UserProfileImplTest.class,
	WeightExerciseImplTest.class, WeightLogImplTest.class})
public class AllTests {

}
