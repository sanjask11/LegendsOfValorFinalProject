package game.exploration.commands;

import core.Direction;
import entities.heroes.Hero;
import world.LoVWorld;
import world.party.Party;

import java.util.Scanner;
/*
 Factory that maps user input to a concrete HeroCommand.
 Keeps command creation logic centralized (Java 8 friendly if/else).
 */
public class HeroCommandFactory {
    // Creates a command based on input; returns null for unknown commands.
    public static HeroCommand create(
            String input,
            LoVWorld world,
            int heroIdx,
            Hero hero,
            Scanner in,
            Party party
    ) {

        // Java 8 compatible (no switch expression, no ->)

        if ("W".equals(input)) {
            return new MoveCommand(world, heroIdx, hero, Direction.UP);

        } else if ("A".equals(input)) {
            return new MoveCommand(world, heroIdx, hero, Direction.LEFT);

        } else if ("S".equals(input)) {
            return new MoveCommand(world, heroIdx, hero, Direction.DOWN);

        } else if ("D".equals(input)) {
            return new MoveCommand(world, heroIdx, hero, Direction.RIGHT);

        } else if ("ATK".equals(input)) {
            return new AttackCommand(world, heroIdx, hero);

        } else if ("R".equals(input)) {
            return new RecallCommand(world, heroIdx, hero);

        } else if ("T".equals(input)) {
            return new TeleportCommand(world, heroIdx, hero, in);

        } else if ("U".equals(input)) {
            return new UsePotionCommand(hero, in);

        } else if ("C".equals(input)) {
            return new CastSpellCommand(world, heroIdx, hero, in);

        } else if ("O".equals(input)) {
            return new RemoveObstacleCommand(world, in);

        } else {
            return null;
        }
    }
}
