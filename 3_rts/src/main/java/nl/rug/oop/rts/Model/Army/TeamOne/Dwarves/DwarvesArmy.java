package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneArmy;

import java.awt.*;

/**
 * This class creates an army of dwarves.
 */
public class DwarvesArmy extends TeamOneArmy {
    /**
     * A class constructor.
     * @param numberOfUnits number of units in army
     * @param unitType type of units in army
     */
    public DwarvesArmy(int numberOfUnits, DwarvesUnit unitType) {
        super(numberOfUnits, unitType);
        color = Color.cyan;
        this.name = "Dwarves";
    }
}
