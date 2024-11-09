package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.IsengardUnit;

/**
 * This is an Warg Rider unit of Isengard army.
 */
public class WRUnit extends IsengardUnit {

    /**
     * Constructor of the class.
     * @param damage int damage of the unit
     * @param health int health of the unit
     * @param unitName the unit name.
     */
    public WRUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Warg Rider";
    }
}
