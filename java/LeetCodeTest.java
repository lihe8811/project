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
		int[] array = {2, 5, 6, 9, 8, 7, 5, 8, 2, 6, 9};
		SingleNumber solution = new SingleNumber();
		
		System.out.printf("The input array is:\n");
		System.out.println(Arrays.toString(array));
		
		System.out.printf("The only single integer is %d.\n", solution.singleNumber(array));
	}
}