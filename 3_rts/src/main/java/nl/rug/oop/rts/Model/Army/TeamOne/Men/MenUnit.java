package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneUnit;

/**
 * This class creates a men unit.
 */
public class MenUnit extends TeamOneUnit {
    /**
     * A class constructor.
     * @param damage unit damage
     * @param health unit health
     * @param unitName unit name
     */
    public MenUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.recruits = 15;
    }

}
