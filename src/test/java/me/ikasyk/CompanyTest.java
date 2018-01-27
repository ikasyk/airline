package me.ikasyk;

import me.ikasyk.aircraft.Aircraft;
import me.ikasyk.company.AirlineCompany;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class CompanyTest {
    private static AirlineCompany company;

    @BeforeClass
    public static void initialize() throws IOException {
        company = new AirlineCompany("Test");

        try {
            company.addAircraftsFromFile("test.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileReader() {
        Assert.assertEquals( "Aircrafts count are not same.", 3L, company.getAircraftsCount());
    }

    @Test
    public void orderedFlightRange() {
        List<Aircraft> results = company.getAircraftsSortedByFlightRange();

        Assert.assertEquals("1984 AEROSTAR 700P", results.get(0).getName());
        Assert.assertEquals("GRUMMAN G44A SUPER WIDGEON", results.get(1).getName());
        Assert.assertEquals("Mooney M20J 201", results.get(2).getName());
    }

    @Test
    public void fuelConsumptionRange() {
        List<Aircraft> results = company.getInFuelConsumptionRange(300.0, 650.0);

        Assert.assertEquals("Results length is not correct.", 2, results.size());

        Assert.assertTrue(results.stream().anyMatch(aircraft -> aircraft.getName().equals("1984 AEROSTAR 700P")));
        Assert.assertTrue(results.stream().anyMatch(aircraft -> aircraft.getName().equals("GRUMMAN G44A SUPER WIDGEON")));
        Assert.assertFalse(results.stream().anyMatch(aircraft -> aircraft.getName().equals("Mooney M20J 201")));


    }
}
