package main.java.nl.rug.oop.rts.Model;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Controller.Interfaces.Observable;
import main.java.nl.rug.oop.rts.Model.Event.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph class. Stores all the information about currently existing nodes and edges.
 * Main component of the model in MVC (in this program).
 */
public class Graph implements Observable, Jsonise {
    private List<Node> nodes;
    private List<Edge> edges;
    private Node selectedNode;
    private Edge selectedEdge;
    private Node clickedNewEdge;
    private List<Item> items;
    private boolean isBattle;
    private Events activeEvent;
    private GraphFunctions gf;

    /**
     * Constructor of the class.
     */
    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.selectedNode = null;
        this.selectedEdge = null;
        this.clickedNewEdge = null;
        this.items = new ArrayList<>();
        this.isBattle = false;
        this.activeEvent = null;
        this.gf = new GraphFunctions(this);
    }

    /**
     * A battle setter.
     *
     * @param battle there is a battle or not
     */
    public void setBattle(boolean battle) {
        isBattle = battle;
    }

    /**
     * An event setter.
     *
     * @param activeEvent event that occurs
     */
    public void setActiveEvent(Events activeEvent) {
        this.activeEvent = activeEvent;
    }

    public boolean getBattle() {
        return this.isBattle;
    }

    /**
     * Used to change the location of the selected node.
     *
     * @param x coordinate in 2D plane.
     * @param y coordinate in 2D plane.
     */
    public void changeXYLoc(int x, int y) {
        selectedNode.setXYPos(x, y);
    }

    /**
     * Used to add the node to the graph.
     *
     * @param node new node to add.
     */
    public void addNode(Node node) {
        gf.addNode(node);
    }

    /**
     * This function removes the selected node from the graph.
     *
     * @param node node to remove
     */
    public void removeNode(Node node) {
        gf.removeNode(node);
    }

    public List<Item> getItems() {
        return this.items;
    }

    /**
     * Sets the clicked node.
     * Used to register the first clicked node when creating an edge between two nodes.
     *
     * @param node node to which the edge is to be created.
     */
    public void setClickedNewEdge(Node node) {
        this.clickedNewEdge = node;
    }

    public Node getClickedNewEdge() {
        return this.clickedNewEdge;
    }

    /**
     * Checks if the edge between the two nodes already exists.
     *
     * @param one node one
     * @param two node two
     * @return true if the edge exists, false otherwise.
     */
    public boolean checkExistingEdge(Node one, Node two) {
        return gf.checkExistingEdge(one, two);
    }

    /**
     * This functions adds an edge to the graph.
     * @param one node one to add an edge to
     * @param two node two to add an edge to
     * @param edge an edge to be added.
     */
    public void addEdge(Edge edge, Node one, Node two) {
        gf.addEdge(edge, one, two);
    }

    /**
     * Used to remove an edge from the graph.
     *
     * @param edge an edge to be removed.
     */
    public void removeEdge(Edge edge) {
        gf.removeEdge(edge);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * The function sets the new selected edge.
     *
     * @param edge an edge to select.
     */
    public void setSelectedEdge(Edge edge) {
        gf.select(edge);
    }

    /**
     * The function sets the new selected node.
     * Resets the old one and updates the properties of the node (color).
     *
     * @param node a node to select.
     */
    public void setSelectedNode(Node node) {
        gf.setNode(node);
    }

    public Edge getSelectedEdge() {
        return selectedEdge;
    }

    public Node getSelectedNode() {
        return selectedNode;
    }

    @Override
    public String getJSONData() {
        return gf.getJSONData();
    }

    /**
     * This function sets selected edge.
     * @param edge edge to set selected
     */
    public void setSelEdge(Edge edge) {
        this.selectedEdge = edge;
    }

    /**
     * This function sets selected node.
     * @param node node to set selected
     */
    public void setSelNode(Node node) {
        this.selectedNode = node;
    }
}
