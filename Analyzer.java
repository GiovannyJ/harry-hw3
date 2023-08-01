import java.util.Scanner;
public class Analyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Elevator simulator!\n");

        System.out.print("Enter the probability of a request being introduced per time unit: ");
        double probability = scanner.nextDouble();

        System.out.print("Enter the number of floors in the building: ");
        int numFloors = scanner.nextInt();

        System.out.print("Enter the number of elevators in the building: ");
        int numElevators = scanner.nextInt();

        System.out.print("Enter the length of the simulation in time units: ");
        int simulationLength = scanner.nextInt();

        // Check for valid range of inputs
        if (probability < 0 || probability > 1 || numFloors <= 1  || numElevators <= 0  || simulationLength <= 0) {
            System.out.println("Invalid input values. Please enter valid parameters.");
            scanner.close();
            return;
        }
        Simulator.simulate(probability, numFloors, numElevators, simulationLength);
        scanner.close();
    }
}