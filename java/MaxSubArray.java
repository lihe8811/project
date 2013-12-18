/**
 * MaxSubArray.java
 * 
 * Created on Dec 17, 2013, 18:59 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the
 * largest sum.For example, given the array [−2,1,−3,4,−1,2,1,−5,4]
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * @author He Li
 */
public class MaxSubArray {
	public int maxSubArray(int[] array) {
		int maxSubArraySum, maxElement, subArraySum;
		
		/**
			* Find maximum element of input array, maximum sum of
			* subarray should be greater than maximum element.  
			*/
		maxElement = array[0];
		for (int it = 1; it < array.length; it++) {
			if (array[it] > maxElement) {
				maxElement = array[it];
			}
		}
		
		/**
			* Initialize maxSubArraySum as maxElement
			* Find subarray that remains positive since sum up from 
			* first sub element. When sum of subarray is greater than
			* maxSubArraySum, update maxSubArraySum.
			*/
		maxSubArraySum = maxElement;
		subArraySum = 0;
		if (maxElement >= 0) {
			for (int it = 0; it < array.length; it++) {
				if (subArraySum + array[it] >= 0) {
					subArraySum = subArraySum + array[it];
				}
				else {
					subArraySum = 0;
				}
				
				/**
					* Check and update maxSubArraySum
					*/
				if (subArraySum > maxSubArraySum) {
					maxSubArraySum = subArraySum;
				}
			}
		}
			
		return maxSubArraySum;
	}
}