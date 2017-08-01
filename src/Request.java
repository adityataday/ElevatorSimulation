/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the class where an request objects parameters are being defined.
 * <p>
 * The request object has 3 parameters. This class allows to set and get
 * these parameters.
 */
public class Request {

    private int sourceFloor;        // This is the integer that stores the source Floor value.
    private int destinationFloor;   // This is the integer that stores the destination floor value.
    private int timeEntered;        // This is the integer that stores.

    /**
     * This is the default constructor for the program which
     * sets a random source and destination floors based on
     * the totalFloors in the building i.e [1, totalFloors].
     *
     * @param totalFloors - The total floors that are in the building
     */
    public Request(int totalFloors) {
        sourceFloor = (int) (Math.random() * totalFloors + 1);
        destinationFloor = (int) (Math.random() * totalFloors + 1);
    }

    /**
     * This is the accessor method for source floor
     *
     * @return sourceFloor - it returns source floor that was set.
     */
    public int getSourceFloor() {

        return sourceFloor;
    }

    /**
     * This is the mutator method for the source floor
     *
     * @param sourceFloor - this parameter is used to set the source floor.
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * This is the accessor method for destination floor
     *
     * @return desitnationFloor- it returns destination floor that was set.
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * This is the mutator method for the destination floor
     *
     * @param destinationFloor - this parameter is used to set the destination floor.
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * This is the accessor method for timeEntered
     *
     * @return timeEntered is returned.
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * This is the mutator method for the timeEntered
     *
     * @param timeEntered - this parameter is used to set the time at which the request entered.
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}
