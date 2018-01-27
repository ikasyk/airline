package me.ikasyk.company;

import me.ikasyk.aircraft.Aircraft;
import me.ikasyk.aircraft.Airplane;
import me.ikasyk.aircraft.MultiEngineAirplane;
import me.ikasyk.aircraft.SingleEngineAirplane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.spi.Measurement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Airline company.
 */
public class AirlineCompany {
    private String name;
    private List<Aircraft> aircrafts = new ArrayList<Aircraft>();

    /**
     * Creates airline company.
     * @param name name of company.
     */
    public AirlineCompany(String name) {
        this.name = name;
    }

    /**
     * Adds aircraft to the list.
     * @param aircraft airplane that will to be added to the list.
     */
    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    /**
     * Returns aircraft list ordered by flight range.
     * @return aircraft list.
     */
    public List<Aircraft> getAircraftsSortedByFlightRange() {
        return aircrafts.stream()
                .sorted(Comparator.comparingDouble(a -> (double) a.getFlightRange().getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Returns aircraft list in specific range of fuel consumption.
     * @param from the beginning of the range.
     * @param to the end of range.
     * @return list of aircrafts.
     */
    public List<Aircraft> getInFuelConsumptionRange(double from, double to) {
        return aircrafts.stream()
                .filter(a -> Double.compare((double)a.getFuelPerHour().getValue(), to) == -1)
                .filter(a -> Double.compare(from, (double)a.getFuelPerHour().getValue()) == -1)
                .collect(Collectors.toList());
    }

    public void addAircraftsFromFile(String file) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();

            String name = currentRow.getCell(0).getStringCellValue();
            int engines = (int) currentRow.getCell(1).getNumericCellValue();
            double totalCapacity = currentRow.getCell(2).getNumericCellValue();
            double carryingCapacity = currentRow.getCell(3).getNumericCellValue();
            double flightRange = currentRow.getCell(4).getNumericCellValue();
            double fuelConsumption = currentRow.getCell(5).getNumericCellValue();

            Aircraft airplane;
            if (engines > 1) {
                airplane = new MultiEngineAirplane(name, engines, totalCapacity, carryingCapacity, flightRange, fuelConsumption);
            } else {
                airplane = new SingleEngineAirplane(name, totalCapacity, carryingCapacity, flightRange, fuelConsumption);
            }

            addAircraft(airplane);
        }
    }

    public int getAircraftsCount() {
        return aircrafts.size();
    }

    public Aircraft[] getAllAircrafts() {
        Aircraft[] array = new Aircraft[aircrafts.size()];
        return aircrafts.toArray(array);
    }
}
