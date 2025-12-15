package market;

import items.*;
import items.potions.BasicPotion;
import items.spells.FireSpell;
import items.spells.IceSpell;
import items.spells.LightningSpell;

import java.io.BufferedReader;
import java.io.FileReader;

public final class MarketLoader {

    private MarketLoader() {}

    public static void loadAll(Market market) {
        loadWeapons(market, "data/Weaponry.txt");
        loadArmors(market, "data/Armory.txt");
        loadPotions(market, "data/Potions.txt");
        loadFireSpells(market);
        loadIceSpells(market);
        loadLightningSpells(market);
    }

    /* ---------- WEAPONS ---------- */

    private static void loadWeapons(Market market, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !isBlank(line)) {
                String[] a = line.trim().split("\\s+");
                market.addWeapon(new Weapon(
                        a[0],
                        Integer.parseInt(a[1]),
                        Integer.parseInt(a[2]),
                        Integer.parseInt(a[3]),
                        Integer.parseInt(a[4])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading weapons: " + e.getMessage());
        }
    }

    /* ---------- ARMORS ---------- */

    private static void loadArmors(Market market, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !isBlank(line)) {
                String[] a = line.trim().split("\\s+");
                market.addArmor(new Armor(
                        a[0],
                        Integer.parseInt(a[1]),
                        Integer.parseInt(a[2]),
                        Integer.parseInt(a[3])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading armors: " + e.getMessage());
        }
    }

    /* ---------- POTIONS ---------- */

    private static void loadPotions(Market market, String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !isBlank(line)) {
                String[] a = line.trim().split("\\s+");
                market.addPotion(new BasicPotion(
                        a[0],
                        Integer.parseInt(a[1]),
                        Integer.parseInt(a[2]),
                        Integer.parseInt(a[3]),
                        a[4]
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading potions: " + e.getMessage());
        }
    }

    /* ---------- SPELLS ---------- */

    private static void loadFireSpells(Market market) {
        loadSpellFile(market, "data/FireSpells.txt", "FIRE");
    }

    private static void loadIceSpells(Market market) {
        loadSpellFile(market, "data/IceSpells.txt", "ICE");
    }

    private static void loadLightningSpells(Market market) {
        loadSpellFile(market, "data/LightningSpells.txt", "LIGHTNING");
    }

    private static void loadSpellFile(Market market, String file, String kind) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && !isBlank(line)) {
                String[] a = line.trim().split("\\s+");

                String name = a[0];
                int cost = Integer.parseInt(a[1]);
                int level = Integer.parseInt(a[2]);
                int damage = Integer.parseInt(a[3]);
                int mana = Integer.parseInt(a[4]);
                int uses = 1;

                // Java 8 compatible switch (no "->")
                if ("FIRE".equals(kind)) {
                    market.addSpell(new FireSpell(name, cost, level, damage, mana, uses));
                } else if ("ICE".equals(kind)) {
                    market.addSpell(new IceSpell(name, cost, level, damage, mana, uses));
                } else if ("LIGHTNING".equals(kind)) {
                    market.addSpell(new LightningSpell(name, cost, level, damage, mana, uses));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading spells: " + e.getMessage());
        }
    }

    // Java 8 replacement for String.isBlank() (Java 11+)
    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
