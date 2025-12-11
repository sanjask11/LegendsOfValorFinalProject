package game;

import entities.heroes.HeroFactory;
import entities.monsters.MonsterFactory;
import world.MHWorld;
import world.party.Party;

import java.util.Random;
import java.util.Scanner;
/*
This class is the entry point of the game!
 */
public class MHGame implements GameMode{

    private final Scanner in = new Scanner(System.in);

    public void start() {
        System.out.println("=== MONSTERS & HEROES ===");


        HeroFactory heroFactory = new HeroFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        SetupMenu setupMenu = new SetupMenu(in, heroFactory);
        Party party = setupMenu.chooseParty();
        int worldSize = setupMenu.askWorldSize();

        MHWorld MHWorld = new MHWorld(worldSize, party);
        MHWorld.display();


        ExplorationMenu explorationMenu =
                new ExplorationMenu(in, MHWorld, party, monsterFactory, new Random());

        explorationMenu.show();
    }
}
