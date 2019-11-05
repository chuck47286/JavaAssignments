/**
 * A class Aircraft has two field variables of passengerNUmber and maxSpeed respectively.
 * Both of field variables are of type int.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public class Aircraft {

    private int passengerNumber;
    private int maxSpeed;

    /**
     *
     * @param passengerNumber The passengerNumber of the Aircraft.
     * @param maxSpeed The maxSpeed of the Aircraft.
     */
    public Aircraft(int passengerNumber, int maxSpeed) {
        this.passengerNumber = passengerNumber;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Setter for the passengerNumber. The passengerNumber of the Aircraft is updated.
     * @param passengerNumber The new passengerNumber of the Aircraft.
     */
    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    /**
     * Setter for the maxSpeed. The maxSpeed of the Aircraft is updated.
     * @param maxSpeed The new maxSpeed of the Aircraft.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Getter for the passengerNumber.
     * @return The passengerNumber of the Aircraft is returned.
     */
    public int getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Getter for the maxSpeed.
     * @return The maxSpeed of the Aircraft is returned.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     *
     * @return A human readable description of the Aircraft in  form of
     * the two filed variables specifying it.
     */
    @Override
    public String toString() {
        return "Aircraft has " +
                "passengerNumber= " + passengerNumber +
                ", maxSpeed= " + maxSpeed ;
    }
}
