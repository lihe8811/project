/**
 * LeetCodeTest.java
 * 
 * Created on Dec 17, 2013, 15:00 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Test code submissions to Leet Code
 * Online Judge.
 *
 * @author He Li
 */

import java.util.Arrays;

public class LeetCodeTest {	
	public static void main(String[] args) {
		int[] input = {72, 198, 1000, 250};
		Sqrt solution = new Sqrt();
		
		for (int it = 0; it < input.length; it++) {
			System.out.printf("The square root of %d is: %d\n", input[it], solution.sqrt(input[it]));		
		}
	}
}