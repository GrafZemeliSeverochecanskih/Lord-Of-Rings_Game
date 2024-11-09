package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.DwarvesUnit;

/**
 * This class creates a Phalanx unit.
 */
public class PUnit extends DwarvesUnit {
    /**
     * A class constructor.
     * @param damage unit damage
     * @param health unit health
     * @param unitName unit name
     */
    public PUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Phalanx";
    }
}
