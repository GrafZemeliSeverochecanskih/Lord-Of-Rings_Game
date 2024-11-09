package main.java.nl.rug.oop.rts.Controller.MenuFunctions;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Observable;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Class implements the logic for creating the new node.
 */
public class CreateNodeMenu implements ActionListener, Observable {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph to write enw data to (new node).
     */
    public CreateNodeMenu(Graph graph) {
        this.graph = graph;
    }

    /**
     * Function creates a new node with random location, and id.
     * Takes the input from the user for the name of the node.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Random random = new Random();
        try {
            String name = JOptionPane.showInputDialog(
                    null, "Node Name: ",
                    "Node Initialization", JOptionPane.QUESTION_MESSAGE);
            if (name != null) {
                int id = random.nextInt(987654321);
                Color color = new Color(127,80,44);
                Node node = new Node(id, name, random.nextInt(400), random.nextInt(500), color);
                //update the graph with a node
                graph.addNode(node);
                graph.notifyAllObservers();
            }
        } catch (NullPointerException err) {
            JOptionPane.showMessageDialog(null, "Error occurred!");
        }
    }
}
