/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the class that generates the probablity for the simulation.
 */

public class BooleanSource {

    private double probability;

    /**
     * This is the constructor for class which checks the value of the probablity
     * entered by the user and then sets the value of probablity if it is valid.
     *
     * @param p is the probablity value entered by the user.
     * @throw IllegalArugumentException if the value is not between 0.00 - 1.00
     */
    public BooleanSource(double p) {
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException("The probability must be between 0.00 - 1.00");
        probability = p;
    }

    /**
     * This is the method that informs the simulator if probablity is correctly generated.
     *
     * @return true if the probablity is correctly generated.
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }
}
