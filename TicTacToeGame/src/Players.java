/**
 * This class handles the player 1 and 2 moves
 * 
 * @author Sanders93
 * @version 1.1 (05-30-2024)
 * @since 02-20-2023
 */

import java.util.Scanner;

public class Players {
    private static Scanner in = new Scanner(System.in);

    public static int player1() 
    {
        System.out.println("Player 1 turn");
        makeMove(getPosition(), "X");
        clearConsole();
        return Game.gameOutCome("X");
    }

    public static int player2()
    {
        System.out.println("Player 2 turn");
        makeMove(getPosition(), "O");
        clearConsole();
        return Game.gameOutCome("O");
    }

    /**
     * This method prompts and gets the position of the next move
     * @return the position of the next move
     */
    public static int getPosition()
    {
        int position = 0;

        do {
            Board.printBoard();
            System.out.print("Enter the number of square you want to put your piece on : ");

            String userEntry = in.nextLine().trim();

            while (checkInput(userEntry))
            {
                System.out.println("Enter a valid character!");
                userEntry = in.nextLine().trim();
            }
            position = Integer.parseInt(userEntry);
            
        } while (!(Board.checkSquare(position)) || !(position >= 1 && position <= 9));
        return position;
    }

    /**
     * This method adds the next move to the board
     * @param position the postion of the next move
     * @param piece the piece of the next move
     */
    public static void makeMove(int position, String piece)
    {
        if (position == 1) {Board.printPieces(piece, 0, 0);}
        else if (position == 2) {Board.printPieces(piece, 0 , 1);}
        else if (position == 3) {Board.printPieces(piece, 0 , 2);}
        else if (position == 4) {Board.printPieces(piece, 1 , 0);}
        else if (position == 5) {Board.printPieces(piece, 1 , 1);}
        else if (position == 6) {Board.printPieces(piece, 1 , 2);}
        else if (position == 7) {Board.printPieces(piece, 2 , 0);}
        else if (position == 8) {Board.printPieces(piece, 2, 1);}
        else if (position == 9) {Board.printPieces(piece, 2 , 2);}
    }

    /**
     * This method clears the console
     */
    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
    }

    public static boolean checkInput(String userEntry)
    {
        boolean hasString = false;
        int index = 0;

        while (index < userEntry.length())
        {
            if (!(userEntry.charAt(index) >= '1' && userEntry.charAt(index) <= '9'))
            {
                hasString = true; 
            }
            index++;
        }

        return hasString;
    }
}