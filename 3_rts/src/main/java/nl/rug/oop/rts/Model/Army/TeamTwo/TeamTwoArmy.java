package main.java.nl.rug.oop.rts.Model.Army.TeamTwo;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Army.Unit;

/**
 * This class is a super class for Isengard and Mordor armies.
 */
public class TeamTwoArmy extends Army implements Jsonise {
    /**
     * A class constructor.
     * @param numberOfUnits number of units in army.
     * @param unitType type of units in army.
     */
    public TeamTwoArmy(int numberOfUnits, Unit unitType) {
        super(numberOfUnits, unitType);
    }

    /**
     * This function returns JSON formating for team 2 armies.
     * @return JSON formating for team 2 armies
     */
    @Override
    public String getJSONData() {
        String indent = "       ";
        return "      {" + "\n" +
                indent + "\"Faction\": \"" + name + ", \n" +
                indent + "\"Team\": " + 2 + ", \n" +
                indent + "\"Units\": " + unitType.getJSONData() + "\n" +
                "      }" + "\n";
    }

    public String getName() {
        return name;
    }
}
