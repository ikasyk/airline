package me.ikasyk.aircraft;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.spi.QuantityFactory;

/**
 * Classification class for airplanes.
 */
public abstract class Airplane implements Aircraft {
    protected Quantity<Mass> totalCapacity;
    protected Quantity<Mass> carryingCapacity;
    protected Quantity<Length> flightRange;
    protected Quantity<Volume> fuelPerHour;

    private int engines;

    /**
     * Defines airplane.
     * @param engines count of engines.
     */
    public Airplane(int engines) {
        this.engines = engines;
    }

    public Quantity<Mass> getTotalCapacity() {
        return totalCapacity;
    }

    public Quantity<Mass> getCarryingCapacity() {
        return carryingCapacity;
    }

    public Quantity<Length> getFlightRange() {
        return flightRange;
    }

    public Quantity<Volume> getFuelPerHour() {
        return fuelPerHour;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "totalCapacity=" + totalCapacity +
                ", carryingCapacity=" + carryingCapacity +
                ", flightRange=" + flightRange +
                ", fuelPerHour=" + fuelPerHour +
                ", engines=" + engines +
                '}';
    }
}
