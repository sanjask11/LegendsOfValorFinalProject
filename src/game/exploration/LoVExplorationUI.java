package game.exploration;

import core.ConsoleIO;
import entities.heroes.Hero;
import world.LoVWorld;

import java.util.List;
/*
Console UI for LoV exploration.
Prints command menu, party info, and simple prompts.
 */
public class LoVExplorationUI implements ExplorationUIBase {

    @Override
    public void printMainPrompt() {
        System.out.println("[W/A/S/D]=Move  M=Market  I=Info  B=Inventory  Q=Quit  P=Pause  SG=Save Game  L=Load Game");


        System.out.println("T  Teleport");
        System.out.println("R  Recall");
        System.out.println("ATK Attack");
        System.out.println("C  Cast Spell");
        System.out.println("U  Use Potion");
        System.out.println("O  Remove Obstacle");
    }

    @Override
    public void printInvalidInput() {
        System.out.println("Invalid LoV command.");
    }

    @Override
    public void printPartyInfo(List<Hero> heroes) {
        ConsoleIO.printHeading("PARTY INFO");

        for (Hero h : heroes) {
            System.out.println(h);
        }
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
