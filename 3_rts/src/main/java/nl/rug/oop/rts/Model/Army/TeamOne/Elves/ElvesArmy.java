package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneArmy;

import java.awt.*;

/**
 * This class creates an army of elves.
 */
public class ElvesArmy extends TeamOneArmy {
    /**
     * A class constructor.
     * @param numberOfUnits number of units in army
     * @param unitType type of units in army
     */
    public ElvesArmy(int numberOfUnits, ElvesUnit unitType) {
        super(numberOfUnits, unitType);
        color = Color.green;
        this.name = "Elves";
    }
}
