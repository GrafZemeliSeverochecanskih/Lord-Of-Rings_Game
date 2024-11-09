package main.java.nl.rug.oop.rts.Model.Army;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract super class that implements an army.
 */
public abstract class Army implements Jsonise {
    /**
     * The name of the army.
     */
    protected String name;
    /**
    * The number of units in the army.
    */
    protected int numberOfUnits;
    /**
     * The unitType of the Unit.
     */
    protected Unit unitType;
    /**
     * The list of units in the army.
     */
    protected List<Unit> units;
    /**
     * The start node of the army.
     */
    protected Node start;
    /**
     * The color of the army.
     */
    protected Color color;

    /**
     * A class constructor.
     * @param numberOfUnits number of units in army
     * @param unitType type of units in army
     */
    public Army(int numberOfUnits, Unit unitType) {
        this.name = "";
        this.color = Color.gray;
        this.units = new ArrayList<>();
        this.numberOfUnits = numberOfUnits;
        this.unitType = unitType;
        for (int i = 0; i < numberOfUnits; i++) {
            units.add(unitType);
        }

    }

    /**
     * This function increases the number of units in army by given amount.
     * @param amount amount of units to be added
     */
    public void increaseUnitNum(int amount) {
        if (amount == -1) {
            this.numberOfUnits += unitType.recruits;
        } else {
            this.numberOfUnits += amount;
        }
    }

    /**
     * This function decreases the number of units in army by given amount.
     * @param amount amount of units to be deleted
     */
    public void decreaseUnitNum(int amount) {
        if (amount == -1) {
            this.numberOfUnits -= unitType.recruits;
        } else {
            this.numberOfUnits -= amount;
        }
    }

    /**
     * This function boosts health of all units in army by given amount.
     * @param boost amount of health points to be added
     */
    public void boostHealth(int boost) {
        int currHealth = unitType.getHealth();
        this.unitType.setHealth(currHealth + boost);
    }

    /**
     * This function decreases health of all units in army by given amount.
     * @param boost amount of health points to be removed
     */
    public void boostDamage(int boost) {
        int currDamage = unitType.getDamage();
        this.unitType.setDamage(currDamage + boost);
    }

    public String getName() {
        return name;
    }

    public String getNumUnits() {
        return String.valueOf(numberOfUnits);
    }

    /**
     * A start node setter.
     * @param node start node
     */
    public void setStartNode(Node node) {
        this.start = node;
    }

    public Node getStartNode() {
        return this.start;
    }

    public Color getColor() {
        return this.color;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public Unit getUnitType() {
        return this.unitType;
    }

    /**
     * A number of units setter.
     * @param number number of units that will be in army
     */
    public void setNumberOfUnits(int number) {
        this.numberOfUnits = number;
    }
}

