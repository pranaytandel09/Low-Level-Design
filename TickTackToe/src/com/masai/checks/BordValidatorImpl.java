package com.masai.checks;

import java.util.HashMap;
import java.util.Map;

import com.masai.model.Bord;

public class BordValidatorImpl implements BordValidator {
	
	private Bord bord;
	private Map<Integer,Boolean>playerTurns;
	private String[][] gameBord;
	
	public BordValidatorImpl(Bord bord) {
		this.bord=bord;
		this.gameBord=bord.getBord();
		playerTurns= new HashMap<>();
		
	}
	
	@Override
	public boolean isCellEmpty(int x, int y) {
		// TODO Auto-generated method stub
		
		return gameBord[x][y].equals("-");
				
	}

	@Override
	public boolean checkCordinates(int x, int y) {
		// TODO Auto-generated method stub
		return x<gameBord.length && y<gameBord[0].length && x>=0 && y>=0;
	}

	@Override
	public boolean checkValidTurns(int id) {
		// TODO Auto-generated method stub
		return playerTurns.containsKey(id)?!playerTurns.get(id):true;
	}

	@Override
	public boolean gameOverOrNot(int cellCounter) {
		// TODO Auto-generated method stub
		
		return cellCounter==bord.getBord().length;
	}

	@Override
	public void changePlayerTurnsStatus(int id) {
		// TODO Auto-generated method stub
		if(playerTurns.containsKey(id)) playerTurns.put(id, !playerTurns.get(id));
		else playerTurns.put(id, false);
	}
	
	

}
