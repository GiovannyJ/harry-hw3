import java.util.ArrayList;

public class Simulator {
	public static void simulate(double probability, int numFloors, int numElevators, int simulationLength) {
        int totalTime = 0;
        int totalRequests = 0;

        BooleanSource booleanSource = new BooleanSource(probability);
        RequestQueue requestQueue = new RequestQueue();

        ArrayList<Elevator> elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator());
        }

        for (int currentTime = 0; currentTime < simulationLength; currentTime++) {
            // Check for a new request
            if (booleanSource.requestArrived()) {
                Request newRequest = new Request(numFloors);
                newRequest.setTimeEntered(currentTime);
                requestQueue.add(newRequest);
            }

            // Assign requests to idle elevators
            for (Elevator elevator : elevators) {
                if (elevator.getElevatorState() == Elevator.IDLE && !requestQueue.isEmpty()) {
                    Request nextRequest = requestQueue.dequeue();
                    if (nextRequest != null) {
                        elevator.setRequest(nextRequest);
        
                        if (elevator.getCurrentFloor() < nextRequest.getSourceFloor()) {
                            elevator.setElevatorState(Elevator.TO_SOURCE);
                        } else if (elevator.getCurrentFloor() > nextRequest.getSourceFloor()) {
                            elevator.setElevatorState(Elevator.TO_DESTINATION);
                        }
                    }
                }
            }         
            

            // Move elevators
            for (Elevator elevator : elevators) {
                if (elevator.getRequest() != null) {
                    if (elevator.getElevatorState() == Elevator.TO_SOURCE) {
                        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                    } else if (elevator.getElevatorState() == Elevator.TO_DESTINATION) {
                        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                    }

                    // Handle reaching the source floor
                    if (elevator.getCurrentFloor() == elevator.getRequest().getSourceFloor()) {
                        elevator.setElevatorState(Elevator.TO_DESTINATION);
                    }

                    // Handle reaching the destination floor
                    if (elevator.getCurrentFloor() == elevator.getRequest().getDestinationFloor()) {
                        elevator.setElevatorState(Elevator.IDLE);
                        int waitingTime = currentTime - elevator.getRequest().getTimeEntered();
                        totalTime += waitingTime;
                        totalRequests++;
                    }
                }
            }
        }

        double averageWaitingTime = (double) totalTime / totalRequests;
        System.out.println("Total Wait Time: " + String.format("%d", totalTime));
        System.out.println("Total Request: " + String.format("%d", totalRequests));
        System.out.println("Average Waiting Time: " + String.format("%.2f", averageWaitingTime));
    }

}