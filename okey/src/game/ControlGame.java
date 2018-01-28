package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class ControlGame {

	public static void createAndMixGameStones() {
		ArrayList<Stone> stoneList = new ArrayList<>();

		for(int i= 1; i < 14; i++) {
			stoneList.add(new Stone(i,Stone.COLOR.YELLOW));
			stoneList.add(new Stone(i,Stone.COLOR.YELLOW));

			stoneList.add(new Stone(i,Stone.COLOR.BLUE));
			stoneList.add(new Stone(i,Stone.COLOR.BLUE));

			stoneList.add(new Stone(i,Stone.COLOR.BLACK));
			stoneList.add(new Stone(i,Stone.COLOR.BLACK));

			stoneList.add(new Stone(i,Stone.COLOR.RED));
			stoneList.add(new Stone(i,Stone.COLOR.RED));

		}

		stoneList.add(new Stone());
		stoneList.add(new Stone());


		Collections.shuffle(stoneList);
		OkeyOyunu.gameStones  = stoneList;

		for(int i = 0;i < stoneList.size();i++) {
			System.out.println("Tas Listesi :  " +stoneList.get(i).getName() + " number");
		}

	}

	public static void makeNewBoards() {

		findJoker(); 
		
		Random random = new Random();
		int randomStartGamerIndex= random.nextInt(3);
		Gamer gamer;
		ArrayList<Stone> stonelist;
		for(int i = 0; i< OkeyOyunu.gamerList.size() ;i++) {
			gamer = OkeyOyunu.gamerList.get(i);
			gamer.getBoard().setBoardNumber(i + 1);
			stonelist = new ArrayList<>();
			for(int j = 0 ; j < 14 ;j++) {

				stonelist.add(OkeyOyunu.gameStones.get(j));
				OkeyOyunu.gameStones.remove(j);
			}
			gamer.getBoard().setStonelist(stonelist);
		}
		OkeyOyunu.gamerList.get(randomStartGamerIndex).getBoard().getStonelist().add(OkeyOyunu.gameStones.get(0));

	}

	public static void calculateBoardWinPossibility() {
		Board board;
		ArrayList<Stone> stoneList;
		int possibilityPercent;
		for(int i = 0;i < OkeyOyunu.gamerList.size();i++) {
			board = OkeyOyunu.gamerList.get(i).getBoard();
			stoneList = board.getStonelist();
			possibilityPercent = 0;
			for(Stone stone: stoneList) {
				
				if(stone.isIsJoker())
					possibilityPercent++;
				
			}
			board.setIsWinPossibility(possibilityPercent * 50);
		}

	}

	public static void findWinner() {
		for(int i = 0;i < OkeyOyunu.gamerList.size();i++) {
			if(OkeyOyunu.gamerList.get(i).getBoard().getIsWinPossibility() == 100) {
				System.out.println(OkeyOyunu.gamerList.get(i).getName() + " kazandi -> Cift Okey");
				return;
			}
			
		}
		
		for(int i = 0;i < OkeyOyunu.gamerList.size();i++) {
		 if(OkeyOyunu.gamerList.get(i).getBoard().getIsWinPossibility() == 50) {
				System.out.println(OkeyOyunu.gamerList.get(i).getName() + " kazandi -> Tek Okey");
				return;
			}
			
		}
		for(int i = 0;i < OkeyOyunu.gamerList.size();i++) {
			if(OkeyOyunu.gamerList.get(i).getBoard().getStonelist().size() == 15) {
				System.out.println(OkeyOyunu.gamerList.get(i).getName() + " kazandi -> Fazla Tasla");
				return;
			}
			
		}
		
	}
	
	public static void findJoker() {
		Random random = new Random();
		int jokerHelperIndex = random.nextInt(OkeyOyunu.gameStones.size());
		
		while(OkeyOyunu.gameStones.get(jokerHelperIndex).getNumber() == 0 ) {
			jokerHelperIndex = random.nextInt(OkeyOyunu.gameStones.size());
		}
		
		Stone jokerHelperStone = OkeyOyunu.gameStones.get(jokerHelperIndex);
		setJokerForAllStones(jokerHelperStone);
	}

	private static void setJokerForAllStones(Stone jokerHelperStone) {
	
		 int  jokerNumber;
			
		 if(jokerHelperStone.getNumber() == 13) {
			 jokerNumber =  1;
		 }else {
			 jokerNumber =  jokerHelperStone.getNumber() + 1;
		 }
		 
		for(int j = 0 ; j < OkeyOyunu.gameStones.size();j++) {				
			 
			if(OkeyOyunu.gameStones.get(j).getNumber() == jokerNumber && OkeyOyunu.gameStones.get(j).getColor().equals(jokerHelperStone.getColor())) 
			{
				OkeyOyunu.gameStones.get(j).setIsJoker(true);
			}
		}
	
	}

}
