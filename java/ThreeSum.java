/**
 * ThreeSum.java
 * 
 * Created on Dec 23, 2013, 23:32 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Given an array S of n integers, are 
 * there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets 
 * in the array which gives the sum of zero.
 *
 * Requirement:
 * Elements in a triplet (a,b,c) must be in
 * non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate
 * triplets.
 * 
 * @author He Li
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] array) {
		/**
			* Iterate input array, build hashmap to search
			* target number.
			*/
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		HashSet<ArrayList<Integer>> dedup = new HashSet<ArrayList<Integer>>();
		int expect, key, min, max, mid;
		
		/**
			* Handling invalid input array with
			* element number < 3.
			*/
		if (array.length >= 3) {
			/**
				* Build hashmap.
				*/
			for (int it = 0; it < array.length; it++) {
				hash.put(array[it], it);
			}
			
			/**
				* Search for triplets with sum 0.
				*/
			for (int it = 0; it < (array.length - 2); it++) {
				for (int jt = it + 1; jt < (array.length - 1); jt++) {
					expect = - (array[it] + array[jt]);
					/**
						* Search target value to sum 0, use additional
						* hashset dedup to avoid duplicate triplets.
						*/
					if (hash.containsKey(expect) == true) {
						key = hash.get(expect);
						if (key != it && key != jt) {
							/**
								* Order three elements and check duplicate.
								*/
							min = Math.min(Math.min(array[it], array[jt]), expect);
							max = Math.max(Math.max(array[it], array[jt]), expect);
							mid = - (min + max);
						
							ArrayList<Integer> element = new ArrayList<Integer>();
							element.addAll(Arrays.asList(min, mid, max));
							if (dedup.contains(element) == false) {
								dedup.add(element);
								result.add(element);
							}	
						}
					}
				}
			}
		}
		
		return result;
	}
}