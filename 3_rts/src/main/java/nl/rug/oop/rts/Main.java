package main.java.nl.rug.oop.rts;

import javax.swing.*;

/**
 * This is the main class through which the entire program is run.
 */
public class Main {

    /**
     * Method to run the program.
     * @param args system arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            main.java.nl.rug.oop.rts.Game game = new Game();
            game.playGame();
        });
    }
}


