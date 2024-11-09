package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.TeamTwoUnit;

/**
 * This is a Mordor Unit, taht belongs to the team 2.
 */
public class MordorUnit extends TeamTwoUnit {

    /**
     * Constructor of the class.
     * @param damage int damage of one unit.
     * @param health int health of the unit.
     * @param unitName name of the unit.
     */
    public MordorUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
        this.recruits = 5;
    }
}
