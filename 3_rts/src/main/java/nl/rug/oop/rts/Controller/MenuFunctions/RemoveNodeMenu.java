package main.java.nl.rug.oop.rts.Controller.MenuFunctions;

import main.java.nl.rug.oop.rts.Model.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements the deleting option for the node.
 */
public class RemoveNodeMenu implements ActionListener {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph to read the information about nodes from.
     */
    public RemoveNodeMenu(Graph graph) {
        this.graph = graph;
    }

    /**
     * On click of the button, delete the selected node.
     * @param e the event to be processed (click)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (graph.getSelectedNode() != null) {
            graph.removeNode(graph.getSelectedNode());
            graph.setSelectedNode(null);
            graph.notifyAllObservers();
        }
    }
}
