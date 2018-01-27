package me.ikasyk.aircraft;

import javafx.util.Pair;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

/**
 * Common interface of transport unit.
 */
public interface Aircraft {
    /**
     * Retrieves name of aircraft.
     * @return name of aircraft.
     */
    String getName();

    /**
     * Counts the carrying capacity.
     * @return carrying capacity.
     */
    Quantity<Mass> getCarryingCapacity();

    /**
     * Counts the total capacity.
     * @return total capacity.
     */
    Quantity<Mass> getTotalCapacity();

    /**
     * Counts the flight range.
     * @return flight range.
     */
    Quantity<Length> getFlightRange();

    /**
     * Counts the fuel consumption.
     * @return fuel consumption quantity.
     */
    Quantity<Volume> getFuelPerHour();
}
