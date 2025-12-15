package core;

import java.util.Scanner;

/*
 * This class is a static pause screen utility.
 * Displays pause options and triggers save via callback.
 * It signals "quit to menu" using a runtime exception.
 */
public final class PauseMenu {

    private PauseMenu() {
        // utility class
    }

    public static void show(Scanner in, Runnable saveCallback) {
        System.out.println("\n=== GAME PAUSED ===");
        System.out.println("1. Resume");
        System.out.println("2. Save Game");
        System.out.println("3. Quit to Main Menu");
        System.out.println("0. Exit Game Entirely");

        while (true) {
            System.out.print("Choice: ");
            String s = in.nextLine().trim();

            // Java 8 compatible switch (no "->")
            switch (s) {
                case "1":
                    return;

                case "2":
                    System.out.println("Saving...");
                    if (saveCallback != null) {
                        saveCallback.run();
                    }
                    break;

                case "3":
                    // Signal quit-to-menu
                    throw new RuntimeException("QUIT_TO_MENU");

                case "0":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
