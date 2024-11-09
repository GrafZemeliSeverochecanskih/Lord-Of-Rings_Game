package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneUnit;

/**
 * This class creates a unit of elves.
 */
public class ElvesUnit extends TeamOneUnit {
    /**
     * A class constructor.
     *
     * @param damage   unit damage
     * @param health   unit health
     * @param unitName unit name
     */
    public ElvesUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.recruits = 16;
    }
}
