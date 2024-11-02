
import java.util.Random;

public class Die {

    private int numberOfFaces;

    public Die(int numberOfFaces) {

        this.numberOfFaces = numberOfFaces;

    }

    public int roll() {
        Random random = new Random();
        return random.nextInt(numberOfFaces) + 1;
    }
}