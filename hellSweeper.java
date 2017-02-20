import java.lang.Math.*;
import java.util.Scanner;

/**
 * Title: Minesweeper 
 * Description: A game where you try to avoid mines.
 * Authors: Tamir Enkjargle, Dane Miller, Otakar Andrysek
 * Date: 2/13/17
 */

public class HellSweeper
{
    // Initialize board (this is a 5x5 board, two extra rows and column are added for padding)
            // NEW: The board can now be any size.
    static int[][] board = new int[7][7];
    // The board that the user sees
    static String[][] visableBoard = new String[board.length - 2][board.length - 2];
    // The number of mines left on the board
    static int safeSpots = 0;
    
    /**
     * This method is the main game run code
     */
    public static void main(String[] args)
    {
        for (int i = 1; i < board.length - 2; i++)
        {
            // Set the i'th row of the first and last column to zero
            board[i][0] = 0;
            board[i][board.length - 1] = 0;
            for (int j = 1; j < board.length - 2; j++)
            {
                // Set the j'th column of the first and last row to zero
                board[0][j] = 0;
                board[board.length - 1][j] = 0;
                // This generates a random number 0 | 1, 1 indicates there is a bomb, 0 is safe
                int isBomb = (int)(Math.random() * 2);
                if(isBomb == 0)
                {
                    // Increment safeSpots, the number of squares without mines
                    safeSpots += 1;
                }
                // Set the board to contain (or not contain) the mines
                board[i][j] = isBomb;
                visableBoard[i-1][j-1] = "x";
            }
        }
        
        // The main game loop
        boolean playing = true;
        while (playing == true)
        {
            // Print the baord to the user
            printBoard();
            
            // Scan for row
            System.out.println("Enter row number: ");
            int row = getInput();

            // Scan for column
            System.out.println("Enter column number: ");
            int col = getInput();
        
            // RIP, the user landed on a mine
            if (board[row][col] == 1)
            {
                System.out.println("Game over. Welcome to Hellsweeper, the game with literally no strategy or skill.");
                printRealBoard();
                playing = false;
            }
            // Looks like they got lucky
            else
            {
                showNearby(row, col);
                safeSpots -= 1;
                visableBoard[row-1][col-1] = Integer.toString(showNearby(row, col));
                System.out.println("You're not dead yet.");
                // Maybe there are no more mines left?
                if(safeSpots <= 0)
                {
                    System.out.println("WINNER WINNER MAD LUCK SUPER CHEATS ALERT");
                    playing = false;
                }
            }
        }
    }
    
    /**
     * This method gets user input
     */
    public static int getInput()
    {
        Scanner reader = new Scanner(System.in);  
        int input = reader.nextInt();   // Scans the input as an int
        reader.close();
        return input;
    }

    /**
     * This method prints the hidden board as an (n*m) matrix
     * NOTE: No current application except for testing
     */
    public static void printRealBoard()
    {
        for (int i = 0; i < board.length - 1; i++)
        {
            for (int j = 0; j < board.length - 1; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * This method prints the game board as an (n*m) matrix
     */
    public static void printBoard()
    {
        for (int i = 0; i < visableBoard.length - 1; i++)
        {
            for (int j = 0; j < visableBoard.length - 1; j++)
            {
                System.out.print(visableBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * This method check nearby spots for mines and returns the number of mines in the nearby 3x3 area
     */
    public static int showNearby(int row, int col)
    {
        int nearbyMines = 0;
        
        // Check the top - left corner
        if (board[row + 1][col - 1] == 1)
        {
            nearbyMines += 1;
        }
        // Check the top - right corner
        if (board[row + 1][col + 1] == 1)
        {
            nearbyMines += 1;
        }
        // Check the bottom - left corner
        if (board[row - 1][col - 1] == 1)
        {
            nearbyMines += 1;
        }
        // Check the bottom - right corner
        if (board[row - 1][col + 1] == 1)
        {
            nearbyMines += 1;
        }
        // Check the top side
        if (board[row + 1][col] == 1)
        {
            nearbyMines += 1;
        }
        // Check the bottom side
        if (board[row - 1][col] == 1)
        {
            nearbyMines += 1;
        }
        // Check the left side
        if (board[row][col - 1] == 1)
        {
            nearbyMines += 1;
        }
        // Check the right side
        if (board[row][col + 1] == 1)
        {
            nearbyMines += 1;
        }

        return nearbyMines;
    }
}