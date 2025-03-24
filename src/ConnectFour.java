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
        char p1 = 'x';  //'⚫';  I NEED A DIFFRENT BOARD FOR THE COOLER SYMBOLS
        char p2 = 'o';  //'⚪';
        System.out.println("Player 1: " + p1 + ", Player 2: " + p2);

        while (true) {
            char playerMark = (moveNumber % 2 == 1) ? p1 : p2;
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
         // Check for a win
            if (checkWin(board, row, col, playerMark)) {
                System.out.println("Player " + playerMark + " wins!");
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
    
    private static boolean checkWin(char[][] board, int lastRow, int lastCol, char playerMark) {
            // Check horizontal line
            int countLeft = 0;
            for (int i = lastCol - 1; i >= 0 && board[lastRow][i] == playerMark; i--) {
                countLeft++;
            }
            int countRight = 0;
            for (int i = lastCol + 1; i < board[0].length && board[lastRow][i] == playerMark; i++) {
                countRight++;
            }
            if (countLeft + countRight >= 3) {
                return true;
            }

            // Check vertical line
            int countDown = 0;
            for (int i = lastRow + 1; i < board.length && board[i][lastCol] == playerMark; i++) {
                countDown++;
            }
            if (countDown >= 3) {
                return true;
            }

            // Check diagonal line (top-left to bottom-right)
            int countDiagUp = 0;
            for (int i = lastRow - 1, j = lastCol - 1; i >= 0 && j >= 0 && board[i][j] == playerMark; i--, j--) {
                countDiagUp++;
            }
            int countDiagDown = 0;
            for (int i = lastRow + 1, j = lastCol + 1; i < board.length && j < board[0].length && board[i][j] == playerMark; i++, j++) {
                countDiagDown++;
            }
            if (countDiagUp + countDiagDown >= 3) {
                return true;
            }

            // Check diagonal line (top-right to bottom-left)
            int countAntiDiagUp = 0;
            for (int i = lastRow - 1, j = lastCol + 1; i >= 0 && j < board[0].length && board[i][j] == playerMark; i--, j++) {
                countAntiDiagUp++;
            }
            int countAntiDiagDown = 0;
            for (int i = lastRow + 1, j = lastCol - 1; i < board.length && j >= 0 && board[i][j] == playerMark; i++, j--) {
                countAntiDiagDown++;
            }
            if (countAntiDiagUp + countAntiDiagDown >= 3) {
                return true;
            }

            return false;
    }
    
}
