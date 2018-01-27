package me.ikasyk.aircraft;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

/**
 * Multi-Engine class of airplanes
 */
public final class MultiEngineAirplane extends Airplane {
    private final String name;

    /**
     * Defines multi-engine airplane.
     * @param name name of airplane
     * @param engines count of engines
     * @param _totalCapacity total airplane capacity
     * @param _carryingCapacity carrying capacity
     * @param _flightRange flight range
     * @param _fuelPerHour fuel consumption per hour
     */
    public MultiEngineAirplane(String name, int engines, double _totalCapacity, double _carryingCapacity, double _flightRange, double _fuelPerHour) {
        super(engines);
        this.name = name;

        totalCapacity = Quantities.getQuantity(_totalCapacity, Units.KILOGRAM);
        carryingCapacity = Quantities.getQuantity(_carryingCapacity, Units.KILOGRAM);
        flightRange = Quantities.getQuantity(_flightRange, Units.METRE);
        fuelPerHour = Quantities.getQuantity(_fuelPerHour, Units.LITRE);

    }

    /**
     * Returns name of airplane.
     * @return name of airplane.
     */
    public String getName() {
        return name;
    }
}
