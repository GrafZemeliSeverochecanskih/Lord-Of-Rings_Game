package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard.IsengardUnit;

/**
 * This is an Uruk-hai unit of Isengard army.
 */
public class UHUnit extends IsengardUnit {

    /**
     * Constructor of the class.
     * @param damage int damage of the unit
     * @param health int health of the unit
     * @param unitName the unit name.
     */
    public UHUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Uruk-hai";
    }
}
