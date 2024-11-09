package main.java.nl.rug.oop.rts.Model.Battle;

import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Edge;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is responsible for battle simulations.
 */
public class Simulations {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph
     */
    public Simulations(Graph graph) {
        this.graph = graph;
    }

    /**
     * Runs the simulation.
     */
    public void runSimulation() {
        Battle battle = new Battle(graph);
        battle.battleArmies(true);
        moveOnEdge();
        graph.setBattle(true);
        graph.notifyAllObservers();
        graph.setBattle(false);
        battle.battleArmies(false);
        moveOnNode();
        battle.battleArmies(true);
        graph.setActiveEvent(null);
    }

    /**
     * This function moves army from node to one randomly selected edge.
     */
    public void moveOnEdge() {
        List<Army> toDel = new ArrayList<>();
        for (Node node : graph.getNodes()) {
            for (Army army : node.getArmies()) {
                Random random = new Random();
                int max = node.getEdges().size();
                if (!node.getEdges().isEmpty()) {
                    Edge edge = node.getEdges().get(random.nextInt(max));
                    edge.addArmy(army);
                    edge.checkConflict();
                    toDel.add(army);
                }
            }
            // removing separately, risk of concurrent modification error
            for (Army army : toDel) {
                node.getArmies().remove(army);
            }
        }
    }

    /**
     * This function goes through all edges in graph and moves all armies to nodes.
     */
    public void moveOnNode() {
        List<Army> toDel = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            if (!edge.getArmies().isEmpty()) {
                for (Army army : edge.getArmies()) {
                    if (edge.getNodeOne() == army.getStartNode()) {
                        army.setStartNode(edge.getNodeTwo());
                        edge.getNodeTwo().addArmy(army);
                        edge.getNodeTwo().checkConflict();
                    } else if (edge.getNodeTwo() == army.getStartNode()) {
                        army.setStartNode(edge.getNodeOne());
                        edge.getNodeOne().addArmy(army);
                        edge.getNodeOne().checkConflict();
                    }
                    toDel.add(army);
                }
                for (Army army : toDel) {
                    edge.getArmies().remove(army);
                }
            }
        }
    }
}
