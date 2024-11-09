package main.java.nl.rug.oop.rts.Model.Event;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Item;

import javax.swing.*;
import java.util.Random;

/**
 * This class implements event "Hurricane".
 */
public class Hurricane extends Events {
    /**
     * A class constructor.
     *
     * @param item item where event will take place
     */
    public Hurricane(Item item) {
        super(item);
        this.name = "Hurricane";
        this.description = "Wshh...The wind has blown away some recruits! " +
                "Don't worry yet! The rest managed to catch their weapons. " +
                "Now your units are stronger!";
    }

    /**
     * This function implements the action that will be executed during this event.
     */
    @Override
    public void performAction() {
        for (Army army : armies) {
            Random random = new Random();
            int killedAllies = random.nextInt(army.getNumberOfUnits() - 1);
            army.decreaseUnitNum(killedAllies);
            int lostDamage = killedAllies * army.getUnitType().getDamage();
            try {
                int boost = lostDamage / army.getNumberOfUnits();
                army.boostDamage(boost);
                JOptionPane.showMessageDialog(
                        null, "Event occurrence! " +
                                name + " has happened on " +
                                item.getName() + "\n" + description);
            } catch (ArithmeticException e) {
                System.err.println(e);
            }
        }
    }

}
