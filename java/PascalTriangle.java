/**
 * PascalTriangle.java
 * 
 * Created on Dec 29, 2013, 22:10 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Given numRows, generate the first 
 * numRows of Pascal's triangle.
 * 
 * @author He Li
 */

import java.util.Arrays;
import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> pascalTriangle(int row) {
		/**
			* Each row of Pascal's Triangle can be generated 
			* recurrsively from the row above it. The method 
			* generates each row by recurrsion.
			*/
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int num = row * (row + 1) / 2, index, preidx, postidx, start;
		int array[] = new int[num];
		
		/** 
			* Generate entire Pascal's Triangle with array.
			* Handle zero row condition.
			*/
		if (row == 0) {
			return result;
		}
		
		array[0] = 1;
		if (num > 1) {
			for (int it = 1; it < row; it++) {
				for (int jt = 0; jt < it + 1; jt++) {
					index = it * (it + 1) / 2 + jt;
					if (jt == 0 || jt == it) {
						array[index] = 1;
					}
					else {
						/**s
							* Calculate element based on elements on 
							* previous row.
							*/
						preidx = (it - 1) * it / 2 + jt - 1;
						postidx = (it - 1) * it / 2 + jt;
						array[index] = array[preidx] + array[postidx];
					}
				}
			}
		}
		
		/**
			* Split array into result.
			*/
		for (int it = 0; it < row; it++) {
			ArrayList<Integer> element = new ArrayList<Integer>();
			start =  it * (it + 1) / 2;
			for (int jt = 0; jt < it + 1; jt++) {
				element.add(array[start + jt]);
			}	
			result.add(element);
		}
		
		for (int it = 0; it < result.size(); it++) {
			for (int jt = 0; jt < result.get(it).size(); jt++) {
				System.out.printf("%d\n", result.get(it).get(jt));
			}
			System.out.printf("\n");
		}
		
		return result;
	}
}