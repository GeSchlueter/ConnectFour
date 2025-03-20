import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        int rows = 6;
        int cols = 7;
        char[][] board = new char[rows][cols];
        
        // Initialize the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = ' ';
            }
        }

        System.out.println("Let's play Connect Four! The board looks like this: ");
        
        // Print the initial board
        printBoard(board);

        System.out.println("Let's start!");
        Scanner scanner = new Scanner(System.in);
        int moveNumber = 1;
        
        while (true) {
            char playerMark = (moveNumber % 2 == 1) ? 'x' : 'o';
            System.out.println("Player " + playerMark + "'s turn:");
            
            // Input validation for column number
            int col = -1;
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print("Enter column (0-6): ");
                
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    
                    if (col >= 0 && col < cols) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 0 and " + (cols - 1) + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid token
                }
            }

            int row = findLowestAvailableRow(board, col);
            if (row == -1) {
                System.out.println("Column is full. Please choose another column.");
                continue;
            }
            
            board[row][col] = playerMark;
            
            // Print the updated board
            printBoard(board);

            moveNumber++;
            if (moveNumber > rows * cols) {
                break;
            }
        }

        scanner.close();
    }

    private static int findLowestAvailableRow(char[][] board, int col) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] == ' ') {
                return i;
            }
        }
        return -1; // Column is full
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
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
