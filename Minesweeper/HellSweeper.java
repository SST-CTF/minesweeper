import java.lang.Math.*;
import java.util.Scanner;
/**
 * Minesweeper but every click you die
 */
public class HellSweeper
{
    static int[][] board = new int[5][5];
    static String[][] visableBoard = new String[5][5];
    static int safe = 0;
    /**
     * Constructor for objects of class HellSweeper
     */
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                int rng = (int)(Math.random() * 2);
                if(rng == 0)
                {
                    safe += 1;
                }
                board[i][j] = rng;
                visableBoard[i][j] = "x";
            }
        }
        printBoard();
        int playing = 0;
        while(playing == 0)
        {
            Scanner r = new Scanner(System.in);
            System.out.println("Enter row number: ");
            int row = r.nextInt();

            Scanner c = new Scanner(System.in);
            System.out.println("Enter column number: ");
            int col = c.nextInt();
	    
	    	    
            if(board[row-1][col-1] == 1)
            {
                System.out.println("Game over. Welcome to Hellsweeper, the game with literally no strategy or skill.");
                printRealBoard();
                playing = 1;
            }
            else
            {
		showNearby(row, col);
		safe -= 1;
                visableBoard[row-1][col-1] = Integer.toString(showNearby(row, col));
                System.out.println("You're not dead yet.");
                printBoard();
                if(safe <= 0)
                {
                    System.out.println("WINNER WINNER MAD LUCK SUPER CHEATS ALERT");
                    playing = 1;
                }
            }
        }
    }
    public static void printRealBoard()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printBoard()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(visableBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int showNearby(int row, int col)
    {
	int nearbyMines = 0;
	if (board[row-2][col-2] == 1)
	{
	    nearbyMines += 1;
	}
	if (board[row-1][col-2] == 1)
	{
	    nearbyMines += 1;
	}
	if (board[row][col-2] == 1)
        {
	    nearbyMines += 1;         
	}
	if (board[row-2][col-2] == 1)
	{
	    nearbyMines += 1;
	}
	if (board[row][col-1] == 1)
	{
	    nearbyMines += 1;
	}
	if (board[row-2][col] == 1)
	{
	    nearbyMines += 1;
	}
	if (board[row-1][col] == 1)
	{
	    nearbyMines += 1;
	}
	if (board[row][col] == 1)
	{
	    nearbyMines += 1;
	}
	
	if (nearbyMines == 0) {
	    return 0;
	}
	return 0;
    }
}
