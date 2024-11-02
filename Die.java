
import java.util.Random;

public class Die {
    private Random random;
    private int numberOfFaces;

    

    public Die(int numberOfFaces) {
        this.random = new Random();
        this.numberOfFaces = numberOfFaces;

    }

   

    public int roll() {
        return random.nextInt(numberOfFaces) + 1;
    }
}