public class Cavalier extends Robot {
    private static final int MAX_POSITION = 11;

    public Cavalier(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
    }

    private void moveCavalierWithRetry() {
        int[][] possibleMoves = {
            {2, 1}, {2, -1},  // 2 steps in x, 1 step in y (East or West)
            {-2, 1}, {-2, -1}, // 2 steps in x, 1 step in y (West)
            {1, 2}, {1, -2},  // 1 step in x, 2 steps in y (North or South)
            {-1, 2}, {-1, -2} // 1 step in x, 2 steps in y (South)
        };

        boolean moveValid = false;

        while (!moveValid) {
            int[] move = possibleMoves[(int) (Math.random() * possibleMoves.length)];

            int x = this.getX();
            int y = this.getY();

            int newX = x + move[0];
            int newY = y + move[1];

            if (World.isValidPosition(newX, newY) && !getWorld().isPositionOccupied(newX, newY)) {
                setX(newX);
                setY(newY);
                moveValid = true; 
                System.out.println("Le cavalier s'est déplacé à (" + newX + ", " + newY + ").");
            } else {
                System.out.println("Position occupée ou invalide. Retenter un autre mouvement.");
            }
        }

        canvasRobot.drawRobot(getX(), getY());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void avancer() {
        moveCavalierWithRetry();
    }
}
