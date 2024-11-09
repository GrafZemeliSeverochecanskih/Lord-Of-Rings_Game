package main.java.nl.rug.oop.rts.Model.Event;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Item;

import javax.swing.*;
import java.util.Random;

/**
 * This class implements event "Covenstead".
 */
public class Covenstead extends Events {
    /**
     * A class constructor.
     *
     * @param item item where created event will take place
     */
    public Covenstead(Item item) {
        super(item);
        this.name = "Covenstead";
        this.description = "Oh! You encountered the witch gathering. This is never good. " +
                "Their have cursed you! Now your army has less health and damage!";
    }

    /**
     * This function implements the action that will be executed during this event.
     */
    @Override
    public void performAction() {
        for (Army army : armies) {
            Random random = new Random();
            int healthCurse = random.nextInt(30);
            int damageCurse = random.nextInt(6);
            JOptionPane.showMessageDialog(
                    null, "Event occurrence! " +
                            name + " has happened on " +
                            item.getName() + "\n" + description);
            army.boostHealth(-healthCurse);
            army.boostDamage(-damageCurse);
            break;

        }
    }
}
