/**
 * LongestSubstringWithoutRepeatingChar.java
 * 
 * Created on Dec 19, 2013, 10:17 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Given a string, find the length of the longest 
 * substring without repeating characters. For 
 * example, the longest substring without repeating 
 * letters for "abcabcbb" is "abc", which the length 
 * is 3. For "bbbbb" the longest substring is "b", 
 * with the length of 1.
 * 
 * @author He Li
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
	public int lengthOfLongestSubstring(String input) {
		/**
			* Iterate from first char of string. Build hashmap
			* to check if there is repeating char. Maintain 
			* the value of longest non-repeating substring during
			* iteration.
			*/
		int longestSubstring = 0, currentSubstring = 0, start = 0, value;
		String character;
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		
		/**
			* Handle empty string exception.
			*/
		if (input.length() == 0) {
			return 0;
		}
		
		for (int it = 0; it < input.length(); it++) {
			character = input.substring(it, it+1);
			/**
				* If the character is new to current substring, continue
				* and update substring length.
				*/
			if (hash.containsKey(character) == false) {
				hash.put(character, it);
				currentSubstring += 1;
				if (currentSubstring > longestSubstring) {
					longestSubstring = currentSubstring;
				}
			}
			/**
				* Find repeating character, start new substring from last 
				* occurrence, track length of new substring under tracking.
				*/
			else {
				value = hash.get(character);
				for (int iter = start; iter <= value; iter++) {
					hash.values().remove(iter);
				}
				hash.put(character, it);
				start = value + 1;
				currentSubstring = it - value;
			}
		}
		
		return longestSubstring;
	}
}