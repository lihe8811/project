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
		int dividend = -1021989372, divisor = -82778243;
		DivideInteger solution = new DivideInteger();
		
		System.out.printf("%d/%d = %d ~ %d\n", dividend, divisor, solution.divideInteger(dividend, divisor),  dividend / divisor);
	}
}