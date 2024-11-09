package main.java.nl.rug.oop.rts.Model.Army.TeamOne;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Army.Unit;

/**
 * This class is a super class for Men, Elves, and Dwarves units.
 */
public class TeamOneUnit extends Unit implements Jsonise {
    /**
     * A class constructor.
     *
     * @param damage   unit damage
     * @param health   unit health
     * @param unitName unit name
     */
    public TeamOneUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
    }

    /**
     * This function returns JSON formating for team one units.
     * @return JSON formating
     */
    @Override
    public String getJSONData() {
        String indent = "         ";
        return "\n" + "        {" + "\n" +
                indent + "\"Name\": \"" + unitName + ", \n" +
                indent + "\"Health\": " + health + ", \n" +
                indent + "\"Damage\": " + damage + ", \n" +
                indent + "\"Recruits\": " + recruits + "\n" +
                "        }";
    }
}
