/**
 * This class determines the outcome of the game
 * 
 * @author Sanders93
 * @version 1.2 (02-20-2023)
 * @since 02-20-2023
 */

public class Game {
    
    /**
     * This method output the outcome of the game
     * @param piece piece of either player 1 or 2
     */
    public static int gameOutCome(String piece)
    {
        int check = -1;
        if (piece.equals("X") && gameChecker(piece) == true)
        {
            Board.printBoard();
            System.out.println("Player 1 has won the game");
            check = 0;
        }
        else if (piece.equals("O") && gameChecker(piece) == true)
        {
            Board.printBoard();
            System.out.println("Player 2 has won the game");
            check = 0;
        }
        else if (!gameChecker(piece) && App.move > 8 &&(piece.equals("X") || piece.equals("O")))
        {
            System.out.println("The game ended in a draw");
            Board.printBoard();
        }
        return check;
    }
    /**
     * This methods looks for 3 pieces in row in any direction
     * @param piece the piece of either player 1 or 2
     * @return whether or not there are 3 pieces in a row in any direction
     */
    public static boolean gameChecker(String piece)
    {
        boolean result = false;

        if (checkLine(1, piece) == true) {result = true;}
        else if (checkLine(2, piece) == true ) {result = true;}
        else if (checkLine(3, piece) == true) {result = true;}
        else if (checkColumn(1, piece) == true) {result = true;}
        else if (checkColumn(2, piece) == true) {result = true;}
        else if (checkColumn(3, piece) == true) {result = true;}
        else if (checkDiagonal(1, piece) == true) {result = true;}
        else if (checkDiagonal(-1, piece) == true) {result = true;}

        return result;
    }

    /**
     * This methods check a line of the board for 3 pieces in a row
     * @param line the line to check
     * @param piece the piece to look for
     * @return whether or not there are 3 pieces in a row
     */
    public static boolean checkLine(int line, String piece)
    {
        boolean result = false;
        int count = 0;

        for (int i = 0; i < 3; i++)
        {
            if (Board.board[line - 1][i].equals(piece)) {count++;}
        }
        if (count == 3) {result = true;}

        return result;
    }

    public static boolean checkColumn(int column, String piece)
    {
        boolean result = false;
        int count = 0;

        for (int i = 0; i < 3; i++)
        {
            if (Board.board[i][column - 1].equals(piece)) {count++;}
        }

        if (count == 3) {result = true;}

        return result;
    }

    /**
     * This methods checks the diagonal of the board for 3 pieces in a row
     * @param orientation the orientation of the diagonal
     * @param piece the piece to look for
     * @return whether or not there are 3 pieces in a row
     */
    public static boolean checkDiagonal(int orientation, String piece)
    {
        boolean resutl = false;
        int count = 0;

        if (orientation == 1)
        {   
            for (int i = 0; i < 3; i++)
            {
                if (Board.board[i][i].equals(piece)) {count++;}
            
            }
        }
        else
        {
            int j = 2;
            for (int i = 0; i < 3; i++)
            {
                if (Board.board[i][j].equals(piece)) {count++;}
                j--;
            }
        }
        if (count == 3) {resutl = true;}

        return resutl;
    }
}