package main.java.nl.rug.oop.rts.Model.Army.TeamTwo;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Army.Unit;

/**
 * The team two class.
 */
public class TeamTwoUnit extends Unit implements Jsonise {

    /**
     * Constructor of the class.
     * @param damage damage of the army member.
     * @param health health of the health member.
     * @param unitName the unit name
     */
    public TeamTwoUnit(int damage, int health, String unitName) {
        super(damage, health, unitName);
    }

    /**
     * Get the JSON formatted army.
     * @return string of the JSON format.
     */
    public String getJSONData() {
        String indent = "         ";
        String newline = "\n";
        return newline + "        {" + newline +
                indent + "\"Name\": \"" + unitName + "," + newline +
                indent + "\"Health\": " + health + "," + newline +
                indent + "\"Damage\": " + damage + "," + newline +
                indent + "\"Recruits\": " + recruits + newline +
                "        }";
    }
}
