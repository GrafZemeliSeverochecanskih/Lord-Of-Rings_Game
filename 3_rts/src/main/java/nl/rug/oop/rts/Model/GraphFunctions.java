package main.java.nl.rug.oop.rts.Model;

import java.awt.*;
import java.util.List;

/**
 * A class needed to implement function of selection.
 */
public class GraphFunctions {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph where selection occurs
     */
    public GraphFunctions(Graph graph) {
        this.graph = graph;
    }

    /**
     * This function implement function of selection.
     * @param edge an edge to be selected.
     */
    public void select(Edge edge) {
        if (graph.getSelectedNode() != null) {
            graph.getSelectedNode().setColor(graph.getSelectedNode().getColor().darker());
            graph.setSelectedNode(null);
        }
        if (graph.getSelectedEdge() != edge) {
            if (graph.getSelectedEdge() != null) {
                graph.getSelectedEdge().setColor(Color.BLACK);
            }
            graph.setSelEdge(edge);
            if (graph.getSelectedEdge() != null) {
                graph.getSelectedEdge().setColor(Color.BLUE);
            }
        }
    }

    /**
     * This function implements JSON format for the Graph.
     * @return String in the JSON format.
     */
    public String getJSONData() {
        String indent = " ";
        String dIndent = indent + indent;
        String edgeJSON = "";
        String nodeJSON = "";
        for (Edge edge : graph.getEdges()) {
            edgeJSON += edge.getJSONData();
        }
        for (Node node : graph.getNodes()) {
            nodeJSON += node.getJSONData();
        }
        String edgeIndent = "";
        String nodeIndent = "";
        String newline = "\n";
        if (!edgeJSON.equals("")) {
            edgeIndent = "\n";
        }
        if (!nodeJSON.equals("")) {
            nodeIndent = "\n";
        }
        return "{" + newline + indent + "\"Graph\": [" + newline +
                dIndent + "\"Nodes\": [" + nodeIndent + nodeJSON + dIndent + "]," + newline +
                dIndent + "\"Edges\": [" + edgeIndent + edgeJSON + dIndent + "]" + newline + indent + "]" +
                newline + "}";
    }

    /**
     * This function properly highlights selected node.
     * @param node node to be highlighted
     */
    public void setNode(Node node) {
        if (graph.getSelectedEdge() != null) {
            graph.getSelectedEdge().setColor(Color.BLACK);
            graph.setSelEdge(null);
        }
        if (graph.getSelectedNode() != null) {
            graph.getSelectedNode().setColor(graph.getSelectedNode().getColor().darker());
        }
        graph.setSelNode(node);
        if (node != null) {
            graph.getSelectedNode().setColor(graph.getSelectedNode().getColor().brighter());
        }
    }

    /**
     * This function adds edge to graph.
     * @param edge new edge to be added
     * @param one  node one of new edge
     * @param two  node two of new edge
     */
    public void addEdge(Edge edge, Node one, Node two) {
        graph.getEdges().add(edge);
        one.addEdge(edge);
        two.addEdge(edge);
        graph.getItems().add(edge);
    }

    /**
     * This function adds node to the graph.
     * @param node node to be added
     */
    public void addNode(Node node) {
        graph.getNodes().add(node);
        graph.getItems().add(node);
    }

    /**
     * This function removes node from the graph.
     * @param node node to remove from the graph
     */
    public void removeNode(Node node) {
        List<Edge> toDel = node.getEdges();
        for (Edge edge : toDel) {
            graph.getEdges().remove(edge);
            graph.getItems().remove(edge);
        }
        graph.getNodes().remove(node);
        graph.getItems().remove(node);
    }

    /**
     * This function checks if there already exists an edge between two nodes.
     * @param one node one that will be checked whether there is an edge to node two
     * @param two node two that will be checked whether there is an edge to node one
     * @return there is an edge between given two nodes or not
     */
    public boolean checkExistingEdge(Node one, Node two) {
        for (Edge edge : one.getEdges()) {
            return ((edge.getNodeOne() == one) && (edge.getNodeTwo() == two))
                    || (edge.getNodeOne() == two) && (edge.getNodeTwo() == one);
        }
        return false;
    }

    /**
     * The function removes edge.
     * @param edge edge to remove
     */
    public void removeEdge(Edge edge) {
        edge.getNodeOne().removeEdge(edge);
        edge.getNodeTwo().removeEdge(edge);
        graph.getEdges().remove(edge);
        graph.getItems().remove(edge);
    }
}