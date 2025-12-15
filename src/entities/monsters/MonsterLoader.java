package entities.monsters;

import java.io.File;
import java.util.Scanner;

/*
This class is responsible for loading all the monsters from the data folder
 */
public class MonsterLoader {
    // Loads all monster categories into the factory.
    public static void loadAll(MonsterFactory factory) {
        loadDragons(factory);
        loadSpirits(factory);
        loadExoskeletons(factory);
    }
    // Reads Dragons.txt and registers Dragon templates.
    private static void loadDragons(MonsterFactory factory) {
        try (Scanner sc = new Scanner(new File("data/Dragons.txt"))) {
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] t = line.split("\\s+");
                if (t.length < 5) continue;

                factory.addDragon(new Dragon(
                        t[0],                        // name
                        Integer.parseInt(t[1]),      // level
                        Integer.parseInt(t[2]),      // damage
                        Integer.parseInt(t[3]),      // defense
                        Integer.parseInt(t[4])       // dodge
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading Dragons: " + e.getMessage());
        }
    }
    // Reads Spirits.txt and registers Spirit templates.
    private static void loadSpirits(MonsterFactory factory) {
        try (Scanner sc = new Scanner(new File("data/Spirits.txt"))) {
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] t = line.split("\\s+");
                if (t.length < 5) continue;

                factory.addSpirit(new Spirit(
                        t[0],                     // name
                        Integer.parseInt(t[1]),    // level
                        Integer.parseInt(t[2]),    // damage
                        Integer.parseInt(t[3]),    // defense
                        Integer.parseInt(t[4])     // dodgeChance
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading Spirits: " + e.getMessage());
        }
    }
    // Reads Exoskeletons.txt and registers Exoskeleton templates.
    private static void loadExoskeletons(MonsterFactory factory) {
        try (Scanner sc = new Scanner(new File("data/Exoskeletons.txt"))) {
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] t = line.split("\\s+");
                if (t.length < 5) continue;

                factory.addExoskeleton(new Exoskeleton(
                        t[0],
                        Integer.parseInt(t[1]),
                        Integer.parseInt(t[2]),
                        Integer.parseInt(t[3]),
                        Integer.parseInt(t[4])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading Exoskeletons: " + e.getMessage());
        }
    }
}
