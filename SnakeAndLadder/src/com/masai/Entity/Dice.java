package com.masai.Entity;

import java.security.SecureRandom;
import java.util.Random;

public class Dice {

	private int maxNumberOfDice;
	private Random random;
	
	private static Dice dice;
	
	private Dice(int maxNumberOfDice){
		System.out.println("inside Dice::");
		this.random= new Random();
		this.maxNumberOfDice=maxNumberOfDice;
	}
	
	public static Dice getInstance(int maxNumberOfDice) {
		if(dice==null)dice= new Dice(maxNumberOfDice);
		
		return dice;
	}
	
	public int getDiceNumber() {
		return random.nextInt(maxNumberOfDice)+1;
	}
	
	
}
