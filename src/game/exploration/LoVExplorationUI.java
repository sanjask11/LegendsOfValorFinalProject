package game.exploration;

import core.ConsoleIO;
import entities.heroes.Hero;
import world.LoVWorld;

import java.util.List;

public class LoVExplorationUI implements ExplorationUIBase {

    @Override
    public void printMainPrompt() {
        System.out.println("""
        Movement:
            W/A/S/D - move selected hero
            T - teleport hero
            R - recall hero to nexus
            M - market (Heroes' Nexus only)
            I - party info
            B - bag
            V - save game
            L - load game
            P - pause
            Q - quit
        """);
    }

    @Override
    public void printInvalidInput() {
        System.out.println("Invalid LoV command.");
    }

    @Override
    public void printPartyInfo(List<Hero> heroes) {
        ConsoleIO.printHeading("PARTY INFO");
        heroes.forEach(System.out::println);
    }

    @Override
    public void printGoodbye() {
        System.out.println("Leaving Legends of Valor...");
    }

    public void displayWorld(LoVWorld world) {
        world.display();
    }

    public void printTeleportPrompt() {
        System.out.println("Enter: heroIndex row col");
    }

    public void printRecallPrompt() {
        System.out.println("Enter heroIndex to recall: ");
    }
}
