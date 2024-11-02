
import java.util.Random;

public class Die {
    private Random random;

    public Die() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }

    public int roll(int numberOfFaces) {
        return random.nextInt(numberOfFaces) + 1;
    }
}