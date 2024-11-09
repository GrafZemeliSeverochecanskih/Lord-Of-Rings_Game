package main.java.nl.rug.oop.rts.View;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Observer;
import main.java.nl.rug.oop.rts.Model.Graph;

import javax.swing.*;
import java.awt.*;

/**
 * Information panel class used as the node menu in the JSplitPane.
 */
public class SidePanel extends JPanel implements Observer {
    private Graph graph;

    /**
     * Constructor of the class.
     *
     * @param graph storing existing nodes and edges.
     */
    public SidePanel(Graph graph) {
        this.graph = graph;
    }

    /**
     * The function used to create the objects in the side panel (this).
     * Buttons, fields for changing the name of teh node, etc.
     */
    public void initialize() {
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        Painter painter = new Painter(graph);
        repaint();
        if (graph.getSelectedNode() == null && graph.getSelectedEdge() == null) {
            removeAll();
        }
        Container box = createSelMenu();
        if (graph.getSelectedNode() != null) {
            painter.armyBox(box);
            box.add(separator, BorderLayout.CENTER);
        }
        painter.eventBox(box);
        box.add(separator, BorderLayout.CENTER);
        painter.drawInfo(box);
        add(box);
        setVisible(true);
        revalidate();
    }

    /**
     * Creates the box for changing the name of the selected item (node/edge).
     *
     * @return the container with renaming functionality.
     */
    private Container createSelMenu() {
        Container box = Box.createVerticalBox();
        JLabel name;
        if (graph.getSelectedNode() != null) {
            name = new JLabel(graph.getSelectedNode().getName());
        } else {
            name = new JLabel(graph.getSelectedEdge().getName());
        }
        box.add(name);
        JTextField textField = new JTextField();
        box.add(textField);
        JPanel holder = new JPanel();
        holder.setBackground(new Color(151,129,105));
        holder.setLayout(new FlowLayout());
        JButton button = new JButton("Rename");
        holder.add(button);
        button.addActionListener(e -> {
            if (graph.getSelectedNode() != null) {
                graph.getSelectedNode().setName(textField.getText());
            } else {
                graph.getSelectedEdge().setName(textField.getText());
            }
            graph.notifyAllObservers();
        });
        box.add(holder);
        return box;
    }

    /**
     * Implementation of the Observer pattern.
     * Triggers the update of the panel regarding the selected object.
     */
    @Override
    public void triggerUpdate() {
        removeAll();
        if (graph.getSelectedNode() != null || graph.getSelectedEdge() != null) {
            Color color = new Color(151,129,105);
            setBackground(color);
            repaint();
            initialize();
        } else {
            repaint();
        }
        revalidate();
    }
}

