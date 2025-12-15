package game;

import java.util.Scanner;
/*
  Simple launcher that lets the player choose MH or LoV mode.
 Instantiates the chosen GameMode and starts the game.
 */
public class GameLauncher {

    public void launch() {
        Scanner in = new Scanner(System.in);

        System.out.println("=== LEGENDS COLLECTION ===");
        System.out.println("Which game do you want to play?");
        System.out.println("1. Legends: Monsters & Heroes");
        System.out.println("2. Legends of Valor");

        int choice = in.nextInt();

        GameMode game;

        if (choice == 1) {
            game = new MHGame();
        } else {
            game = new LoVGame();
        }

        game.start();
    }
}
