package main.java.nl.rug.oop.rts.Model.Battle;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Army.TeamOne.TeamOneArmy;
import main.java.nl.rug.oop.rts.Model.Event.Events;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Item;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class implements battle.
 */
public class Battle {
    private Graph graph;
    private List<Army> teamOneArmies;
    private List<Army> teamTwoArmies;

    /**
     * A class constructor.
     * @param graph graph were battles take place
     */
    public Battle(Graph graph) {
        this.graph = graph;
        teamOneArmies = new ArrayList<>();
        teamTwoArmies = new ArrayList<>();
    }

    /**
     * This function verifies if list with winners contains all winners.
     * @param winners list with winner
     */
    private void notBattled(List<Army> winners) {
        if (!teamOneArmies.isEmpty()) {
            for (Army army : teamOneArmies) {
                if (!winners.contains(army)) {
                    winners.add(army);
                }
            }
        } else if (!teamTwoArmies.isEmpty()) {
            for (Army army : teamTwoArmies) {
                if (!winners.contains(army)) {
                    winners.add(army);
                }
            }
        }
    }

    /**
     * This function simulates the battle.
     * @return winners
     */
    private List<Army> battleSimulation() {
        List<Army> winners = new ArrayList<>();
        while (!teamOneArmies.isEmpty() && !teamTwoArmies.isEmpty()) {
            Army toa = teamOneArmies.get(0);
            Army tta = teamTwoArmies.get(0);
            int damageOne = calcEstDam(toa);
            int damageTwo = calcEstDam(tta);
            int healthOne = calcEstHealth(toa);
            int healthTwo = calcEstHealth(tta);
            int one_damage = Math.min(damageOne, healthTwo);
            int two_damage = Math.min(damageTwo, healthOne);

            int one_size = toa.getNumberOfUnits() - (two_damage / toa.getUnitType().getHealth());
            int two_size = tta.getNumberOfUnits() - (one_damage / tta.getUnitType().getHealth());

            double aliveRatioOne = (double) one_size / toa.getUnitType().getRecruits();
            double aliveRatioTwo = (double) two_size / tta.getUnitType().getRecruits();

            if (aliveRatioOne > aliveRatioTwo) {
                toa.setNumberOfUnits(one_size);
                if (!winners.contains(toa)) {
                    winners.add(toa);
                }
                teamTwoArmies.remove(0);
            } else {
                tta.setNumberOfUnits(two_size);
                if (!winners.contains(tta)) {
                    winners.add(tta);
                }
                teamOneArmies.remove(0);
            }
        }
        notBattled(winners);
        return winners;

    }

    /**
     * This function divides armies in two list depending on to which team they belong.
     * @param itemList all armies that are within a node or an edge
     */
    private void divideArmies(List<Item> itemList) {
        for (Item item : itemList) {
            List<Army> toDel = new ArrayList<>();
            if (item.getConflict()) {
                for (Army army : item.getArmies()) {
                    if (army instanceof TeamOneArmy) {
                        teamOneArmies.add(army);
                    } else {
                        teamTwoArmies.add(army);
                    }
                    toDel.add(army);
                }
                List<Army> winners = battleSimulation();
                for (Army deadArmy : toDel) {
                    item.getArmies().remove(deadArmy);
                }
                for (Army winner : winners) {
                    item.getArmies().add(winner);
                }
            }
            item.checkConflict();
            Random random = new Random();
            int chance = random.nextInt(0, 2);
            if (chance == 0) {
                if (!item.getEvents().isEmpty()) {
                    int eventIdx = random.nextInt(item.getEvents().size());
                    Events event = item.getEvents().get(eventIdx);
                    event.performAction();
                    graph.setActiveEvent(event);
                }
            }

        }
    }

    /**
     * This function divides all units in two array depending on their teams.
     * @param isNode indicates whether a current battle is happening on a node, or on an edge.
     */
    public void battleArmies(boolean isNode) {
        List data = null;
        if (!isNode) {
            data = graph.getEdges();
        } else {
            data = graph.getNodes();
        }
        divideArmies(data);
        graph.notifyAllObservers();

    }

    /**
     * This function calculates estimated army damage.
     * @param army army which damage should be calculated
     * @return estimated damage of an army
     */
    private int calcEstDam(Army army) {
        return army.getNumberOfUnits() * army.getUnitType().getDamage();
    }

    /**
     * This function calculates estimated army health.
     * @param army army which health should be calculated
     * @return estimated health of an army
     */
    private int calcEstHealth(Army army) {
        return army.getNumberOfUnits() * army.getUnitType().getHealth();
    }
}

