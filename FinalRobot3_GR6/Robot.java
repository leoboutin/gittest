
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.lang.Object.*;
import java.lang.NumberFormatException.*; 
/**
 * Write a description of class Robot here.
 *
 * @author 
 * @version 
 */

public abstract class Robot {
    protected String name;
    protected int xPosition;
    protected int yPosition;
    protected CanvasRobot canvasRobot;
    protected World world;
    
    protected static final int MIN_NAME_LENGTH = 3;
    protected static final int MIN_POSITION = 0;
    protected static final int MAX_POSITION = 11;
    protected int direction;

    public Robot(String name, int initialX, int initialY, String colourBody, World world) {
        this.name = name;
        this.xPosition = initialX;
        this.yPosition = initialY;
        this.canvasRobot = new CanvasRobot(colourBody);
        this.canvasRobot.drawRobot(xPosition, yPosition);
        this.world = world;
        world.addRobot(this,initialX, initialY);
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.xPosition;
    }

    public void setX(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public void setY(int yPosition) {
        this.yPosition = yPosition;
    }
    
    public CanvasRobot getCanvasRobot() {
        return canvasRobot; 
    }
    
    public void draw() {
    // Assuming getCanvasRobot() returns the CanvasRobot object that is drawing the robot
    CanvasRobot canvasRobot = getCanvasRobot();
    canvasRobot.drawRobot(xPosition, yPosition); // Redraw robot at new position
    }

        // Méthode pour récupérer le monde
    public World getWorld() {
        return this.world;
    }
    
    // Each specific robot will implement its own move method.
    public abstract void avancer();
}

