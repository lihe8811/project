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
import java.util.Random;

/**
 * This class is designed for learning java.
 * @author He Li
 */
public class WelcomeTest {	
	public static void main(String[] args) {
		final int BIAS = 1, SEED = 2000;
		int face;
		
		Welcome name = new Welcome("lihe8811");
		Random randomNumber = new Random();
		
		System.out.printf("Solution completed by %s.\n", name.getUserName());
		for (int it = 0; it < 10; it++){
			face = randomNumber.nextInt(6) + BIAS;
			System.out.printf("Face of the dice is %d.\n", face);
		}
	}
}