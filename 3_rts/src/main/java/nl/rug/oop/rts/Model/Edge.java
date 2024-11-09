package main.java.nl.rug.oop.rts.Model;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Event.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements edge.
 */
public class Edge extends Item {
    private Node nodeOne;
    private Node nodeTwo;

    /**
     * Constructor of the class.
     *
     * @param edgeID   a unique int id.
     * @param edgeName an edge name.
     * @param nodeOne  the first node the edge connects.
     * @param nodeTwo  the second node the edge connects.
     */
    public Edge(int edgeID, String edgeName, Node nodeOne, Node nodeTwo) {
        super(edgeID, edgeName);
        this.nodeOne = nodeOne;
        this.nodeTwo = nodeTwo;
        this.events = new ArrayList<>();
    }

    public Node getNodeOne() {
        return this.nodeOne;
    }

    public Node getNodeTwo() {
        return this.nodeTwo;
    }

    public List<Events> getEvents() {
        return this.events;
    }

    public void setArmies(List<Army> armies) {
        this.armies = armies;
    }

    /**
     * This function saves information from the edge as a string for JSON file.
     *
     * @return string with information from edge
     */
    @Override
    public String getJSONData() {
        String indent = "     ";
        String armyJSON = "";
        String eventJSON = "";
        for (Army army : armies) {
            armyJSON += army.getJSONData();
        }
        for (Events event : events) {
            eventJSON += event.getJSONData();
        }
        String lineIndent = "";
        String eventLine = "";
        String armyIndent = "";
        String eventIndent = "";
        if (!armyJSON.equals("")) {
            lineIndent = "    ";
            armyIndent = "\n";
        }
        if (!eventJSON.equals("")) {
            eventIndent = "\n";
            eventLine = "     ";
        }
        String s = "   {" + "\n" + indent +
                "\"Name\": \"" + name + "\", \n" + indent +
                "\"Id\": " + id + ", \n" + indent +
                "\"Node1\": " + nodeOne.getName() + ", \n" + indent +
                "\"Node2\": " + nodeTwo.getName() + ", \n" + indent +
                "\"Armies\": [" + armyIndent + armyJSON + lineIndent + "], \n" + indent
                + "\"Events\": [" + eventIndent + eventJSON + eventLine + "]\n" + "   }" + "\n";
        return s;
    }
}
