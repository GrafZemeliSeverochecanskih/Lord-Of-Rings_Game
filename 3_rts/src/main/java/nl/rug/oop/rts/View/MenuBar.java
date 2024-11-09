package main.java.nl.rug.oop.rts.View;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Observer;
import main.java.nl.rug.oop.rts.Controller.MenuFunctions.*;
import main.java.nl.rug.oop.rts.Model.Graph;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This is the MenuBar class used to create and initialize the MenuBar.
 */
public class MenuBar extends JMenuBar implements Observer {
    private ArrayList<JMenuItem> menuItems;
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph storing existing nodes and edges.
     */
    public MenuBar(Graph graph) {
        this.menuItems = new ArrayList<>();
        this.graph = graph;
        addButtons();
        for (JMenuItem item : menuItems) {
            this.add(item);
        }
    }

    /**
     * This function adds "Create Edge" button.
     */
    private void addCreateEdgeButton() {
        JMenuItem createEdge = new JMenuItem("New Edge");
        createEdge.setEnabled(false);
        CreateEdgeMenu edgeMenu = new CreateEdgeMenu(graph);
        graph.addObserver(edgeMenu);
        createEdge.addActionListener(edgeMenu);

        this.menuItems.add(createEdge);
    }

    /**
     * This function adds "Create Node" button.
     */
    private void addCreateNodeButton() {
        JMenuItem createNode = new JMenuItem("New Node");
        createNode.addActionListener(new CreateNodeMenu(graph));
        this.menuItems.add(createNode);
    }

    /**
     * This function adds "Remove Edge" button.
     */
    private void addRemoveEdgeButton() {
        JMenuItem removeEdge = new JMenuItem("Remove Edge");
        removeEdge.setEnabled(false);
        removeEdge.addActionListener(new RemoveEdgeMenu(graph));
        this.menuItems.add(removeEdge);
    }

    /**
     * This function adds "Remove Node" button.
     */
    private void addRemoveNodeButton() {
        JMenuItem removeNode = new JMenuItem("Remove Node");
        removeNode.setEnabled(false);
        removeNode.addActionListener(new RemoveNodeMenu(graph));
        this.menuItems.add(removeNode);
    }

    private void addSimulationButton() {
        JMenuItem simulateTimeStep = new JMenuItem("Simulate Time Step");
        simulateTimeStep.addActionListener(new SimulateTimeStep(graph));
        this.menuItems.add(simulateTimeStep);
    }

    private void addSaveJSONButton() {
        JMenuItem saveJSON = new JMenuItem("Save to JSON");
        saveJSON.addActionListener(new SaveJSONMenu(graph));
        this.menuItems.add(saveJSON);
    }

    /**
     * This function adds all buttons to the menu bar.
     */
    private void addButtons() {
        addCreateNodeButton();
        addCreateEdgeButton();
        addRemoveNodeButton();
        addRemoveEdgeButton();
        addSimulationButton();
        addSaveJSONButton();
    }

    /**
     * Implementation of the Observer pattern.
     * Triggers the setEnable for the buttons based on the information from the graph.
     */
    @Override
    public void triggerUpdate() {
        for (JMenuItem item : menuItems) {
            switch (item.getText()) {
                case "New Edge", "Remove Node":
                    item.setEnabled(graph.getSelectedNode() != null);
                    break;
                case "Remove Edge":
                    item.setEnabled(graph.getSelectedEdge() != null);
                    break;
                default:
                    item.setEnabled(true);
            }
        }
    }
}
