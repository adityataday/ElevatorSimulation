/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the Driver class for the Elevator simulation.
 * <p>
 * It prompts the user to enter the parameters for:
 * 1) Probablity of a request to occur.
 * 2) Total floors in the building.
 * 3) Total no of elevators in the building.
 * 4) The total time the simulation should run for.
 * <p>
 * These parameters are then passed to the simulation class.
 * <p>
 * This class also checks for all exceptions that are thrown in the entire program
 * and prints the message.
 */


import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {

        //Local variables
        Scanner userInput = new Scanner(System.in);
        double probability;
        int floors, elevators, totalTime;

        //Simulator object instantiated
        Simulator simulator = new Simulator();

        try {
            System.out.printf("Welcome to the Elevator simulation!\n\n");

            System.out.printf("Please enter the probability of arrival for Requests: ");
            probability = userInput.nextDouble();
            System.out.printf("Please enter the number of floors: ");
            floors = userInput.nextInt();
            System.out.printf("Please enter the number of elevators: ");
            elevators = userInput.nextInt();
            System.out.printf("Please enter the length of the simulation (in time units): ");
            totalTime = userInput.nextInt();

            simulator.simulate(floors, elevators, totalTime, probability);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
