package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor.MordorUnit;

/**
 * This is an Orc Pikeman unit of Mordor army.
 */
public class OPUnit extends MordorUnit {

    /**
     * Constructor of the class.
     * @param damage int damage of the unit
     * @param health int health of the unit
     * @param unitName the unit name.
     */
    public OPUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Orc Pikeman";
    }
}
