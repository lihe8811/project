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

public class LeetCodeTest {	
	public static void main(String[] args) {
		String input = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		LongestSubstringWithoutRepeatingChar solution = new LongestSubstringWithoutRepeatingChar();
		
		System.out.printf("Length of longest substring without repeating character in %s is: %d\n", input, solution.lengthOfLongestSubstring(input));
	}
}