package main.java.nl.rug.oop.rts.Model.Army;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Jsonise;

/**
 * This is an abstract super class that implements a unit.
 */
public abstract class Unit implements Jsonise {
    /**
     * The damage of the unit.
     */
    protected int damage;
    /**
     * The health of the unit.
     */
    protected int health;
    /**
     * The name of the unit.
     */
    protected String name;
    /**
     * The unitname of the unit.
     * Type (LWUnit, etc.)
     */
    protected String unitName;
    /**
     * The number of recruits in the unit.
     */
    protected int recruits;

    /**
     * A class constructor.
     * @param damage   unit damage
     * @param health   unit health
     * @param unitName unit name
     */
    public Unit(int damage, int health, String unitName) {
        this.damage = damage;
        this.health = health;
        this.unitName = unitName;
        this.recruits = 10;
    }

    public int getRecruits() {
        return this.recruits;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    /**
     * A health setter.
     * @param health value of health to be set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * A damage setter.
     * @param damage value of damage that will be set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
