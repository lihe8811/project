/**
 * SingleNumber.java
 * 
 * Created on Dec 17, 2013, 15:11 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Given an array of integers, every element 
 * appears twice except for one. Find that 
 * single one.
 *
 * Requirement:
 * Your algorithm should have a linear runtime
 * complexity. Could you implement it without 
 * using extra memory?
 * 
 * @author He Li
 */
public class SingleNumber {
	public int singleNumber(int[] array) {
		int single = 0;
		
		/**
			* Eliminate paired integers by exclusive or,
			* a ^ a = 0, 0 ^ a = a
			* result will be the only single integer in array.
			*/
		for (int it = 0; it < array.length; it++) {
			single = single ^ array[it];
		}
		return single;
	}
}