package game;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<Stone> stonelist;
	private int boardNumber;
	private int isWinPossibility;
	
	 
	public Board() {
		super();
		this.stonelist = new ArrayList<>();
		this.boardNumber = 0;
		this.isWinPossibility = 0;
		
	}
	
	public ArrayList<Stone> getStonelist() {
		return stonelist;
	}
	public void setStonelist(ArrayList<Stone> stonelist) {
		this.stonelist = stonelist;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public int getIsWinPossibility() {
		return isWinPossibility;
	}
	public void setIsWinPossibility(int isWinPossibility) {
		this.isWinPossibility = isWinPossibility;
	}

}
