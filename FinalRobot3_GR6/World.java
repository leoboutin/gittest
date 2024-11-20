import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class World {
    private List<Robot> robots;
    private Canvas canvas;
    private int size;

    public World(int size) {
        this.size = size;
        robots = new ArrayList<>();
        canvas = Canvas.getCanvas();
        canvas.setVisible(true);
    }

    public void addRobot(Robot robot, int x, int y) {
        if (isValidPosition(x, y) && !isPositionOccupied(x, y)) {
            robot.setX(x);
            robot.setY(y);
            robots.add(robot);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid or occupied position (" + x + ", " + y + ").");
        }
    }

    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x<=11 && y <=11;
    }

    public boolean isPositionOccupied(int x, int y) {
        for (Robot robot : robots) {
            if (robot.getX() == x && robot.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public void moveRobot(String robotName) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotName)) {
                robot.avancer();
                return;
            }
        }
        System.out.println("Robot not found: " + robotName);
    }

    public void moveAllRobots() {
        for (int turn = 0; turn < 10; turn++) {
            for (Robot robot : robots) {
                robot.avancer();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

