/**
 * This class simulates a Tic Tac Toe game
 * 
 * @author Sandersd93
 * @version 1.3 (02-20-2023)
 * @since 02-20-2023
 */

import java.util.Scanner;

public class App {
    public static int move = 1;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String sentinal = "";
        System.out.println("Patch 1.3 Notes:");
        System.out.println("•All bugs have been fixed");
        System.out.println("•Error message updated");
        while (!(sentinal.equals("Q")))
        {
            for (int i = 1; i < 10; i++)
            {
                int check = -1;
                if (i % 2 != 0)
                {
                   check = Players.player1();
                   if (check == 0) {break;}
                    
                }
                else
                {
                    check = Players.player2();
                    if (check == 0) {break;}
                }
                move++;
            }
            Board.restartBoard();
            System.out.print("Enter Q to exit : ");
            sentinal = in.next().trim().toUpperCase();

        }   
        in.close();
    }
}