import java.util.Random;

public class Bishop extends Robot {
    private Random random;

    private static final int MAX_POSITION = 11;
    private static final int MIN_POSITION = 0;

    public Bishop(String name, int x, int y, String colourBody, World world) {
        super(name, x, y, colourBody, world);
        random = new Random();
    }

    // Méthode pour déplacer le fou en diagonale et relancer un mouvement si la position est invalide ou occupée
    public void avancer() {
        boolean moveValid = false;

        while (!moveValid) {
            int newX = getX();
            int newY = getY();
            int direction = random.nextInt(4); // Choisit une direction diagonale au hasard
            int distance = random.nextInt(5) + 1; // Distance aléatoire entre 1 et 5

            // Calcule la nouvelle position en fonction de la direction
            switch (direction) {
                case 0:
                    if (newX + distance <= MAX_POSITION && newY + distance <= MAX_POSITION) {
                        newX += distance;
                        newY += distance;
                    }
                    break;
                case 1:
                    if (newX - distance >= MIN_POSITION && newY + distance <= MAX_POSITION) {
                        newX -= distance;
                        newY += distance;
                    }
                    break;
                case 2:
                    if (newX + distance <= MAX_POSITION && newY - distance >= MIN_POSITION) {
                        newX += distance;
                        newY -= distance;
                    }
                    break;
                case 3:
                    if (newX - distance >= MIN_POSITION && newY - distance >= MIN_POSITION) {
                        newX -= distance;
                        newY -= distance;
                    }
                    break;
                default:
                    System.out.println("Direction invalide.");
                    return;
            }

            // Vérifie si la nouvelle position est valide et non occupée
            if (World.isValidPosition(newX, newY) && !getWorld().isPositionOccupied(newX, newY)) {
                setX(newX);
                setY(newY);
                draw(); // Met à jour la position sur le canvas
                System.out.println("Le fou s'est déplacé à la position (" + newX + ", " + newY + ").");
                moveValid = true; 
            } else {
                System.out.println("error.retry");
            }
        }
    }

    public void getPosition() {
        int x = getX();
        int y = getY();
        System.out.println("Position du robot : (" + x + ", " + y + ")");
    }
}
