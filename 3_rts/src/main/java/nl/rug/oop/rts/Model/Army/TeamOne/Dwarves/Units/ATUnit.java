package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Dwarves.DwarvesUnit;

/**
 * This class creates an Axe Thrower unit.
 */
public class ATUnit extends DwarvesUnit {
    /**
     * A class constructor.
     * @param damage unit damage
     * @param health unit health
     * @param unitName unit name
     */
    public ATUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Axe Thrower";
    }
}
