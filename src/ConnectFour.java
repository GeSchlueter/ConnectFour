import java.util.Scanner;

import board.Board;
import tiles.Tiles;

public class ConnectFour {
    public static void main(String[] args) {
    		
    	Board board = new Board();
        System.out.println("Let's play Connect Four! The board looks like this: ");
        
        board.print();

        System.out.println("Let's start!");
        Scanner scanner = new Scanner(System.in);
        int moveNumber = 1;
        Tiles p1 = Tiles.PLAYER1;
        Tiles p2 = Tiles.PLAYER2;
        
        System.out.println("Player 1: " + p1.getSymbol() + ", Player 2: " + p2.getSymbol());

        while (true) {
            Tiles playerTile = (moveNumber % 2 == 1) ? p1 : p2;
            System.out.println("Player " + playerTile.getSymbol() + "'s turn:");
            
            // Input validation for column number
            int col = -1;
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print("Enter column (0-6): ");
                
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    
                    if (col >= 0 && col < Board.COLS) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 0 and " + (Board.COLS - 1) + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid token
                }
            }

            int row = board.findLowestAvailableRow(col);
            if (row == -1) {
                System.out.println("Column is full. Please choose another column.");
                continue;
            }
            
            board.setTile(row, col, playerTile);
            
            board.print();
            
            moveNumber++;
            if (moveNumber > Board.ROWS * Board.COLS) {
            	System.out.println("The board is completely filled! It´s a tie:D");
                break;
            }
         // Check for a win
            if (board.checkWin(row, col, playerTile)) {
        
            	System.out.println("Player " + playerTile + " wins! :D");
                break;
            }
        }

        scanner.close();
    }

}
