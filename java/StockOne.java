/**
 * StockOne.java
 * 
 * Created on Jan 15, 2013, 13:05 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Description:
 * Say you have an array for which the
 * ith element is the price of a given 
 * stock on day i.
 * If you were only permitted to complete
 * at most one transaction (ie, buy one and
 * sell one share of the stock), design an
 * algorithm to find the maximum profit.
 * 
 * @author He Li
 */

public class StockOne {
	public int stockOne(int[] input) {
		int buy, profit, now, length;
		
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
		for (int it = 1; it < length; it++) {
			now = input[it];
			if ((now - buy) > profit) {
				profit = now - buy;
			}
			if (now < buy) {
				buy = now;
			}
		}
		
		return profit;
	}
}