public class RobotPawn extends Robot {
    private boolean premierCoup;
    private int nbmouvement;

    public RobotPawn(String name, int x, int y, String colourBody, World world) {
        super(name, x, y, colourBody, world);
        this.premierCoup = true; 
    }

    @Override
    public void avancer() {
        boolean moveValid = false;
        while (!moveValid) {
            int x = this.getX();
            int y = this.getY();

            if (nbmouvement >= 9) {
                System.out.println("Le pion a atteint sa limite.");
                return;
            }
            if (premierCoup) {
                // Premier coup de 2 cases
                y += 2;
            } else {

                y += 1;
            }
            // verif
            if (!World.isValidPosition(x, y) || getWorld().isPositionOccupied(x, y)) {
                System.out.println("Position occupée ou invalide, relance du mouvement.");
                return;
            } else {
                this.setX(x);
                this.setY(y);
                premierCoup = false;
                nbmouvement++;
                draw();
                System.out.println("nouvelle position (" + x + ", " + y + ").");
                moveValid = true;
            }
        }
    }
}
