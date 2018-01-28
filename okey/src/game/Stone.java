package game;

public class Stone {

	
	private String name;
	private int number;
	private COLOR color;
	private boolean isFakeJoker;
	private boolean isJoker;
	
	enum COLOR {
		YELLOW,
		BLUE,
		BLACK,
		RED
	}
	
	public Stone() {
		super();
		this.isJoker = false;
		this.isFakeJoker = true;
	}
	
	public Stone(int number, Stone.COLOR color) {
		super();
		this.number = number;
		this.color = color;
		this.isJoker = false;
		this.isFakeJoker = false;
		switch(color) {
		case YELLOW:
			this.setName("Sari - "+ number);
			break;
		case BLUE:
			this.setName("Mavi - "+ number);
			break;
		case RED:
			this.setName("Kırmızı - "+ number);
			break;
		case BLACK:
			this.setName("Siyah - "+ number);
			break;
			
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isJoker() {
		return isJoker;
	}

	public void setJoker(boolean isJoker) {
		this.isJoker = isJoker;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public COLOR getColor() {
		return color;
	}

	public void setColor(COLOR color) {
		this.color = color;
	}

	public boolean isFakeJoker() {
		return isFakeJoker;
	}
	public void setFakeJoker(boolean isFakeJoker) {
		this.isFakeJoker = isFakeJoker;
	}
	public boolean isIsJoker() {
		return isJoker;
	}
	public void setIsJoker(boolean isJoker) {
		this.isJoker = isJoker;
	}
	
	
	
	
	
}
