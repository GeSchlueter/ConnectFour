package board;

import java.util.ArrayList;

import tiles.Tile;

public class Board {
	public static final int ROWS = 6;
	public static final int COLS = 7;

	private Tile[][] board = new Tile[ROWS][COLS];

	public Board() {
		this.init();
	}

	private void init() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				this.board[i][j] = Tile.EMPTY;

			}
		}

	}

	public void print() {
		System.out.println(" | 0 | 1 | 2 | 3 | 4 | 5 | 6 | ");
		for (int i = 0; i < board.length; i++) {
			System.out.print(Tile.BORDER.getSymbol());
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j].getSymbol() + Tile.BORDER.getSymbol());
			}
			System.out.println();
		}
	}

	public int findLowestAvailableRow(int col) {
		for (int i = board.length - 1; i >= 0; i--) {
			if (board[i][col] == Tile.EMPTY) {
				return i;
			}
		}
		return -1; // Column is full
	}

	public void setTile(int row, int col, Tile playerTile) {
		board[row][col] = playerTile;
	}

	public boolean checkWin(int lastRow, int lastCol, Tile playerTile) {
		boolean isHorizontalWin = checkHorizontal(lastRow, lastCol, playerTile);
		if(isHorizontalWin) {
			return true;
		}

		
		boolean isVerticalWin = checkVertical(lastRow, lastCol, playerTile);
		if(isVerticalWin) {
			return true; 
		}

		boolean isDiagonalWin = checkDiagonal(lastRow, lastCol, playerTile);
		if(isDiagonalWin) {
			return true;
		}

		boolean isAntiDiagonalWin = checkAntiDiagonal(lastRow, lastCol, playerTile);
		if(isAntiDiagonalWin) {
			return true;
		}
		return false;
	}

	private boolean checkAntiDiagonal(int lastRow, int lastCol, Tile playerTile) {
		ArrayList<Position> positions = new ArrayList<>();
		positions.add(new Position(lastRow,lastCol));
		for (int i = lastRow - 1, j = lastCol + 1; i >= 0 && j < board[0].length && board[i][j] == playerTile; i--, j++) {
			positions.add(new Position(i,j));
		}
		for (int i = lastRow + 1, j = lastCol - 1; i < board.length && j >= 0 && board[i][j] == playerTile; i++, j--) {
			positions.add(new Position(i,j));
		}
		if (positions.size() > 3) {
			Tile highlightingTile = playerTile == Tile.PLAYER1? Tile.PLAYER1_HIGHLIGHTED: Tile.PLAYER2_HIGHLIGHTED;
			positions.forEach(position -> setTile(position.row(),position.col(),highlightingTile));
			return true;
		}

		return false;
	}

	private boolean checkDiagonal(int lastRow, int lastCol, Tile playerTile) {
		ArrayList<Position> positions = new ArrayList<>();
		positions.add(new Position(lastRow,lastCol));
		for (int i = lastRow - 1, j = lastCol - 1; i >= 0 && j >= 0 && board[i][j] == playerTile; i--, j--) {
			positions.add(new Position(i,j));
		}
		for (int i = lastRow + 1, j = lastCol + 1; i < board.length && j < board[0].length
				&& board[i][j] == playerTile; i++, j++) {
			positions.add(new Position(i,j));
		}
		if (positions.size() > 3) {
			Tile highlightingTile = playerTile == Tile.PLAYER1? Tile.PLAYER1_HIGHLIGHTED: Tile.PLAYER2_HIGHLIGHTED;
			positions.forEach(position -> setTile(position.row(),position.col(),highlightingTile));

			return true;
		}
		return false;
	}

	private boolean checkVertical(int lastRow, int lastCol, Tile playerTile) {
		ArrayList<Position> positions = new ArrayList<>();
		positions.add(new Position(lastRow,lastCol));
		for (int i = lastRow + 1; i < board.length && board[i][lastCol] == playerTile; i++) {
			positions.add(new Position(i,lastCol));
		}
		if (positions.size() > 3) {
			Tile highlightingTile = playerTile == Tile.PLAYER1? Tile.PLAYER1_HIGHLIGHTED: Tile.PLAYER2_HIGHLIGHTED;
			positions.forEach(position -> setTile(position.row(),position.col(),highlightingTile));

			return true;
		}
		return false;
	}

	private boolean checkHorizontal(int lastRow, int lastCol, Tile playerTile) {
		ArrayList<Position> positions = new ArrayList<>();
		positions.add(new Position(lastRow,lastCol));
		for (int i = lastCol - 1; i >= 0 && board[lastRow][i] == playerTile; i--) {
			positions.add(new Position(lastRow,i));
		}
		for (int i = lastCol + 1; i < board[0].length && board[lastRow][i] == playerTile; i++) {
			positions.add(new Position(lastRow,i));
		}
		if (positions.size() > 3) {
			Tile highlightingTile = playerTile == Tile.PLAYER1? Tile.PLAYER1_HIGHLIGHTED: Tile.PLAYER2_HIGHLIGHTED;
			positions.forEach(position -> setTile(position.row(),position.col(),highlightingTile));

			return true;
		}
		return false;
	}

}
