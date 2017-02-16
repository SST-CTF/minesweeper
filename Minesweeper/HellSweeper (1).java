import java.lang.Math.*;
import java.util.Scanner;
/**
 * Mine Sweeper but every click you die
 */
public class HellSweeper
{
    /**
     * Constructor for objects of class HellSweeper
     */
    public HellSweeper()
    {
        int[][] board = new int[5][5];

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                int rng = (int)(Math.random() * 2);
                board[i][j] = rng;
            }
        }

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        int playing = 0;
        while(playing == 0)
        {
            Scanner r = new Scanner(System.in);
            System.out.println("Enter row number: ");
            int row = r.nextInt();

            Scanner c = new Scanner(System.in);
            System.out.println("Enter column number: ");
            int col = c.nextInt();

            if(board[row][col] == 1)
            {
                System.out.println("Game over. Welcome to Hellsweeper, the game with literally no strategy or skill.");
                playing = 1;
            }
            else
            {
                System.out.println("You're not dead yet.");
            }
        }
    }
}