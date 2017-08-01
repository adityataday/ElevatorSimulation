/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the class that creates the elevator object for the simulation
 * <p>
 * The elevator object has 3 parameters. This class allows to set and get
 * these parameters.
 */

public class Elevator {

    static final int IDLE = 0;              //Final value if the elevator is idle.
    static final int TO_SOURCE = 1;        //Final value if the elevator is going to its source location.
    static final int TO_DESTINATION = 2;   //Final value if the elevator is going to its destination.

    private int currentFloor;             // This is an integer that indicates the current floor where the elevator is.
    private int elevatorState;            // This is an integer that indicates the current state of the elevator.
    Request request;                      // The elevator also contains a request object.

    /**
     * This is the constructor for the class where it sets
     * default values to its parameters.
     */
    public Elevator() {
        currentFloor = 1;
        elevatorState = IDLE;
        request = null;
    }

    /**
     * This is the accessor method to get the current floor the elevator is in.
     *
     * @return currentFloor - it returns source floor that was set.
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * This is the mutator method that sets the current elevator floor.
     *
     * @param currentFloor - this is the parameter that set the current floor value.
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * This is the accessor method to get the current state the elevator is in.
     *
     * @return elevatorState - it returns source floor that was set.
     */
    public int getElevatorState() {
        return elevatorState;
    }


    /**
     * This is the mutator method that sets the current elevator status.
     *
     * @param elevatorState - this is the parameter that set the current elevator state.
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }


}
