/**
 * ReverseInteger.java
 * 
 * Created on Dec 18, 2013, 9:31 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Requirement:
 * If the integer's last digit is 0, what should the
 * output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? 
 * Assume the input is a 32-bit integer, then the reverse 
 * of 1000000003 overflows. How should you handle such cases?
 * 
 * @author He Li
 */
public class ReverseInteger {
	public int reverseInteger(int input) {
		int abs = Math.abs(input);
		int digit = (int) Math.log10(abs) + 1;
		int reverse = 0, residue;
		
		/**
			* Split each digit from end of integer, and reverse.
			*/
		for (int it = 0; it < digit; it++) {
			residue = abs % 10;
			abs = abs / 10;
			reverse += residue * Math.pow(10, digit - 1 - it);
		}
		
		/**
			* Handle negative input. When reversed integer overflows, 
			* Integer.MAX_VALUE will be returned.
			*/
		if (input < 0) {
			reverse = -reverse;
		}
		
		return reverse;
	}
}