import java.util.Random;

public class Reine extends Robot {
    private static final String[] DIRECTIONS = {"droite", "gauche", "haut", "bas", "diagonal-haut-droite", "diagonal-haut-gauche", "diagonal-bas-droite", "diagonal-bas-gauche"};
    private Random random = new Random();

    public Reine(String name, int x, int y, String colourBody, World world) {
        super(name, x, y, colourBody, world);
    }

    public void avancer() {
        boolean moveValid = false;

        while (!moveValid) {
            String direction = genererDirectionAleatoire();
            int n = genererNombreDeCasesAleatoire();
            moveValid = avancerR(direction, n); 
        }
    }

    public String genererDirectionAleatoire() {
        int index = random.nextInt(DIRECTIONS.length);
        return DIRECTIONS[index];
    }

    public int genererNombreDeCasesAleatoire() {
        return random.nextInt(11) + 1; 
    }

    public boolean avancerR(String direction, int n) {
        int x = this.getX();
        int y = this.getY();

        for (int i = 0; i < n; i++) {
            switch (direction.toLowerCase()) {
                case "droite":
                    x++; 
                    break;
                case "gauche":
                    x--;
                    break;
                case "haut":
                    y--;
                    break;
                case "bas":
                    y++;
                    break;
                case "diagonal-haut-droite":
                    x++;  
                    y--;
                    break;
                case "diagonal-haut-gauche":
                    x--; 
                    y--;
                    break;
                case "diagonal-bas-droite":
                    x++;
                    y++;
                    break;
                case "diagonal-bas-gauche":
                    x--; 
                    y++;
                    break;
                default:
                    System.out.println("Direction non valide");
                    return false;
            }

            if (!World.isValidPosition(x, y) || getWorld().isPositionOccupied(x, y)) {
                System.out.println("Position occupée ou invalide, relance du mouvement.");
                return false; 
            }

            this.setX(x);
            this.setY(y);
            draw();
        }
        return true; 
    }
}
