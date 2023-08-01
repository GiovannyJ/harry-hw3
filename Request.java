import java.util.Random;

public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    public Request(int numFloors) {
        Random rand = new Random();
        sourceFloor = rand.nextInt(numFloors) + 1;
        destinationFloor = rand.nextInt(numFloors) + 1;
        timeEntered = -1;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}