/**
 * welcome.java
 * 
 * Created on Nov 7, 2013, 12:00 PM
 * 
 * Copyright (c) 2013 He Li.
 *
 * Java program for learning
 */


import java.util.Scanner;

/**
 * This class is designed for learning java.
 * @author He Li
 */
public class welcome {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int number1, number2;
		System.out.printf("Enter first integer:\n");
		number1 = input.nextInt();
		
		System.out.printf("Enter second integer:\n");
		number2 = input.nextInt();
		
		System.out.printf("Sum of two integer is %d.\n", (number1 + number2));
	}
}
