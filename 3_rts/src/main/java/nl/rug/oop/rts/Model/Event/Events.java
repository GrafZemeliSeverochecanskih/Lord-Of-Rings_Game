package main.java.nl.rug.oop.rts.Model.Event;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Item;

import java.util.List;

/**
 * This is a superclass of all events.
 */
public class Events implements Jsonise {
    /**
     * Active state of the event.
     */
    protected boolean active;
    /**
     * The name of the name.
     */
    protected String name;
    /**
     * The item on which the event is happening.
     */
    protected Item item;
    /**
     * The list of armies in the event.
     */
    protected List<Army> armies;
    /**
     * The description of the event.
     */
    protected String description;

    /**
     * A class constructor.
     * @param item item where event will take place.
     */
    public Events(Item item) {
        this.name = "Event";
        this.item = item;
        this.armies = item.getArmies();
        active = false;
        this.description = "Basic event";
    }

    /**
     * This function performs the action of event.
     */
    public void performAction() {
        System.out.println("Custom action performed");
    }

    public Item getItem() {
        return item;
    }

    public String getName() {
        return this.name;
    }

    public String getJSONData() {
        String intend = "      ";
        return intend + "{ \n" + intend + " " + "\"Name\": \"" + name + "\"" + "\n" + intend + "}" + "\n";
    }
}
