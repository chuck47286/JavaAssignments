/**
 * A class Aeroplane is the subclass of the Aircraft and it has an additional filed variable
 * fuelConsumption of type double.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public class Aeroplane extends Aircraft {

    private double fuelConsumption;

    /**
     * @param passengerNumber The passengerNumber of the Aircraft.
     * @param maxSpeed        The maxSpeed of the Aircraft.
     */
   /* public Aeroplane(int passengerNumber, int maxSpeed) {
        super(passengerNumber, maxSpeed);
    }*/

    /**
     *
     * @param passengerNumber The passengerNumber of the Aeroplane.
     * @param maxSpeed The maxSpeed of the Aeroplane.
     * @param fuelConsumption The fuelConsumption of the Aeroplane.
     */
    public Aeroplane(int passengerNumber, int maxSpeed, double fuelConsumption) {
        super(passengerNumber, maxSpeed);
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Getter for the fuelConsumption of the Aeroplane.
     * @return The fuelConsumption of the Aeroplane is returned.
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Setter for the fuelConsumption. The fuelConsumption is updated.
     * @param fuelConsumption The new fuelConsumption of the Aeroplane.
     */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     *
     * @return A human readable description of the Aeroplane in form of
     *          the three field variables specifying it.
     */
    @Override
    public String toString() {
        return "Aeroplane has " +
                "fuelConsumption= " + fuelConsumption +
                 ", and "+ super.toString();
    }
}
