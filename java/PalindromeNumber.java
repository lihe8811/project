/**
 * PalindromeNumber.java
 * 
 * Created on Dec 18, 2013, 15:53 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Determine whether an integer is a 
 * palindrome. Do this without extra space.
 *
 * Requirement:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to
 * string, note the restriction of using extra space.
 * You could also try reversing an integer. However, 
 * if you have solved the problem "Reverse Integer", 
 * you know that the reversed integer might overflow. 
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 * 
 * @author He Li
 */
public class PalindromeNumber {
	public boolean palindromeNumber(int input) {
		boolean isPalindrome = true;
		
		/**
			* Handle integer overflow problem.
			*/
		if (input >= Integer.MAX_VALUE || input <= Integer.MIN_VALUE) {
			isPalindrome = false;
		}
		
		/**
			* For negative integer, it is palindrome when its
			* absolute value is palindrome.
			*/
		int abs = Math.abs(input);
		int digit = (int) Math.log10(abs) + 1;
		int firstDigit, lastDigit;
		
		for (int it = 0; it < digit/2; it++) {
			/**
				* Check if every pair of digits are same
				*/
			firstDigit = ((abs - abs % (int) Math.pow(10, digit - 1 - it)) / (int) Math.pow(10, digit - 1 - it)) % 10;
			lastDigit = ((abs - abs % (int) Math.pow(10, it)) / (int) Math.pow(10, it)) % 10;
			
			if (firstDigit != lastDigit) {
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
}