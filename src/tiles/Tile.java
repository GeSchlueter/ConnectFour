package tiles;

import static tiles.ConsoleColoursUtil.BACKGROUND_RESET;
import static tiles.ConsoleColoursUtil.BACKGROUND_YELLOW;

public enum Tile {
	
	EMPTY(" "), 
	PLAYER1("○"), 
	PLAYER2("●"),
	BORDER(" | "),
	PLAYER1_HIGHLIGHTED(BACKGROUND_YELLOW + "○" + BACKGROUND_RESET),
	PLAYER2_HIGHLIGHTED(BACKGROUND_YELLOW + "●" + BACKGROUND_RESET);
	
	private String symbol;

	
	private Tile(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
	
	
}
