package market;

import items.*;

import java.io.BufferedReader;
import java.io.FileReader;

public final class MarketLoader {

    private MarketLoader() {}

    public static void loadAll(Market market) {
        loadWeapons(market, "data/Weaponry.txt");
        loadArmors(market, "data/Armory.txt");
        loadPotions(market, "data/Potions.txt");
        loadSpells(market);
    }

    private static void loadWeapons(Market market, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name = a[0];
                int cost = Integer.parseInt(a[1]);
                int level = Integer.parseInt(a[2]);
                int damage = Integer.parseInt(a[3]);
                int hands = Integer.parseInt(a[4]);
                market.addWeapon(new Weapon(name, cost, level, damage, hands));
            }
        } catch (Exception e) {
            System.out.println("Error loading weapons: " + e.getMessage());
        }
    }

    private static void loadArmors(Market market, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name = a[0];
                int cost = Integer.parseInt(a[1]);
                int level = Integer.parseInt(a[2]);
                int reduction = Integer.parseInt(a[3]);
                market.addArmor(new Armor(name, cost, level, reduction));
            }
        } catch (Exception e) {
            System.out.println("Error loading armors: " + e.getMessage());
        }
    }

    private static void loadPotions(Market market, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name = a[0];
                int cost = Integer.parseInt(a[1]);
                int level = Integer.parseInt(a[2]);
                int amount = Integer.parseInt(a[3]);
                String affected = a[4];
                market.addPotion(new Potion(name, cost, level, amount, affected));
            }
        } catch (Exception e) {
            System.out.println("Error loading potions: " + e.getMessage());
        }
    }

    private static void loadSpells(Market market) {
        loadSpellFile(market, "data/FireSpells.txt", SpellType.FIRE);
        loadSpellFile(market, "data/IceSpells.txt", SpellType.ICE);
        loadSpellFile(market, "data/LightningSpells.txt", SpellType.LIGHTNING);
    }

    private static void loadSpellFile(Market market, String file, SpellType type) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                String[] a = line.trim().split("\\s+");
                String name = a[0];
                int cost = Integer.parseInt(a[1]);
                int level = Integer.parseInt(a[2]);
                int damage = Integer.parseInt(a[3]);
                int mana = Integer.parseInt(a[4]);
                int uses = 1;
                market.addSpell(new Spell(name, type, cost, level, damage, mana, uses));
            }
        } catch (Exception e) {
            System.out.println("Error loading spells: " + e.getMessage());
        }
    }
}

