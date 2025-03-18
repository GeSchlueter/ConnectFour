import java.util.Scanner;

public class ConnectFour {

	public static void main(String[] args) {

		int rows = 6;
		int cols = 7;

		char[][] board = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = ' ';
			}
		}
		
		
		System.out.println("Let´s play Connect Four! The board looks like this: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}

		System.out.println("Let´s start!");

		Scanner scanner = new Scanner(System.in);

		int moveNumber = 1;

		while (true) {

			char playerMark = (moveNumber % 2 == 1) ? 'x' : 'o';

			System.out.println("Player " + playerMark + "´s turn:");

			System.out.println("Enter row (0-5): ");
			int row = scanner.nextInt();

			System.out.println("Enter column (0-6): ");
			int col = scanner.nextInt();

			board[row][col] = playerMark;

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(board[i][j] + " | ");
				}
				System.out.println();
			}

			moveNumber++;

			if (moveNumber > rows * cols) {
				break;
			}
		}

		scanner.close();
	}

}

//	boolean playerOneTurn = true;
//while ( winner == false && turn <=42) {
//	boolean validPlay;
//	int play;
//	do {
//		
//		printGrid(board);
//		
//		System.out.println("Player " + player + ", choose a column: ");
//		play = in.nextInt();
//		
//		validPlay = validate(play,board);
//		
//	}while (validPlay == false);
//	
//	
//}
//
//	public static boolean validate(int column, char[][] board){
//		//valid column?
//		if (column < 0 || column > board[0].length){
//			return false;
//		}
//		
//		//full column?
//		if (board[0][column] != ' '){
//			return false;
//		}
//		
//		return true;
//	}
//	
//	public static boolean isWinner(char player, char[][] board){
//		//check for 4 across
//		for(int row = 0; row<board.length; row++){
//			for (int col = 0;col < board[0].length - 3;col++){
//				if (board[row][col] == player   && 
//					board[row][col+1] == player &&
//					board[row][col+2] == player &&
//					board[row][col+3] == player){
//					return true;
//				}
//			}			
//		}
//		//check for 4 up and down
//		for(int row = 0; row < board.length - 3; row++){
//			for(int col = 0; col < board[0].length; col++){
//				if (board[row][col] == player   && 
//					board[row+1][col] == player &&
//					board[row+2][col] == player &&
//					board[row+3][col] == player){
//					return true;
//				}
//			}
//		}
//		//check upward diagonal
//		for(int row = 3; row < board.length; row++){
//			for(int col = 0; col < board[0].length - 3; col++){
//				if (board[row][col] == player   && 
//					board[row-1][col+1] == player &&
//					board[row-2][col+2] == player &&
//					board[row-3][col+3] == player){
//					return true;
//				}
//			}
//		}
//		//check downward diagonal
//		for(int row = 0; row < board.length - 3; row++){
//			for(int col = 0; col < board[0].length - 3; col++){
//				if (board[row][col] == player   && 
//					board[row+1][col+1] == player &&
//					board[row+2][col+2] == player &&
//					board[row+3][col+3] == player){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//}
