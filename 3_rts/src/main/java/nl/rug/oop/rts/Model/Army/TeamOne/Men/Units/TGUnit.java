package main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.Units;

import main.java.nl.rug.oop.rts.Model.Army.TeamOne.Men.MenUnit;

/**
 * This class creates a Tower Guard unit.
 */
public class TGUnit extends MenUnit {
    /**
     * A class constructor.
     * @param damage unit damage
     * @param health unit health
     * @param unitName unit name
     */
    public TGUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.name = "Tower Guard";
    }
}
