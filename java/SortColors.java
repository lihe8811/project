/**
 * SortColors.java
 * 
 * Created on Dec 29, 2013, 18:04 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Given an array with n objects colored red, 
 * white or blue, sort them so that objects of 
 * the same color are adjacent, with the colors 
 * in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to
 * represent the color red, white, and blue 
 * respectively.
 * 
 * @author He Li
 */
public class SortColors {
	public void sortColors(int[] array) {
		int countZero = 0, countOne = 0, countTwo = 0;
		/**
			* Count numbers of each color, handle empty 
			* array exception.
			*/
		if (array.length > 0) {
			for (int it = 0; it < array.length; it++) {
				switch (array[it]) {
					case 0: countZero++;
									break;
					case 1: countOne++;
									break;
					case 2: countTwo++;
									break;
				}
			}
			
			/**
				* Assign 0, 1, 2 values to array element, 
				* implement sorting colors.
				*/
			for (int it = 0; it < countZero; it++) {
				array[it] = 0;
			}
			for (int it = countZero; it < countZero + countOne; it++) {
				array[it] = 1;
			}
			for (int it = countZero + countOne; it < array.length; it++) {
				array[it] = 2;
			}
		}
		
		for (int it = 0; it < array.length - 1; it++) {
			System.out.printf("%d,", array[it]);
		}
		System.out.printf("%d\n", array[array.length - 1]);
	}
}