/**
 * This class contains methods to print and manage a Tic Tac Toe board
 * 
 * @author sanders93
 * @version 1.1 (02-20-2023)
 * @since 02-20-2023
 */

//import java.util.Arrays;
//import java.util.Scanner;

public class Board {
    
    /**
     * This the board instruction
     */
    public static String[][] board = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
    };

    /**
     * This method prints instructions for the user to know how to place his pieces on the board
     */
    public static void printBoardInstructions()
    {
        printBoardSeparator();
        printBoardLine(1);
        printBoardSeparator();
        printBoardLine(4);
        printBoardSeparator();
        printBoardLine(7);
        printBoardSeparator();
    }

    /**
     * This helper method prints a separator
     */
    public static void printBoardSeparator()
    {
        System.out.println("+---+---+---+");
    }

    /**
     * This method prints lines numbered
     * @param number the number to start at
     */
    public static void printBoardLine(int number)
    {
        for (int i = 0; i < 13; i += 4)
        {
            if (i < 12)
            {   
                System.out.printf("| %d ", number);
                number++;
            }  
            else {System.out.print("|   ");}   
        }
        System.out.println();
    }
    /**
     * This method prints a tic tac toe board
     */
    public static void printBoard()
    {
        printBoardSeparator();
        printBoardLines(1);
        printBoardSeparator();
        printBoardLines(2);
        printBoardSeparator();
        printBoardLines(3);
        printBoardSeparator();
    }

    
    /**
     * This helper method prints the board lines with pieces on them
     * @param number the number to start at
     */
    public static void printBoardLines(int number)
    {
        int j = 0;
        for (int i = 0; i < 13; i += 4)
        {
            if (i < 9)
            {   
                String piece = board[number - 1][j];
                System.out.printf("| %s ", piece);
                j++;
            }  
            else {System.out.print("|   ");}   
        }
        System.out.println();
    }

    /**
     * This method places a piece on a selected square
     * @param piece the piece to place
     * @param row the row of the board where the square is at 
     * @param column the column of the board where the square is at
     */
    public static void printPieces(String piece, int row, int column) 
    {
        board[row][column] = piece;
    }

    /**
     * This methods checks if there is already a piece at a given square
     * @param position the position of the square
     * @return whether or not there is already a piece in this square
     */
    public static boolean checkSquare(int position)
    {
        boolean result = true;

        if (position == 1) {result = checkSquareHelper(0, 0);}
        else if (position == 2) {result = checkSquareHelper(0, 1);}
        else if (position == 3) {result = checkSquareHelper(0, 2);}
        else if (position == 4) {result = checkSquareHelper(1, 0);}
        else if (position == 5) {result = checkSquareHelper(1, 1);}
        else if (position == 6) {result = checkSquareHelper(1, 2);}
        else if (position == 7) {result = checkSquareHelper(2, 0);}
        else if (position == 8) {result = checkSquareHelper(2, 1);}
        else if (position == 9) {result = checkSquareHelper(2, 2);}

        return result;
    }

    /**
     * This helper methods checks for an existing piece in a given square
     * @param row the row where the square is at
     * @param column the column where the square is at
     * @return whether or not there is already a piece in that square
     */
    public static boolean checkSquareHelper(int row, int column)
    {
        boolean result = true;
        if (board[row][column].equals("X")|| board[row][column].equals("O"))
        {
            result = false;
            System.out.println("This square has already been selected!");
        }
        return result;
    }

    /**
     * This method restarts the board to its initial form
     */
    public static void restartBoard()
    {
        int num = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = "" + num;
                num++;
            }
        }
    }
    
}