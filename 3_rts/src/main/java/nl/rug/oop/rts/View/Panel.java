package main.java.nl.rug.oop.rts.View;

import main.java.nl.rug.oop.rts.Controller.Interfaces.Observer;
import main.java.nl.rug.oop.rts.Model.Army.Army;
import main.java.nl.rug.oop.rts.Model.Edge;
import main.java.nl.rug.oop.rts.Model.Graph;
import main.java.nl.rug.oop.rts.Model.Item;
import main.java.nl.rug.oop.rts.Model.Node;
import main.java.nl.rug.oop.rts.util.TextureLoader;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

/**
 * This is the Panel class.
 * The nodes and edges are represented using its logic.
 */
public class Panel extends JPanel implements Observer {
    private Graph graph;

    /**
     * This is teh constructor of the Panel class. The default size is 200*200 pixels.
     *
     * @param graph contains all the data about existing nodes and edges.
     */
    public Panel(Graph graph) {
        this.graph = graph;
        this.setSize(200, 200);
    }

    /**
     * Draws an armies for a single item.
     *
     * @param item item to draw an army for.
     * @param x    coordinate (start drawing army)
     * @param y    coordinate (start drawing army)
     * @param g    Graphics
     */
    public void armyPerItem(Item item, int x, int y, Graphics g) {
        for (Army army : item.getArmies()) {
            Image image = TextureLoader.getInstance().getTexture(
                    Path.of("main/images/factions/" + army.getName().toLowerCase() + ".png"), 30, 30);
            g.drawImage(image, x, y, 25, 25, null);
            x += 15;
            if (item instanceof Edge) {
                y += 15;
            }
        }
    }

    /**
     * This method draw the armies on nodes and edges.
     *
     * @param g Graphics.
     */
    private void drawArmy(Graphics g) {
        for (Item item : graph.getItems()) {
            if (!item.getArmies().isEmpty()) {
                int x;
                int y;
                if (item instanceof Node) {
                    x = ((Node) item).getXPos();
                    y = ((Node) item).getYPos();
                } else {
                    Node one = ((Edge) item).getNodeOne();
                    Node two = ((Edge) item).getNodeTwo();
                    x = ((one.getXPos() + 15) + (two.getXPos() + 15)) / 2;
                    y = (int) (((one.getYPos() + (20 * 1.5)) + (two.getYPos() + (20 * 1.5))) / 2);
                }
                armyPerItem(item, x, y, g);
            }
        }
        if (graph.getBattle()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This is the function that draws the edges.
     *
     * @param g Graphics used to draw the elements.
     */
    public void drawEdges(Graphics g) {
        Image image = TextureLoader.getInstance().getTexture("mapTexture", this.getWidth(), this.getHeight());
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        for (Edge edge : graph.getEdges()) {
            int radius = 30;
            int xOne = edge.getNodeOne().getXPos() + radius;
            int yOne = (int) (edge.getNodeOne().getYPos() + (radius * 1.5));
            int xTwo = edge.getNodeTwo().getXPos() + radius;
            int yTwo = (int) (edge.getNodeTwo().getYPos() + (radius * 1.5));
            g.setColor(edge.getColor());
            g.drawLine(xOne, yOne, xTwo, yTwo);
        }
    }

    /**
     * This is the function that draws nodes and displays the text on them.
     *
     * @param g Graphics used to draw the elements.
     */
    public void drawNodes(Graphics g) {
        for (Node node : graph.getNodes()) {
            int x = node.getXPos();
            int y = node.getYPos();
            int radius = 30;

            g.setColor(node.getColor());
            g.fillOval(x, y, 2 * radius, 3 * radius);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 15));
            g.setColor(Color.BLACK);
            Image image = TextureLoader.getInstance().getTexture("node3", x, y);
            g.drawImage(image, x, y, 2 * radius, 3 * radius, null);

            int textWidth = g.getFontMetrics().stringWidth(node.getName());
            int textHeight = g.getFontMetrics().getHeight();

            int textY = (int) (y + (radius * 1.5) + textHeight / 4);
            int textX = (x + radius) - textWidth / 2;

            g.drawString(node.getName(), textX, textY);
        }
    }

    /**
     * This function draws the entire panel and objects in it.
     * This happens by calling the secondary functions above.
     *
     * @param g Graphics of the panel used to draw objects.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        drawEdges(g);
        drawNodes(g);
        drawArmy(g);
        revalidate();
    }

    /**
     * This is the implementation of the Observer interface.
     * Function invokes the redrawing of the panel when changes are made to the graph (model).
     */
    @Override
    public void triggerUpdate() {
        paintComponent(getGraphics());
    }
}
