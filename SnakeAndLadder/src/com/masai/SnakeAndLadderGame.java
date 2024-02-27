package com.masai;

import java.util.Scanner;

import com.masai.Entity.Dao;
import com.masai.Entity.Dice;
import com.masai.Service.StartGame;

public class SnakeAndLadderGame {

	public static void main(String[] args) {
		Dao dao = Dao.newInstance();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter information");
		
		int noOfSnakes=sc.nextInt();
		
		while(noOfSnakes>0) {
			int startPosition=sc.nextInt();
			int endPosition=sc.nextInt();
			
			dao.setSnakePositions(startPosition, endPosition);
			noOfSnakes--;
		}
		
		int noOfLadders=sc.nextInt();
		
		while(noOfLadders>0) {
			int startPosition=sc.nextInt();
			int endPosition=sc.nextInt();
			
			dao.setLadderPositions(startPosition, endPosition);
			noOfLadders--;
		}
		
		int noOfPlayers=sc.nextInt();
		int id=1;
		sc.nextLine();
		while(noOfPlayers>0) {
			String name=sc.nextLine();
			
			dao.setPlayers(id++, name);
			noOfPlayers--;
			System.out.println("player id: "+id);
		}
		System.out.println(noOfSnakes);
		System.out.println(noOfLadders);
		System.out.println(noOfPlayers);
		System.out.println(dao);
		
		StartGame game = new StartGame(Dice.getInstance(6));
		System.out.println(game.start()+" wins the game");
		
		
	}
}
