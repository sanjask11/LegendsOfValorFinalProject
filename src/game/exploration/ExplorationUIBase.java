package game.exploration;

import entities.heroes.Hero;

import java.util.List;

/**
 * Shared UI interface for MH and LoV UIs.
 */
public interface ExplorationUIBase {

    void printMainPrompt();
    void printInvalidInput();
    void printPartyInfo(List<Hero> heroes);
    void printGoodbye();
}
