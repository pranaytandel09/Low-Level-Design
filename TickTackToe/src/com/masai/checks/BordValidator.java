package com.masai.checks;

public interface BordValidator {

	public boolean isCellEmpty(int x,int y);
	public boolean checkCordinates(int x,int y);
	public boolean checkValidTurns(int id);
	public boolean gameOverOrNot(int cellCounter);
	public void changePlayerTurnsStatus(int id);
}
