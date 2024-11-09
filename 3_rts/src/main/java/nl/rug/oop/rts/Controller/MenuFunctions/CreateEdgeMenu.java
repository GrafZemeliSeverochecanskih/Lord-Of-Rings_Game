package main.java.nl.rug.oop.rts.Controller.MenuFunctions;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Observer;
import main.java.nl.rug.oop.rts.Model.Edge;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Node;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class implements the ActionListener for the "New Edge" option of the Menu bar.
 */
public class CreateEdgeMenu implements ActionListener, Observer {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph with the data of nodes and edges.
     */
    public CreateEdgeMenu(Graph graph) {
        this.graph = graph;

    }

    /**
     * Function keeps track if the node is selected.
     * If so the button will be set to enabled
     * Otherwise the button is disabled.
     * Reading the selected node from the graph.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (graph.getSelectedNode() != null && graph.getClickedNewEdge() == null) {
            // issue with copies.
            Node node = graph.getSelectedNode();
            graph.setClickedNewEdge(node);
        }
        graph.notifyAllObservers();
    }


    /**
     * If the button was clicked, the function waits for the input of the second node.
     * Then, it creates an edge between them.
     */
    @Override
    public void triggerUpdate() {
        if (graph.getSelectedNode() != null && graph.getClickedNewEdge() != null) {
            Node one = graph.getClickedNewEdge();
            Node two = graph.getSelectedNode();
            graph.setSelectedNode(null);
            try {
                if (!two.equals(one) && !graph.checkExistingEdge(one, two)) {
                    Random random = new Random();
                    int id = random.nextInt(987654321);
                    String edgeName = (one.getName()).concat(two.getName());
                    graph.addEdge(new Edge(id, edgeName, one, two), one, two);
                    graph.setClickedNewEdge(null);
                    graph.setSelectedNode(null);
                }
                graph.notifyAllObservers();
            } catch (NullPointerException e){
                System.err.println("No node was selected.");
            }
        }
    }
}

