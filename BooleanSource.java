import java.util.Random;

public class BooleanSource {
    private double probability;
    private Random random;

    public BooleanSource(double probability) {
        this.probability = probability;
        this.random = new Random(); // Uses the default seed based on the current time
    }

    public boolean requestArrived() {
        return random.nextDouble() < probability;
    }
}