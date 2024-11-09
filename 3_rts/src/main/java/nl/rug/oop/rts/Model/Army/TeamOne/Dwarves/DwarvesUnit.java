package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneUnit;

/**
 * This class creates a unit of dwarves.
 */
public class DwarvesUnit extends TeamOneUnit {
    /**
     * A class constructor.
     *
     * @param damage   unit damage
     * @param health   unit health
     * @param unitName unit name
     */
    public DwarvesUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.recruits = 18;
    }
}
