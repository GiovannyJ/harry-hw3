public class Elevator {
    private int currentFloor;
    private int elevatorState;
    private Request request;

    // Constants for elevatorState
    public static final int IDLE = 0;
    public static final int TO_SOURCE = 1;
    public static final int TO_DESTINATION = 2;

    public Elevator() {
        this.currentFloor = 1;
        this.elevatorState = IDLE;
        this.request = null;
    }

    // Accessor and mutator methods
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int floor) {
        currentFloor = floor;
    }

    public int getElevatorState() {
        return this.elevatorState;
    }

    public void setElevatorState(int state) {
        elevatorState = state;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}