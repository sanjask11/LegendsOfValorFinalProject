package entities.heroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.List;
/*
This class is responsible for loading all the heroes from the data folder
 */
public final class HeroLoader implements Serializable {

    private static final long serialVersionUID = 1L;

    private HeroLoader() {
        // utility class
    }

    public static void loadAll(List<Hero> list) {
        loadWarriors(list, "data/Warriors.txt");
        loadSorcerers(list, "data/Sorcerers.txt");
        loadPaladins(list, "data/Paladins.txt");
    }


    private static void loadWarriors(List<Hero> list, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // header
            String line;

            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name      = a[0];
                int mana         = Integer.parseInt(a[1]);
                int strength     = Integer.parseInt(a[2]);
                int agility      = Integer.parseInt(a[3]);
                int dexterity    = Integer.parseInt(a[4]);
                int money        = Integer.parseInt(a[5]);
                int xp           = Integer.parseInt(a[6]);

                list.add(new Warrior(name, mana, strength, agility, dexterity, money, xp));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Warriors: " + e.getMessage());
        }
    }


    private static void loadSorcerers(List<Hero> list, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name      = a[0];
                int mana         = Integer.parseInt(a[1]);
                int strength     = Integer.parseInt(a[2]);
                int agility      = Integer.parseInt(a[3]);
                int dexterity    = Integer.parseInt(a[4]);
                int money        = Integer.parseInt(a[5]);
                int xp           = Integer.parseInt(a[6]);

                list.add(new Sorcerer(name, mana, strength, agility, dexterity, money, xp));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Sorcerers: " + e.getMessage());
        }
    }


    private static void loadPaladins(List<Hero> list, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name      = a[0];
                int mana         = Integer.parseInt(a[1]);
                int strength     = Integer.parseInt(a[2]);
                int agility      = Integer.parseInt(a[3]);
                int dexterity    = Integer.parseInt(a[4]);
                int money        = Integer.parseInt(a[5]);
                int xp           = Integer.parseInt(a[6]);

                list.add(new Paladin(name, mana, strength, agility, dexterity, money, xp));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Paladins: " + e.getMessage());
        }
    }
}

