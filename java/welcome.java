// Java program for learning
// Author: He LI
// Date: 2013-11-07
// Version: 1.0
import java.util.Scanner;

public class welcome{
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