/**
 * PascalTriangle2.java
 * 
 * Created on Dec 30, 2013, 22:38 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Given an index k, return the kth 
 * row of the Pascal's triangle. For 
 * example, given k = 3, Return 
 * [1,3,3,1].
 * 
 * @author He Li
 */

import java.util.Arrays;
import java.util.ArrayList;

public class PascalTriangle2 {
	public ArrayList<Integer> pascalTriangle2(int row) {
		/**
			* Each row of Pascal's Triangle can be generated 
			* recurrsively from the row above it. The method 
			* generates each row by recurrsion.
			*/
		ArrayList<Integer> result = new ArrayList<Integer>();
		int length, element;
		
		/**
			* Handle initial condition.
			*/
		result.add(1);
		if (row == 0) {
			return result;
		}
		
		result.add(1);
		if (row == 1) {
			return result;
		}
		else if (row > 1) {
			for (int it = 0; it < row - 1; it++) {
				/**
					* Initialize temperory arraylist to avoid 
					* result update during recursion process.
					*/
				length = result.size();
				ArrayList<Integer> tmp = new ArrayList<Integer>(result);
				
				for (int jt = 1; jt < length; jt++) {
					element = tmp.get(jt)+ tmp.get(jt - 1);
					result.set(jt, element);
				}
				result.add(1);
			}
		}
		
		length = result.size();
		for (int it = 0; it < length; it++) {
			System.out.printf("%d ", result.get(it));
		}
		System.out.printf("\n");
		
		return result;
	}
}