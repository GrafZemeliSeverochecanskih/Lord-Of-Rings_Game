package main.java.nl.rug.oop.rts.Controller.MenuFunctions;

import main.java.nl.rug.oop.rts.Model.Battle.Simulations;
import main.java.nl.rug.oop.rts.Model.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements the triggering of the simulation run, when the button is pressed.
 */
public class SimulateTimeStep implements ActionListener {
    private Simulations s;

    /**
     * Constructor of the class.
     * @param graph graph to run the simulation on
     */
    public SimulateTimeStep(Graph graph) {
        this.s = new Simulations(graph);
    }

    /**
     * Runs the simulation on click.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        s.runSimulation();
    }
}
