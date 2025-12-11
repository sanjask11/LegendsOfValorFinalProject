package core;
import java.util.Scanner;

/* Provides shared utility for all console based UI output
*/
public final class ConsoleIO {

    private ConsoleIO() {
    }

    public static void printHeading(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }

    public static void printSubHeading(String title) {
        System.out.println();
        System.out.println("--- " + title + " ---");
    }

    public static String prompt(Scanner in, String msg) {
        System.out.print(msg);
        return in.nextLine().trim();
    }
}
