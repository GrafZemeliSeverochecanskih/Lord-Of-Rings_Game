package main.java.nl.rug.oop.rts.Controller;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Observable;
import main.java.nl.rug.oop.rts.Model.Edge;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Node;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * MouseAdapter class that takes care of the mouse actions in the panels.
 */
public class MouseAdapter implements MouseListener, MouseMotionListener, Observable {
    private Panel panel;
    private Graph graph;

    /**
     * Constructor of the class.
     *
     * @param graph a graph with edges and nodes.
     */
    public MouseAdapter(Graph graph) {
        this.graph = graph;
    }

    /**
     * The function implements the logic for the mouse click.
     * Calculates if the click was on the area covered by the node or edge.
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Node node = null;
        Heuristics h = new Heuristics();
        graph.setSelectedNode(null);
        // Chooses overlapped if there are, selects the
        List<Node> availableNodes = h.selectNodes(graph.getNodes(), x, y);
        if (availableNodes != null) {
            node = h.selectOneNode(availableNodes, x, y);
        }
        graph.setSelectedNode(node);
        if (node == null) {
            Edge edge = h.selectEdge(graph.getEdges(), x, y);
            graph.setSelectedNode(null);
            graph.setSelectedEdge(edge);
        }
        graph.notifyAllObservers();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Function used to record the mouse dragging and move the node accordingly.
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (graph.getSelectedNode() != null) {
            graph.changeXYLoc(x, y);
            graph.notifyAllObservers();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
