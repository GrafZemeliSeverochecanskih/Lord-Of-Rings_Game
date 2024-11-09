package main.java.nl.rug.oop.rts.Controller;

import main.java.nl.rug.oop.rts.Model.Edge;
import main.java.nl.rug.oop.rts.Model.Node;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for implementation of heuristics functions to find the distance to the edge.
 */
public class Heuristics {

    /**
     * Calculates whether the click was on the edge using Line2D.
     * Lines 34-36 adapted from stackoverflow. Available at:
     * https://stackoverflow.com/questions/60915867/how-do-you-check-if-a-mouse-press-is-on-a-line-in-java
     * @param x coordinate of the click
     * @param y coordinate of the click
     * @param edge used to retrieve the nodes
     * @return true if the edge was clicked. False otherwise.
     */
    public boolean calcChoice(int x, int y, Edge edge) {
        int radius = 30;
        int centerXOne = edge.getNodeOne().getXPos() + radius;
        int centerYOne = (int) (edge.getNodeOne().getYPos() + (radius * 1.5));
        int centerXTwo = edge.getNodeTwo().getXPos() + radius;
        int centerYTwo = (int) (edge.getNodeTwo().getYPos() + (radius * 1.5));
        double distance = Line2D.ptLineDist(centerXOne, centerYOne, centerXTwo, centerYTwo, x, y);
        if (distance < 5) {
            return true;
        }
        return false;
    }

    /**
     * This function calculates the distance between clicked point and given node using Euclidean distance.
     *
     * @param node given node
     * @param x    x coordinate of click
     * @param y    y coordinate of click
     * @return the distance between node and click
     */
    public double calculateDist(Node node, int x, int y) {
        double centerX = node.getXPos() + 30;
        double centerY = node.getYPos() + (30 * 1.5);
        double dist = Math.sqrt((Math.pow((centerX - x), 2) + Math.pow((centerY - y), 2)));
        return dist;
    }

    /**
     * This function returns the closest edge to given coordinates.
     *
     * @param edges list of all edges
     * @param x     x coordinate of the click
     * @param y     y coordinate of the click
     * @return the closest edge
     */
    public Edge selectEdge(List<Edge> edges, int x, int y) {
        for (Edge edge : edges) {
            boolean edgeDist = calcChoice(x, y, edge);
            if (edgeDist) {
                return edge;
            }
        }
        return null;
    }

    /**
     * This function returns all nodes that were clicked.
     *
     * @param nodes all available nodes
     * @param x     x coordinate of the click
     * @param y     y coordinate of the click
     * @return list of all nodes that can be selected
     */
    public List<Node> selectNodes(List<Node> nodes, int x, int y) {
        List<Node> availableNodes = new ArrayList();
        for (Node node : nodes) {
            if ((((node.getXPos() <= x) && (x <= (node.getXPos() + 60)))
                    &&
                    // 45 and 135 if frame
                    ((node.getYPos() <= y) && (y <= (node.getYPos() + 90))))) {
                availableNodes.add(node);
            }
        }
        if (availableNodes.isEmpty()) {
            return null;
        }
        return availableNodes;
    }

    /**
     * This function selects one node, which is the closest to clicked point, if there are intersecting nodes.
     *
     * @param nodes list of nodes
     * @param x     x coordinate of click
     * @param y     y coordinate of click
     * @return node, which is the closest to click
     */
    public Node selectOneNode(List<Node> nodes, int x, int y) {
        if (nodes.size() == 1) {
            return nodes.get(0);
        }
        Node minNode = nodes.get(0);
        double minNodeDist = calculateDist(minNode, x, y);
        for (Node node : nodes) {
            double nodeDist = calculateDist(node, x, y);
            if (minNodeDist > nodeDist) {
                minNode = node;
                minNodeDist = nodeDist;
            }
        }
        return minNode;
    }
}
