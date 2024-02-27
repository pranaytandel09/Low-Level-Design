package com.masai.run;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.masai.checks.BordValidatorImpl;
import com.masai.model.Bord;
import com.masai.model.Player;
import com.masai.service.TickTackToeService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter bord size");
		int bordsize= sc.nextInt();
		
		System.out.println("enter space separated player1 name and symbol");
		String playerName1= sc.next();
		String playerSymbol1= sc.next();
		
		System.out.println("enter space separated player2 name and symbol");
		
		String playerName2= sc.next();
		String playerSymbol2= sc.next();
		
		Player player1 = new Player(1, playerName1, playerSymbol1);
		Player player2 = new Player(2, playerName2, playerSymbol2);
		
		List<Player>playerList= Arrays.asList(player1,player2);
		
		Bord bordInstance = Bord.getInstance(bordsize);
		
		TickTackToeService tickTackToeService = new TickTackToeService(new BordValidatorImpl(bordInstance), playerList);
		String result=tickTackToeService.startGame(bordInstance);
		
		if(result==null)System.out.println("exit");
		else System.out.println(result);
		
		
		
	}
}
