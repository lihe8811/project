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

import java.util.ArrayList;

public class LeetCodeTest {	
	public static void main(String[] args) {
		int[] array = {1,2,-2,-1};
		ThreeSum solution = new ThreeSum();
		ArrayList<ArrayList<Integer>> result = solution.threeSum(array);
		
		for (int it = 0; it < result.size(); it++) {
			System.out.printf("(%d, %d, %d)\n", result.get(it).get(0), result.get(it).get(1), result.get(it).get(2));
		}
	}
}