package main.java.nl.rug.oop.rts.Model;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Army.*;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.DwarvesArmy;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.DwarvesUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.Units.ATUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.Units.GUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.Units.PUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.ElvesArmy;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.ElvesUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.Units.LWUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.Units.MAUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.Units.RLUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.MenArmy;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.MenUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.Units.GSUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.Units.IRUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.Units.TGUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.IsengardArmy;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.IsengardUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.Units.UCUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.Units.UHUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.Units.WRUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.MordorArmy;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.MordorUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.Units.HAUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.Units.OPUnit;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.Units.OWUnit;
import main.java.nl.rug.oop.rts.Model.Event.Events;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Node class. Serves as the main representation unit.
 */
public class Node extends Item implements Jsonise {
    private List<Edge> edges;
    private int xPos;
    private int yPos;

    /**
     * Constructor of the class.
     *
     * @param nodeID   unique int id
     * @param nodeName node name given by the user.
     * @param x        x coordinate of the left upper corner of the bounding rectangle.
     * @param y        y coordinate of the left upper corner of the bounding rectangle.
     * @param color    color of the node.
     */
    public Node(int nodeID, String nodeName, int x, int y, Color color) {
        super(nodeID, nodeName);
        this.xPos = x;
        this.yPos = y;
        this.color = color;
        this.edges = new ArrayList<>();
        events = new ArrayList<>();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Used to change the x,y coordinates of the node (location).
     *
     * @param x coordinate in a 2d plane.
     * @param y coordinate in a 2d plane.
     */
    public void setXYPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    /**
     * Used to add edges to the node.
     * @param edge an edge to add.
     */
    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    /**
     * Used to remove the edge from the node.
     *
     * @param edge an edge to remove
     */
    public void removeEdge(Edge edge) {
        this.edges.remove(edge);
    }

    /**
     * This function changes the number of units within an army.
     *
     * @param army     army that needs to be changed
     * @param isAdd    add or remove army
     * @param typeArmy army type
     */
    private void smartFuncArmy(Army army, boolean isAdd, String typeArmy) {
        for (Army x : armies) {
            if (x.getName().equals(typeArmy)) {
                if (isAdd) {
                    x.increaseUnitNum(-1);
                } else {
                    x.decreaseUnitNum(-1);
                    if (x.getNumberOfUnits() <= 0) {
                        armies.remove(x);
                    }
                }
                return;
            }
        }
        armies.add(army);
        army.setStartNode(this);
    }

    public void deleteArmy(String selectedItem) {
        smartFuncArmy(null, false, selectedItem);
    }

    /**
     * Generates the random unit fo the preferred faction.
     * @param faction of choice
     * @return random unit type of that faction
     */
    public Unit getRandomUnit(String faction){
        List<Unit> units = new ArrayList<>();
        Random random = new Random();
        switch (faction){
            case "Men":
                units.add(new GSUnit(10, 50, "GS"));
                units.add(new IRUnit(13, 46, "IR"));
                units.add(new TGUnit(14, 47, "TG"));
                break;
            case "Dwarves":
                units.add(new ATUnit(15, 60, "AT"));
                units.add(new GUnit(20, 43, "G"));
                units.add(new PUnit(22, 40, "P"));
                break;
            case "Elves":
                units.add(new LWUnit(9, 65, "LW"));
                units.add(new MAUnit(8, 70, "MA"));
                units.add(new RLUnit(10, 57, "RL"));
                break;
            case "Isengard":
                units.add(new UCUnit(24, 35, "AT"));
                units.add(new UHUnit(26, 40, "G"));
                units.add(new WRUnit(30, 30, "P"));
                break;
            case "Mordor":
                units.add(new HAUnit(40, 27, "AT"));
                units.add(new OPUnit(41, 31, "G"));
                units.add(new OWUnit(35, 29, "P"));
                break;
        }
        int randUnit = random.nextInt(units.size());
        return units.get(randUnit);
    }

    /**
     * This function creates an army depending on which fraction was selected.
     *
     * @param selectedItem fraction name
     */
    public void addNewArmy(String selectedItem) {
        switch (selectedItem) {
            case "Men":
                MenArmy menArmy = new MenArmy(15, (MenUnit) getRandomUnit("Men"));
                smartFuncArmy(menArmy, true, menArmy.getName());
                break;
            case "Dwarves":
                DwarvesArmy dwarvesArmy = new DwarvesArmy(18, (DwarvesUnit) getRandomUnit("Dwarves"));
                smartFuncArmy(dwarvesArmy, true, dwarvesArmy.getName());
                break;
            case "Elves":
                ElvesArmy elvesArmy = new ElvesArmy(16, (ElvesUnit) getRandomUnit("Elves"));
                smartFuncArmy(elvesArmy, true, elvesArmy.getName());
                break;
            case "Isengard":
                IsengardArmy isengardArmy = new IsengardArmy(7, (IsengardUnit) getRandomUnit("Isengard"));
                smartFuncArmy(isengardArmy, true, isengardArmy.getName());
                break;
            case "Mordor":
                MordorArmy mordorArmy = new MordorArmy(5, (MordorUnit) getRandomUnit("Mordor"));
                smartFuncArmy(mordorArmy, true, mordorArmy.getName());
                break;
        }
        checkConflict();
    }

    /**
     * This function saves information from the node as a string for JSON file.
     * @return string with information from node.
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
        String newline = "\n";
        if (!armyJSON.equals("")) {
            lineIndent = "    ";
            armyIndent = "\n";
        }
        if (!eventJSON.equals("")) {
            eventIndent = "\n";
            eventLine = "     ";
        }
        String s = "   {" + newline +
                indent + "\"Name\": \"" + name + "\"," + newline +
                indent + "\"Id\": " + id + "," + newline +
                indent + "\"Armies\": [" + armyIndent + armyJSON + lineIndent + "]," + newline +
                indent + "\"Events\": [" + eventIndent + eventJSON + eventLine + "]" + newline +
                "   }" + newline;
        return s;
    }
}
