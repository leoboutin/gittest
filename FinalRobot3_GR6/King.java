import java.util.Random;

public class King extends Robot {
    private Random random;

    // Constructeur pour le roi
    public King(String name, int x, int y, String colourBody, World world) {
        super(name, x, y, colourBody, world);  // Appel au constructeur de la classe mère Robot
        this.random = new Random(); // Initialisation de Random
    }

    // Méthode pour afficher les options de déplacement du roi
    public void afficherDirections() {
        System.out.println("Options de déplacement pour le roi :");
        System.out.println("0 - Aller à droite");
        System.out.println("1 - Aller vers le bas");
        System.out.println("2 - Aller à gauche");
        System.out.println("3 - Aller vers le haut");
        System.out.println("4 - Diagonale haut-droite");
        System.out.println("5 - Diagonale bas-droite");
        System.out.println("6 - Diagonale bas-gauche");
        System.out.println("7 - Diagonale haut-gauche");
    }

    // Méthode pour déplacer le roi dans une direction aléatoire jusqu'à trouver une case libre
    public void moveKingRandom() {
        boolean moveValid = false;

        while (!moveValid) { 
            int directionAleatoire = random.nextInt(8);  // Génère un nombre aléatoire entre 0 et 7
            System.out.println("Le roi tente de se déplacer dans la direction : " + directionAleatoire);
            int newX = getX();
            int newY = getY();
            // Choisir la direction du mouvement
            switch (directionAleatoire) {
                case 0: // Aller à droite
                    newX += 1;
                    break;
                case 1: // Aller vers le bas
                    newY += 1;
                    break;
                case 2: // Aller à gauche
                    newX -= 1;
                    break;
                case 3: // Aller vers le haut
                    newY -= 1;
                    break;
                case 4: // Diagonale haut-droite
                    newX += 1;
                    newY -= 1;
                    break;
                case 5: // Diagonale bas-droite
                    newX += 1;
                    newY += 1;
                    break;
                case 6: // Diagonale bas-gauche
                    newX -= 1;
                    newY += 1;
                    break;
                case 7: // Diagonale haut-gauche
                    newX -= 1;
                    newY -= 1;
                    break;
                default:
                    System.out.println("Direction non valide");
                    return; // Quitte la méthode si dir invalide
            }

            if (!World.isValidPosition(newX, newY) || getWorld().isPositionOccupied(newX, newY)) {
                System.out.println("Position occupée ou invalide, relance du mouvement.");
            } else {
                setX(newX);
                setY(newY);
                draw();
                System.out.println("Le roi s'est déplacé à la position (" + newX + ", " + newY + ").");
                moveValid = true;
            }
        }
    }

    @Override
    public void avancer() {
        moveKingRandom();
    }
}
