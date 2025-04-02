package tiles;

import static tiles.ConsoleColours.BACKGROUND_YELLOW;
import static tiles.ConsoleColours.BACKGROUND_RESET;

public enum Tiles {
	
	EMPTY(" "), 
	PLAYER1("○"), 
	PLAYER2("●"),
	BORDER(" | "),
	PLAYER1_HIGHLIGHTED(BACKGROUND_YELLOW + "○" + BACKGROUND_RESET),
	PLAYER2_HIGHLIGHTED(BACKGROUND_YELLOW + "●" + BACKGROUND_RESET);
	
	private String symbol;

	
	private Tiles(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
	
	
}
