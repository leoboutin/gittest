import java.util.Scanner;
import java.util.Random;
public class rook extends Robot {
    private Random random;

    public rook(String name, int x, int y, String colourBody, World world) {
        super(name, x, y, colourBody, world);
        random = new Random();
    }

    public void avancer() {
        int newX = getX();
        int newY = getY();
        int direction = random.nextInt(4);
        int distance = random.nextInt(5);
        //  nouvelle position selon la direction
        switch (direction) {
    case 0:
        if (newX + distance <= MAX_POSITION && newY + distance <= MAX_POSITION) {
            newX += distance;
            
        }
        break;
    case 1:
        if (newX - distance >= MIN_POSITION && newY + distance <= MAX_POSITION) {
            
            newY += distance;
        }
        break;
    case 2:
        if (newX + distance <= MAX_POSITION && newY - distance >= MIN_POSITION) {
        
            newY -= distance;
        }
        break;
    case 3:
        if (newX - distance >= MIN_POSITION && newY - distance >= MIN_POSITION) {
            newX -= distance;
        }
        break;
    default:
        System.out.println("Direction invalide. Utilisez 'haut-droite', 'haut-gauche', 'bas-droite' ou 'bas-gauche'.");
        return;
}

        setX(newX);
        setY(newY); 
        // nouvelle position sur le canvas
        draw(); 

        System.out.println("Le robot s'est déplacé en direction de " + direction + " sur une distance de " + distance + ".");
        System.out.println("Nouvelle position : (" + newX + ", " + newY + ")");
    }
    public void getPosition() {
        int x = getX();
        int y = getY();
        System.out.println("Position actuelle du robot : (" + x + ", " + y + ")");
    }
}







