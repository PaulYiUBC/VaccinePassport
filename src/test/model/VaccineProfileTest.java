package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VaccineProfileTest {
    private VaccineProfile testProfile1;
    private VaccineProfile testProfile2;
    private VaccineProfile testProfile3;
    private VaccineProfile testProfile4;

    private Vaccine testVaccine1;
    private Vaccine testVaccine2;

    @BeforeEach
    void runBefore() {
        testVaccine1 = new Vaccine("TestVaccine1", "2001-01-01");
        testVaccine2 = new Vaccine("TestVaccine2", "2002-03-03");

        testProfile1 = new VaccineProfile("Tester1");
        testProfile2 = new VaccineProfile("Tester2");
        testProfile3 = new VaccineProfile("Tester3");
        testProfile4 = new VaccineProfile("Tester4");

        testProfile1.addVaccine(testVaccine1);
        testProfile2.addVaccine(testVaccine1);
        testProfile2.addVaccine(testVaccine2);

    }

    @Test
    // Testing getting a profile
    void testGetProfileName() {
        assertEquals("Tester1", testProfile1.getVaccineProfileName());
        assertEquals("Tester2", testProfile2.getVaccineProfileName());
        assertEquals("Tester3", testProfile3.getVaccineProfileName());
        assertEquals("Tester4", testProfile4.getVaccineProfileName());

    }

    @Test
    // testing adding vaccine to profile
    void testAddVaccine() {
        assertTrue(testProfile1.addVaccine(testVaccine2));
    }

    @Test
    // testing removing vaccine from profile
    void testRemoveVaccine() {
        assertTrue(testProfile2.removeVaccine(testVaccine1));
    }

}

