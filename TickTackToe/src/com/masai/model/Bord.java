package com.masai.model;

public class Bord {

	public static Bord gameBord;
	private String[][] bord;
	
	private Bord(int size) {
		this.bord= new String[size][size];
		createBord();
	}
	
	private void createBord() {
		for(int i=0; i<bord.length; i++) {
			for(int j=0; j<bord[0].length; j++) {
				bord[i][j]="-";
			}
		}
	}
	
	public static Bord getInstance(int N) {
		
		if(gameBord==null)gameBord=new Bord(N);
		return gameBord;
	}

	public String[][] getBord() {
		return bord;
	}

	public void setBord(String[][] bord) {
		this.bord = bord;
	}
	
	public void fillPosition(int x,int y,String symbol) {
		bord[x][y]=symbol;
	}
	
	public String getPositionValue(int x,int y) {
		return bord[x][y];
	}
	
	public void printBord() {
		
		for(String[] str: bord) {
			for(String s: str) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}
	
}
