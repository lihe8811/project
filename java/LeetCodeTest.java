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

public class LeetCodeTest {	
	public static void main(String[] args) {
		int[] input = {2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 7, 7, 7};
		SingleNumberTwo solution = new SingleNumberTwo();
		
		System.out.printf("%d\n", solution.singleNumberTwo(input));
	}
}