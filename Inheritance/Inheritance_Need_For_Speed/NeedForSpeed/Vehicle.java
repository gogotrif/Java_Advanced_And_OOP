package NeedForSpeed;

public class Vehicle {
    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption=DEFAULT_FUEL_CONSUMPTION;
    }
    public void drive(double kilometers){
        double remainingFuel = this.getFuel() - (kilometers * this.getFuelConsumption());
        if(remainingFuel>=0){
            this.setFuel(remainingFuel);
        }

    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    /*•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
	fuelConsumption –double
	fuel – double
	horsePower – int
	Getters and Setters for the fields
 */
}