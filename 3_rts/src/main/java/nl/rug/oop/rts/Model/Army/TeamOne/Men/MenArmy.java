package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneArmy;

import java.awt.*;

/**
 * This class creates a men army.
 */
public class MenArmy extends TeamOneArmy {
    /**
     * A class constructor.
     * @param numberOfUnits number of units in army
     * @param unitType type of units in army
     */
    public MenArmy(int numberOfUnits, MenUnit unitType) {
        super(numberOfUnits, unitType);
        this.name = "Men";
        color = Color.BLUE;
    }

}
