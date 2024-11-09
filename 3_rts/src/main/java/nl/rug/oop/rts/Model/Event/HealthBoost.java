package main.java.nl.rug.oop.rts.Model.Event;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Item;

import javax.swing.*;
import java.util.Random;

/**
 * This class implements event "HealthBoost".
 */
public class HealthBoost extends Events {

    /**
     * A class constructor.
     *
     * @param item item where event will take place
     */
    public HealthBoost(Item item) {
        super(item);
        this.name = "Healer Tower";
        this.description = "The army has met the healer. He granted your army more health!";
    }

    /**
     * This function implements the action that will be executed during this event.
     */
    @Override
    public void performAction() {
        for (Army army : armies) {
            Random random = new Random();
            int boost = random.nextInt(30);
            army.boostHealth(boost);
            JOptionPane.showMessageDialog(
                    null, "Event occurrence! " +
                            name + " has happened on " +
                            item.getName() + "\n" + description);
        }
    }
}
