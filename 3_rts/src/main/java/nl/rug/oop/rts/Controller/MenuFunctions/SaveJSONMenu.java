package main.java.nl.rug.oop.rts.Controller.MenuFunctions;

import main.java.nl.rug.oop.rts.Model.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class takes care of implementing the logic for saving the file.
 */
public class SaveJSONMenu implements ActionListener {
    private Graph graph;

    /**
     * Constructor of the class.
     * @param graph graph to save.
     */
    public SaveJSONMenu(Graph graph) {
        this.graph = graph;
    }

    /**
     * Triggers the appearance of the file selection menu and saves the graph in json format.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        int choice = jFileChooser.showSaveDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File jsonFile = jFileChooser.getSelectedFile();
            if (!jsonFile.getName().endsWith(".json")) {
                jsonFile = new File(jsonFile.getPath() + ".json");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {
                writer.write(graph.getJSONData());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
