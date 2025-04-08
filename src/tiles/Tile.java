package tiles;

import static tiles.ConsoleColoursUtil.BACKGROUND_RESET;
import static tiles.ConsoleColoursUtil.BACKGROUND_YELLOW;

public enum Tile {
	
	EMPTY(" "), 
	PLAYER1("x"), 	//○
	PLAYER2("o"),	//●
	BORDER(" | "),
	PLAYER1_HIGHLIGHTED(BACKGROUND_YELLOW + "x" + BACKGROUND_RESET),
	PLAYER2_HIGHLIGHTED(BACKGROUND_YELLOW + "o" + BACKGROUND_RESET);
		
	private String symbol;

	
	private Tile(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
	
	
}
