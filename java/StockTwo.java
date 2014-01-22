/**
 * DivideInteger.java
 * 
 * Created on Dec 21, 2013, 13:05 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Say you have an array for which the 
 * ith element is the price of a given 
 * stock on day i. Design an algorithm 
 * to find the maximum profit. You may 
 * complete as many transactions as you 
 * like (ie, buy one and sell one share 
 * of the stock multiple times). However, 
 * you may not engage in multiple trans-
 * actions at the same time (ie, you must 
 * sell the stock before you buy again).
 * 
 * @author He Li
 */

public class StockTwo {
	public int stockTwo(int[] input) {
		int buy, profit, stage, length;
		
		/**
			* Handle exceptions based on input
			* length
			*/
		length = input.length;
		if (length < 2) {
			return 0;
		}
		
		/**
			* Update buy-in price and profit.
			*/
		buy = input[0];
		profit = 0;
		stage = 0;
		for (int it = 1; it < length; it++) {
			if ((input[it] - buy) > stage) {
				profit += input[it] - buy - stage;
				stage = input[it] - buy;
			}
			else {
				buy = input[it];
				stage = 0;
			}
		}
		
		return profit;
	}
}