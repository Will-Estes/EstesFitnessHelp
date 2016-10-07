package com.estesfitnesshelp.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserProfileTest {

	@Test
	public void test() {
		UserProfile user1 = new UserProfile("JohnDoe513", "JohnDoe513", 28, "johndoe513@gmail.com", 
				72, 205);
		UserProfile user2 = new UserProfile("JohnDoe513", "JohnDoe513", 28, "johndoe513@gmail.com",
				72, 205);
		if(user1.validate()){
			System.out.println("TRUE");
		};
		if(user2.validate()){
			System.out.println("TRUE");
		};
		assertNotSame(user1, user2); //two objects should not be the same
	}
}
