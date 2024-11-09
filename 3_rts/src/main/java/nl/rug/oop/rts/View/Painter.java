package main.java.nl.rug.oop.rts.View;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Event.Events;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a painter class, that helps to draw menu items in the side panel.
 */
public class Painter {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph
     */
    public Painter(Graph graph) {
        this.graph = graph;
    }

    /**
     * Draw the elements of the node/edge.
     * @param box container to add the elements.
     */
    public void drawInfo(Container box){
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        Item selected = null;
        if (graph.getSelectedNode() != null) {
            selected = graph.getSelectedNode();
        } else {
            selected = graph.getSelectedEdge();
        }
        for (Army army: selected.getArmies()){
            JPanel container = new JPanel();
            JLabel armyL = new JLabel(army.getName());
            container.add(armyL, BorderLayout.CENTER);

            JPanel tempPanel = new JPanel();
            JLabel recruits = new JLabel(army.getNumUnits());
            tempPanel.add(recruits);
            container.add(tempPanel, BorderLayout.CENTER);
            box.add(container);
        }
        box.add(separator, BorderLayout.CENTER);
        for (Events event: selected.getEvents()){
            JPanel container = new JPanel();
            JLabel eventL = new JLabel(event.getName());
            container.add(eventL, BorderLayout.CENTER);
            box.add(container);
        }
    }

    /**
     * Adds a small panel with the army menu (adding/removing events).
     * @param box box to add the panel to
     */
    public void armyBox(Container box){
        JPanel container = new JPanel();
        JLabel armiesL = new JLabel("Armies:");
        JButton addArmy = new JButton("+");
        addArmy.addActionListener(e -> {
            createArmy();
        });
        JButton removeArmy = new JButton("-");
        if (graph.getSelectedNode().getArmies().isEmpty()) {
            removeArmy.setEnabled(false);
        } else {
            removeArmy.setEnabled(true);
        }
        removeArmy.addActionListener(e -> {
            deleteArmy();
        });
        container.add(armiesL);
        container.add(addArmy);
        container.add(removeArmy);
        container.setBackground(new Color(151,129,105));
        box.add(container);
    }

    /**
     * Adds a small panel with the event menu (adding/removing events).
     * @param box box to add the panel to
     */
    public void eventBox(Container box){
        JLabel eventsL = new JLabel("Events:");
        JButton addEvent = new JButton("+");
        addEvent.addActionListener(e -> {
            createEvent();
        });
        JButton removeEvent = new JButton("-");
        if ((graph.getSelectedNode() != null && graph.getSelectedNode().getEvents().isEmpty())
                || (graph.getSelectedEdge() != null && graph.getSelectedEdge().getEvents().isEmpty())) {
            removeEvent.setEnabled(false);
        } else {
            removeEvent.setEnabled(true);
        }
        removeEvent.addActionListener(e -> {
            deleteEvent();
        });

        JPanel container = new JPanel();
        container.setBackground(new Color(151,129,105));
        container.add(eventsL);
        container.add(addEvent);
        container.add(removeEvent);

        box.add(container);
    }

    /**
     * Function allows to add a new event to the node/edge.
     */
    private void createEvent() {
        String[] options = {"Covenstead", "Healer Tower", "Hurricane"};
        try {
            String selectedEvent = (String) JOptionPane.showInputDialog(null,
                    "Select an event type",
                    "Events",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (graph.getSelectedNode() != null) {
                graph.getSelectedNode().addEvent(selectedEvent);
            } else {
                graph.getSelectedEdge().addEvent(selectedEvent);
            }
            graph.notifyAllObservers();
        } catch (NullPointerException error) {
            System.err.println(error);
        }
    }

    /**
     * Function to delete the event from the item (node/edge).
     */
    private void deleteEvent() {
        Item selected;
        java.util.List<String> options = new ArrayList<>();
        if (graph.getSelectedNode() != null) {
            selected = graph.getSelectedNode();
        } else {
            selected = graph.getSelectedEdge();
        }
        for (Events event : selected.getEvents()) {
            options.add(event.getName());
        }
        String[] events = options.toArray(new String[0]);
        try {
            String selectedEvent =
                    (String) JOptionPane.showInputDialog(null,
                            "Select an event to delete",
                            "Events",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            events,
                            events[0]);
            selected.deleteEvent(selectedEvent);
            graph.notifyAllObservers();
        } catch (NullPointerException error) {
            System.err.println(error);
        }
    }

    /**
     * Method used to display the window for choosing the army type to delete.
     * Also triggers the implementation for the deletion.
     */
    private void deleteArmy() {
        List<String> options = new ArrayList<>();
        for (Army army : graph.getSelectedNode().getArmies()) {
            options.add(army.getName());
        }
        String[] armies = options.toArray(new String[0]);
        try {
            String selectedArmy =
                    (String) JOptionPane.showInputDialog(null,
                            "Select an army type",
                            "Armies",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            armies,
                            armies[0]);
            graph.getSelectedNode().deleteArmy(selectedArmy);
            graph.notifyAllObservers();
        } catch (NullPointerException error) {
            System.err.println(error);
        }
    }

    /**
     * The method for creating the army with a selection of the army type.
     */
    private void createArmy() {
        String[] armies = {"Men", "Dwarves", "Elves", "Isengard", "Mordor"};
        try {
            String selectedArmy = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an army type",
                    "Armies", JOptionPane.QUESTION_MESSAGE,
                    null, armies, armies[0]);
            graph.getSelectedNode().addNewArmy(selectedArmy);
            graph.notifyAllObservers();
        } catch (NullPointerException error) {
            System.err.println(error);
        }
    }
}
