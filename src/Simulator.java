/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the simulation class that runs the actual simulation.
 * <p>
 * This class contains one single static method that takes parameters from the driver class
 * and prints the simulation results.
 */


import java.util.ArrayList;

public class Simulator {


    /**
     * This is the only method in the class that takes the parameters from the driver class and
     * displays the simulation results.
     *
     * @param floors      - The total number of floors in the building.
     * @param elevators   - The total number of elevators in the building.
     * @param totalTime   - The amount of time the simulation will run for (in seconds).
     * @param probability - The probablity of an request that will occur.
     * @throws InterruptedException     - This is the exception that was thrown in the Java Queues API while dequeue() was called.
     * @throws IllegalArgumentException - This exception is thrown if any incorrect value entered by the user.
     */
    public static void simulate(int floors, int elevators, int totalTime, double probability) throws InterruptedException, IllegalArgumentException {

        //Exception handling
        if (floors <= 1)
            throw new IllegalArgumentException("Total Floors must be grater than 1");
        if (elevators <= 0)
            throw new IllegalArgumentException("Elevators must be grater than 0");
        if (totalTime <= 0)
            throw new IllegalArgumentException("Time units must be grater than 0");

        //Simulation variables
        RequestQueue queue = new RequestQueue();
        BooleanSource Probability = new BooleanSource(probability);
        ArrayList<Elevator> elevatorList = new ArrayList<>();

        int totalWaitTime = 0;
        int requests = 0;
        double averageWaitTime;

        // This is the loop that generates the ArrayList of Elevators
        for (int i = 0; i < elevators; i++) {
            Elevator elevator = new Elevator();
            elevatorList.add(elevator);
        }

        // The simulation loop starts here. Runs from [0, totalTime)
        for (int i = 0; i < totalTime; i++) {

            //Checks if the event has occurred, i.e. a request has come with a valid probablity
            // Then it enqueues() it onto the RequestQueue.
            if (Probability.requestArrived()) {
                Request request = new Request(floors);
                request.setTimeEntered(i);
                queue.enqueue(request);
            }

            //This is the loop that checks if an elevator is available and dequeue() it to the elevator.
            // This loop also moves the elevators from source to destination and updates its status
            // along with time.
            for (int j = 0; j < elevators; j++) {
                if (elevatorList.get(j).getElevatorState() == Elevator.IDLE && !queue.isEmpty()) {
                    elevatorList.get(j).request = (Request) queue.dequeue();
                }
                if (elevatorList.get(j).request != null) {
                    if (elevatorList.get(j).getCurrentFloor() != elevatorList.get(j).request.getSourceFloor() && elevatorList.get(j).getElevatorState() != Elevator.TO_DESTINATION) {
                        elevatorList.get(j).setElevatorState(Elevator.TO_SOURCE);
                        if (elevatorList.get(j).request.getSourceFloor() > elevatorList.get(j).getCurrentFloor())
                            elevatorList.get(j).setCurrentFloor(elevatorList.get(j).getCurrentFloor() + 1);
                        else
                            elevatorList.get(j).setCurrentFloor(elevatorList.get(j).getCurrentFloor() - 1);
                    } else {
                        if (elevatorList.get(j).getCurrentFloor() == elevatorList.get(j).request.getSourceFloor())
                            requests++;
                        if (elevatorList.get(j).getElevatorState() == Elevator.TO_SOURCE)
                            totalWaitTime += i - elevatorList.get(j).request.getTimeEntered();

                        elevatorList.get(j).setElevatorState(Elevator.TO_DESTINATION);

                        if (elevatorList.get(j).getCurrentFloor() == elevatorList.get(j).request.getDestinationFloor()) {
                            elevatorList.get(j).setElevatorState(Elevator.IDLE);
                            elevatorList.get(j).request = null;
                        } else {
                            if (elevatorList.get(j).request.getDestinationFloor() > elevatorList.get(j).getCurrentFloor())
                                elevatorList.get(j).setCurrentFloor(elevatorList.get(j).getCurrentFloor() + 1);
                            else
                                elevatorList.get(j).setCurrentFloor(elevatorList.get(j).getCurrentFloor() - 1);
                        }
                    }
                }

            }
        }


        //Calculating the average time.
        averageWaitTime = (double) totalWaitTime / requests;

        //Printing statistics.
        System.out.println();
        System.out.println("Total wait time: " + totalWaitTime);
        System.out.println("Total Requests: " + requests);
        System.out.printf("Average waiting time: %.2f seconds", averageWaitTime);


    }
}
