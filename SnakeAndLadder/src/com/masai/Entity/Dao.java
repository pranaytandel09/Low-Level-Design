package com.masai.Entity;

import java.util.HashMap;
import java.util.Map;

public class Dao {

	private Map<Integer,Integer>snakePositions;
	private Map<Integer,Integer>ladderPositions;
	private Map<Integer,String>players;
	
	private static Dao dao;
	
	private Dao() {
		this.snakePositions= new HashMap<>();
		this.ladderPositions= new HashMap<>();
		this.players= new HashMap<>();
	}
	
	public static Dao newInstance() {
		if(dao==null)dao=new Dao();
		
		return dao;
	}

	public Map<Integer, Integer> getSnakePositions() {
		return snakePositions;
	}

	public void setSnakePositions(Integer startPosition, Integer endPosition) {
		this.snakePositions.put(startPosition, endPosition);
	}

	public Map<Integer, Integer> getLadderPositions() {
		return ladderPositions;
	}

	public void setLadderPositions(Integer startPosition, Integer endPosition) {
		this.ladderPositions.put(startPosition, endPosition);
	}

	public Map<Integer, String> getPlayers() {
		return players;
	}

	public void setPlayers(Integer id, String name) {
		this.players.put(id, name);
	}
	
	
	
}
