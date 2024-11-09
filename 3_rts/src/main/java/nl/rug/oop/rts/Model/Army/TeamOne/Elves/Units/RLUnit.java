package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Elves.ElvesUnit;

/**
 * This class creates a Rivendell Lancer unit.
 */
public class RLUnit extends ElvesUnit {
    /**
     * A class constructor.
     * @param damage unit damage
     * @param health unit health
     * @param unitName unit name
     */
    public RLUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Rivendell Lancer";
    }

}
