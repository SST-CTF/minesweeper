
/**
 * Write a description of class game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class game
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class game
     */
    public game()
    {
        // initialise instance variables
    }

    /**
     * This method will bring out the board to the user
     */
    public static void printBoard(String[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     */
    public static void main()
    {
        int turn = 0;
        String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        while (turn <= 4)
        {
            if (turn == 0)
            {
                // Player "X" will go
                board = player1Play(board);
            }
            else if (turn == 1)
            {
                // Player "O" will go
                board = player2Play(board);
            }
            else if (turn == 2)
            {
                // Player "X" wins
                board = player1Win(board);
            }
            else if (turn == 3)
            {
                // Player "O" wins
                board = player2Win(board);
            }
            else if (turn == 4)
            {
                // There is a tie
                board = tiedGame(board);
            }
            turn ++;
        }
        System.out.println("Error 1");
    }
}