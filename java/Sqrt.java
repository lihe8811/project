/**
 * Sqrt.java
 * 
 * Created on Dec 18, 2013, 20:02 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * @author He Li
 */
public class Sqrt {
	public int sqrt(int input) {
		int output = 0, lowerBound = 0, upperBound = input;
		int lowerSquare, upperSquare;
		
		if (input >= Integer.MAX_VALUE | input < 0) {
			/**
				* Handle int overflow problem.
				*/
			output = -1;
		}
		else {
			/**
				* Use binary search to find square root.
				* Initialize pivot and handle overflow 
				* problem.
				*/
			output = (lowerBound + upperBound) / 2;
			while ((output + 1) * (output + 1) > Integer.MAX_VALUE) {
				output /= 2;
			}
			lowerSquare = output * output;
			upperSquare = (output + 1) * (output + 1);
			while (lowerSquare >= input | upperSquare <= input) {
				if (lowerSquare > input) {
					upperBound = output;
					output = (lowerBound + upperBound) / 2;
					lowerSquare = output * output;
					upperSquare = (output + 1) * (output + 1);
				}
				else if (upperSquare < input) {
					lowerBound = output;
					output = (lowerBound + upperBound) / 2;
					lowerSquare = output * output;
					upperSquare = (output + 1) * (output + 1);
				}
				else if (lowerSquare == input) {
					break;
				}
				else if (upperSquare == input) {
					output++;
					break;
				}
			}
		}
		
		return output;
	}
}