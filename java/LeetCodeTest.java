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
		int input = -2147447412;
		PalindromeNumber solution = new PalindromeNumber();
		
		System.out.printf("The input number is: %d\n", input);
		System.out.printf("The input number is palindrome? %b.\n\n", solution.palindromeNumber(input));	
	}
}