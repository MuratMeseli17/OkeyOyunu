package game;

import java.util.ArrayList;

public class OkeyOyunu {
	static ArrayList<Gamer> gamerList = new ArrayList<>();
    static ArrayList<Stone> gameStones = new ArrayList();
	
	public static void main(String[] args) {
		gamerList.add(new Gamer("oyuncu 1")); 
		gamerList.add(new Gamer("oyuncu 2")); 
		gamerList.add(new Gamer("oyuncu 3")); 
		gamerList.add(new Gamer("oyuncu 4")); 
	
		
		
		startGame();
		
	}

	private static void startGame() {
		ControlGame.createAndMixGameStones();
		ControlGame.makeNewBoards();
		ControlGame.calculateBoardWinPossibility();
		ControlGame.findWinner();
		
	}
}
