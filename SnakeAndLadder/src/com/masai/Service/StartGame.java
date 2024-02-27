package com.masai.Service;

import java.util.HashMap;
import java.util.Map;

import com.masai.Entity.Dao;
import com.masai.Entity.Dice;

public class StartGame {
	
	private Dice dice;
	private Map<Integer,Integer>LatestPosition;
	
	public StartGame(Dice dice){
		System.out.println("inside startGame::");
		this.dice=dice;
		this.LatestPosition=new HashMap<>();
	}
	
	public String start() {
		System.out.println("game started");
		
		int id=0;
		Dao dao = Dao.newInstance();
		
		//Gaurav rolled a 6 and moved from 0 to 6
		
		do {
			id++;
			if(id>dao.getPlayers().size()) id=1;
			
			int diceNumber = dice.getDiceNumber();
			int currentPosition=LatestPosition.containsKey(id)?LatestPosition.get(id):0;
			int newPosition = currentPosition+diceNumber;
			
			StringBuilder sb= new StringBuilder("");
			sb.append(dao.getPlayers().get(id)+ " rolled a "+diceNumber);
			
			if(!isNumberGreaterThan100(newPosition)) {
				
				if(dao.getSnakePositions().containsKey(newPosition)) {
					
					newPosition=dao.getSnakePositions().get(newPosition);
					LatestPosition.put(id, newPosition);
					
					sb.append(", eaten by a snake ");
				}
				
				else if(dao.getLadderPositions().containsKey(newPosition)) {
					
					newPosition=dao.getLadderPositions().get(newPosition);
					
					LatestPosition.put(id, newPosition);
					sb.append(", got the ladder ");
				}
				else LatestPosition.put(id, newPosition);
				
			}
			else {
	
				newPosition=currentPosition;
				LatestPosition.put(id, newPosition);
			}
			
			sb.append(" and moved from "+currentPosition+" to "+newPosition+"");
			
			System.out.println(sb.toString());
			
		}while(!isWinnerFound(id));
		
		
		return dao.getPlayers().get(id);
	}
	
	private boolean isWinnerFound(int id) {
//		System.out.println(id);
		return LatestPosition.get(id)==100;
	}
	
	private boolean isNumberGreaterThan100(int newPosition) {
		return newPosition>100;
	}
	
}
