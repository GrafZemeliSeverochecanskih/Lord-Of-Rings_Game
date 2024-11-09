package main.java.nl.rug.oop.rts.Controller.MenuFunctions;

import main.java.nl.rug.oop.rts.Model.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class implements the logic for the deletion of the edge.
 */
public class RemoveEdgeMenu implements ActionListener {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph to delete the edge from.
     */
    public RemoveEdgeMenu(Graph graph) {
        this.graph = graph;
    }

    /**
     * Deletes the selected edge from the graph.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Remove edge
        if (graph.getSelectedEdge() != null) {
            graph.removeEdge(graph.getSelectedEdge());
            graph.setSelectedEdge(null);
            graph.notifyAllObservers();
        }
    }
}
