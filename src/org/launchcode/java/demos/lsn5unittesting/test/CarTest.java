package org.launchcode.java.demos.lsn5unittesting.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.java.demos.lsn5unittesting.main.Car;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

public class CarTest {
    private Car test_car;

    @Before
    public void createCarObject() {
        test_car = new Car("Toyota", "Prius", 10, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGasOverfillException() {
        test_car.setGasTankLevel(11);
    }

    @Test
    public void testGasTankAfterExceedingTankRange() {
        test_car.drive(501);
        assertEquals(0, test_car.getGasTankLevel(), 0.001);
    }

    @Test
    public void testGasTankAfterDriving() {
        test_car.drive(50);
        assertEquals(9, test_car.getGasTankLevel(), 0.001);
    }
}
