package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
This class,
 * Handles serialization based save/load operations.
 * Persists a GameState to disk and restores it later.
 * Errors are contained and reported without crashing the game loop.
 */
public final class SaveManager {

    private SaveManager() {

    }

    public static void save(GameState state, String file) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(state);
            out.flush();
            System.out.println("Game saved to " + file);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static GameState load(String file) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof GameState state) {
                System.out.println("Game loaded from " + file);
                return state;
            } else {
                System.out.println("Save file is not a valid GameState.");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Could not load game: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Class mismatch while loading game: " + e.getMessage());
            return null;
        }
    }
}

