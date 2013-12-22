/**
 * DivideInteger.java
 * 
 * Created on Dec 21, 2013, 13:05 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Divide two integers without using multiplication, 
 * division and mod operator.
 * 
 * @author He Li
 */
public class DivideInteger {
	public int divideInteger(int dividend, int divisor) {
		int result = 0, sign = -1, dist, move, min = 0;
		int absDividend, absDivisor;
		int bitDividend, bitDivisor;
		
		if ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0)) {
			sign = 1;
		}
		
		/**
			* Handle exceptions: overflow, zero divisor
			*/
		if (dividend >= 0 && divisor == 0) {
			return Integer.MAX_VALUE;
		}
		
		if (dividend < 0 && divisor == 0) {
			return Integer.MIN_VALUE;
		}
		
		if (dividend == Integer.MIN_VALUE) {
			dividend = Integer.MAX_VALUE;
			min = 1;
		}
		
		absDividend = Math.abs(dividend);
		absDivisor = Math.abs(divisor);
		/**
			* Find result with bit operations.
			*/
		if (absDividend < absDivisor) {
			return 0;
		}
		else if (absDividend == absDivisor) {
			return sign;
		}
		else {
			/**
				* Calculate bits to shift. Use shift to find
				* division result.
				*/
			bitDividend = Integer.toBinaryString(absDividend).length();
			bitDivisor = Integer.toBinaryString(absDivisor).length();
			dist = ((bitDividend - bitDivisor + 2) > (31 - bitDivisor))? (31 - bitDivisor) : (bitDividend - bitDivisor + 2);
			while(dist >= 0) {
				move = absDivisor << dist;
				if ((move <= absDividend) && (move > 0)) {
					result += (1 << dist);
					absDividend -= move;
				}
				dist--;
			}
			if (((absDivisor & (absDivisor - 1)) == 0) && (min == 1)) {
				result += 1;
			}
		}
		
		return result * sign;
	}
}