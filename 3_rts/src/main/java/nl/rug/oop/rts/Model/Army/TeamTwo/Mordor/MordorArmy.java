package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Mordor;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.TeamTwoArmy;

import java.awt.*;

/**
 * This is a Mordor Army class.
 */
public class MordorArmy extends TeamTwoArmy {

    /**
     * Constructor of the class.
     * @param numberOfUnits number of recruits.
     * @param unitType type of unit.
     */
    public MordorArmy(int numberOfUnits, MordorUnit unitType) {
        super(numberOfUnits, unitType);
        color = Color.magenta;
        this.name = "Mordor";
    }

}
