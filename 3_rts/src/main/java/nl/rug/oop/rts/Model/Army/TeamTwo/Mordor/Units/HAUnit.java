package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.MordorUnit;

/**
 * This is a Haradrim archer unit of Mordor army.
 */
public class HAUnit extends MordorUnit {

    /**
     * Constructor of the class.
     * @param damage int damage of the unit
     * @param health int health of the unit
     * @param unitName the unit name.
     */
    public HAUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Haradrim archer";
    }
}
