package game.exploration;

import core.ConsoleIO;
import entities.heroes.Hero;
import world.MHWorld;

import java.util.List;

public class MHExplorationUI implements ExplorationUIBase {

    @Override
    public void printMainPrompt() {
        System.out.println("Move (W/A/S/D), I=info, B=bag, M=market, V=save, L=load, P=pause, Q=quit:");
    }

    @Override
    public void printInvalidInput() {
        System.out.println("Invalid input.");
    }

    @Override
    public void printPartyInfo(List<Hero> heroes) {
        ConsoleIO.printHeading("PARTY INFO");
        for (Hero h : heroes) System.out.println(h);
    }

    @Override
    public void printGoodbye() {
        System.out.println("Goodbye!");
    }

    public void printMonstersAppear() {
        System.out.println("Monsters appear!");
    }

    public void printChooseMarketHero(List<Hero> heroes) {
        System.out.println("\nChoose hero to enter market:");
        for (int i = 0; i < heroes.size(); i++)
            System.out.println(i + ": " + heroes.get(i));
        System.out.print("Index (-1 to cancel): ");
    }

    public void printNotOnMarketTile() {
        System.out.println("You are not on a market tile.");
    }

    public void printGameRestored() {
        System.out.println("Game state restored.");
    }

    public void displayWorld(MHWorld world) {
        world.display();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void sleepShort() {
        try { Thread.sleep(90); } catch (Exception ignored) {}
    }
}
