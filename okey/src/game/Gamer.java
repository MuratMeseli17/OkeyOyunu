package game;

public class Gamer  {
//Her oyuncu bir isime ve bir tahtaya sahiptir
	private String name;
	private Board board;
	
	public Gamer(String name) {
		super();
		this.name = name;
		this.board = new Board();
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
