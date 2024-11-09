package main.java.nl.rug.oop.rts.Model;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;
import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneArmy;
import main.java.nl.rug.oop.rts.Model.Army.TeamTwo.TeamTwoArmy;
import main.java.nl.rug.oop.rts.Model.Event.Events;
import main.java.nl.rug.oop.rts.Model.Event.HealthBoost;
import main.java.nl.rug.oop.rts.Model.Event.Covenstead;
import main.java.nl.rug.oop.rts.Model.Event.Hurricane;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class implements an abstraction of graph elements.
 */
public abstract class Item implements Jsonise {
    /**
     * The id of the item.
     */
    protected int id;
    /**
     * The name of the item.
     */
    protected String name;
    /**
     * The color of the item.
     */
    protected Color color;
    /**
     * The list of armies of the item.
     */
    protected List<Army> armies;
    /**
     * The conflicting armies of the item.
     */
    protected boolean conflict;
    /**
     * The list of the events of the item.
     */
    protected List<Events> events;

    /**
     * A constructor for the class.
     * @param id   id of item
     * @param name name of item
     */
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        armies = new ArrayList<>();
        this.color = Color.black;
        this.conflict = false;
        events = new ArrayList<>();
    }

    /**
     * This function traverses the events of item and after removes the needed one.
     * @param eventName name of event to be deleted
     */
    private void smartFuncEvent(String eventName) {
        Events found = null;
        for (Events x : events) {
            if (x.getName().equals(eventName)) {
                found = x;
            }
        }
        events.remove(found);
    }

    /**
     * This function adds given selected event to item.
     * @param option name of event
     */
    public void addEvent(String option) {
        switch (option) {
            case "Healer Tower":
                this.events.add(new HealthBoost(this));
                break;
            case "Covenstead":
                this.events.add(new Covenstead(this));
                break;
            case "Hurricane":
                this.events.add(new Hurricane(this));
                break;
        }
    }

    /**
     * This function deletes given event from item.
     * @param eventName an event to delete
     */
    public void deleteEvent(String eventName) {
        smartFuncEvent(eventName);
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return this.color;
    }

    public List<Events> getEvents() {
        return this.events;
    }

    /**
     * A color setter.
     *
     * @param color a color to be set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * A name setter.
     *
     * @param name a new name for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean getConflict() {
        return this.conflict;
    }

    public List<Army> getArmies() {
        return this.armies;
    }

    /**
     * This function adds army.
     * @param army to add
     */
    public void addArmy(Army army) {
        armies.add(army);
    }

    /**
     * This function checks if there are any conflicts within item.
     */
    public void checkConflict() {
        if (armies.size() >= 2) {
            Army one = armies.get(armies.size() - 2);
            Army two = armies.get(armies.size() - 1);
            if ((one instanceof TeamOneArmy && two instanceof TeamTwoArmy)
                    || (one instanceof TeamTwoArmy && two instanceof TeamOneArmy)) {
                this.conflict = true;
            }
        } else {
            this.conflict = false;
        }
    }

}
