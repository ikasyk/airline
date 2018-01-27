package me.ikasyk;

import me.ikasyk.aircraft.Aircraft;
import me.ikasyk.company.AirlineCompany;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Main class of application.
 */
public class Application {
    private static AirlineCompany company;
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        company = new AirlineCompany("Borispol");

        company.addAircraftsFromFile("aircrafts.xlsx");

        scanner = new Scanner(System.in);
        while (true) {
            helloConsole();
            int id = scanner.nextInt();

            if (id == 0) {
                break;
            }
            switch (id) {
                case 1:
                    totalCapacityConsole();
                    break;
                case 2:
                    carryingCapacityConsole();
                    break;
                case 3:
                    flightRangeConsole();
                    break;
                case 4:
                    fuelConsumptionConsole();
                    break;
            }
        }
    }

    /**
     * Displays menu.
     */
    private static void helloConsole() {
        StringBuilder sb = new StringBuilder();
        sb.append("What would you like to do?\n");
        sb.append("0. Exit.\n");
        sb.append("1. Show total capacity of aircrafts.\n");
        sb.append("2. Show carrying capacity of aircrafts.\n");
        sb.append("3. Display sorted aircrafts by flight range.\n");
        sb.append("4. Find airplanes corresponding to a given range of fuel consumption parameters.\n");
        System.out.println(sb.toString());
    }

    /**
     * Displays total capacity of each aircraft.
     */
    private static void totalCapacityConsole() {
        StringBuilder sb = new StringBuilder();
        Aircraft[] aircrafts = company.getAllAircrafts();

        for (Aircraft a : aircrafts) {
            sb.append(a.getName() + "\t\t" + a.getTotalCapacity() + "\n");
        }

        System.out.println(sb.toString());
    }

    /**
     * Displays carrying capacity of each aircraft.
     */
    private static void carryingCapacityConsole() {
        StringBuilder sb = new StringBuilder();
        Aircraft[] aircrafts = company.getAllAircrafts();

        for (Aircraft a : aircrafts) {
            sb.append(a.getName() + "\t\t" + a.getCarryingCapacity() + "\n");
        }

        System.out.println(sb.toString());
    }

    /**
     * Displays aircraft which fuel consumption is in current range.
     */
    private static void fuelConsumptionConsole() {
        System.out.println("Enter low and high thresholds:");
        double lowRange = scanner.nextDouble();
        double highRange = scanner.nextDouble();

        List<Aircraft> results = company.getInFuelConsumptionRange(lowRange, highRange);

        if (results.size() != 0) {
            for (Aircraft a : results) {
                System.out.println(a.getName() + "\t\t" + a.getFuelPerHour());
            }
        } else {
            System.out.println("Airplanes int this range are not found.");
        }
    }

    /**
     * Displays aircrafts ordered by flight range.
     */
    private static void flightRangeConsole() {
        List<Aircraft> results = company.getAircraftsSortedByFlightRange();

        for (Aircraft a : results) {
            System.out.println(a.getName() + "\t\t" + a.getFlightRange());
        }
    }


}
