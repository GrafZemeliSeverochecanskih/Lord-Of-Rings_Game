package main.java.nl.rug.oop.rts.Model.Army.TeamTwo.Isengard;

import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.TeamTwoArmy;

import java.awt.*;

/**
 * This is the IsengardArmy class.
 */
public class IsengardArmy extends TeamTwoArmy {

    /**
     * Constructor of the class.
     * @param numberOfUnits number of recruits.
     * @param unitType type of unit.
     */
    public IsengardArmy(int numberOfUnits, IsengardUnit unitType) {
        super(numberOfUnits, unitType);
        color = Color.ORANGE;
        this.name = "Isengard";
    }

}
