package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.checks.BordValidator;
import com.masai.model.Bord;
import com.masai.model.Player;

public class TickTackToeService {

	private BordValidator bordValidator;
	private List<Player>playerList;
	private Bord bord;
	private int cellConter=0;
	private boolean movechecker=true;
	
	public TickTackToeService(BordValidator bordValidator,List<Player>playerList){
		
		this.bordValidator=bordValidator;
		this.playerList=playerList;
	}

	public String startGame(Bord bord) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		bord.printBord();
		
		int id=0;
		int choice=0;
		do {
			System.out.println("choose option: 1->play game  2->exit");
			choice=sc.nextInt();
			
			if(movechecker)id++;
			if(id>playerList.size())id=1;
			switch(choice) {
			case 1:
				//System.out.println("inside case 1");
				if(playingGame(sc,id,bord)) {
					return playerList.get(id-1).getName()+" wins the game";
				}
				break;
			case 2:
				return null;
			}
			
		}while(!bordValidator.gameOverOrNot(cellConter));
		
		return "Game Over";
	}

	private boolean playingGame(Scanner sc,Integer id,Bord bord) {
		// TODO Auto-generated method stub
		
		System.out.println("enter space separated position of cell");
		
		int x= sc.nextInt();
		int y=sc.nextInt();
		
		if(bordValidator.checkCordinates(x, y) && bordValidator.isCellEmpty(x, y)) {
			movechecker=true;
			//bordValidator.changePlayerTurnsStatus(id);
			bord.fillPosition(x, y, playerList.get(id-1).getSymbol());
			bord.printBord();
			return someOneWinsOrNot(x,y,id,bord);
		}else {
			movechecker=false;
			System.out.println("Invalid Move");
		}
		
		return false;

	}

	private boolean someOneWinsOrNot(int x, int y, Integer id,Bord bord) {
		// TODO Auto-generated method stub
		String[][] mat = bord.getBord();
		int m=mat.length, n=mat[0].length;
		
		boolean clmCheck=true, rowCheck=true, leftDiagonal=true, rightDiagonal=true;
		
		for(int i=0; i<m; i++) {
			if(!mat[i][y].equals(playerList.get(id-1).getSymbol()))clmCheck=false;
		}
		
		for(int i=0; i<n; i++) {
			if(!mat[x][i].equals(playerList.get(id-1).getSymbol()))rowCheck=false;
		}
		
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i==j && !mat[i][j].equals(playerList.get(id-1).getSymbol())) {
					leftDiagonal=false;
				}
				if(i+j==m-1 && mat[i][j].equals(playerList.get(id-1).getSymbol()))rightDiagonal=false;
			}
		}
		
		
		return clmCheck || rowCheck || leftDiagonal || rightDiagonal;
	}
	
	
	
	
	
	
	
	
}
