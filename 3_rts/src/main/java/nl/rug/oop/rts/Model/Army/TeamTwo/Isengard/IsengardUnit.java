package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.TeamTwoUnit;

/**
 * This is an Isengard Unit, taht belongs to the team 2.
 */
public class IsengardUnit extends TeamTwoUnit {

    /**
     * Constructor of the class.
     * @param damage int damage of one unit.
     * @param health int health of the unit.
     * @param unitName name of the unit.
     */
    public IsengardUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.recruits = 7;
    }
}
