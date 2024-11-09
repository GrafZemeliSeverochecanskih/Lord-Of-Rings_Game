package main.java.nl.rug.oop.rts.View;

import main.java.nl.rug.oop.rts.Controller.MouseAdapter;
import main.java.nl.rug.oop.rts.Model.Graph;

import javax.swing.*;

/**
 * This is the frame class. The frame holds all the panels.
 */
public class Frame extends JFrame {
    private final Graph graph;

    /**
     * Constructor of the class.
     * Creates and instantiates all the objects in the frame.
     *
     * @param graph storing existing nodes and edges.
     */
    public Frame(Graph graph) {
        this.graph = graph;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        Panel panel = new Panel(graph);
        MouseAdapter ma = new MouseAdapter(graph);
        panel.addMouseListener(ma);
        panel.addMouseMotionListener(ma);
        SidePanel ip = new SidePanel(graph);
        MenuBar mb = new MenuBar(graph);
        setJMenuBar(mb);
        setLocationRelativeTo(null);
        // add Observers here
        graph.addObserver(mb);
        graph.addObserver(panel);
        graph.addObserver(ip);
        JSplitPane js = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ip, panel);
        js.setDividerLocation(250);
        js.setOpaque(false);
        add(js);
        setVisible(true);

    }
}
