package main.java.nl.rug.oop.rts;

import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.View.Frame;

/**
 * This is the game class.
 * The graph (Model) and the Frame (View) are initialised here.
 */
public class Game {

    /**
     * This function initialises the graph and frame.
     */
    public void playGame() {
        Graph g = new Graph();
        Frame f = new Frame(g);
    }
}
