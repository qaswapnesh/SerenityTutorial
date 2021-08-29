package com.studentapp.utils;

import java.util.Random;

public class TestUtils {
	
	// Method will generate a random integer
	public static String randomValue() {
		Random random = new Random();
		int randomInt = random.nextInt(1000000);
		return Integer.toString(randomInt);
		
	}

}
