package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VaccineProfileTest {
    private VaccineProfile testProfile1;
    private VaccineProfile testProfile2;
    private VaccineProfile testProfile3;
    private VaccineProfile testProfile4;

    private Vaccine testVaccine1;
    private Vaccine testVaccine2;
    private Vaccine testVaccine3;
    private Vaccine testVaccine4;

    @BeforeEach
    void runBefore() {
        testVaccine1 = new Vaccine("TestVaccine1", "2001-01-01", true);
        testVaccine2 = new Vaccine("TestVaccine2", "2002-02-02", true);
        testVaccine3 = new Vaccine("TestVaccine3", "2003-03-03", true);
        testVaccine4 = new Vaccine("TestVaccine4", "2004-04-04", false);


        testProfile1 = new VaccineProfile("Tester1");
        testProfile2 = new VaccineProfile("Tester2");
        testProfile3 = new VaccineProfile("Tester3");
        testProfile4 = new VaccineProfile("Tester4");


        testProfile1.addVaccine(testVaccine1);
        testProfile2.addVaccine(testVaccine1);
        testProfile2.addVaccine(testVaccine2);
        testProfile3.addVaccine(testVaccine1);
        testProfile3.addVaccine(testVaccine2);
        testProfile3.addVaccine(testVaccine3);
        testProfile4.addVaccine(testVaccine4);

    }

    @Test
        // Testing getting a profile
    void testGetProfileName() {
        assertEquals("Tester1", testProfile1.getProfileName());
        assertEquals("Tester2", testProfile2.getProfileName());
        assertEquals("Tester3", testProfile3.getProfileName());
        assertEquals("Tester4", testProfile4.getProfileName());

    }

    @Test
        // Testing editing a profile name
    void testSetProfileName() {
        assertEquals("Tester1", testProfile1.getProfileName());
        testProfile1.setProfileName("Parent1");
        assertEquals("Parent1", testProfile1.getProfileName());
        testProfile1.setProfileName("Tester1");
        assertEquals("Tester1", testProfile1.getProfileName());
    }


    @Test
        // testing adding vaccine to profile
    void testAddVaccine() {
        testProfile1.addVaccine(testVaccine2);
        assertTrue(testProfile1.containsVaccine(testVaccine1));
        assertTrue(testProfile1.containsVaccine(testVaccine2));
        assertFalse(testProfile1.containsVaccine(testVaccine3));

    }

    @Test
        // testing removing vaccine from profile
    void testRemoveVaccine() {
        testProfile1.removeVaccine(testVaccine1);
        assertFalse(testProfile1.containsVaccine(testVaccine1));

        testProfile3.removeVaccine((testVaccine1));
        assertFalse(testProfile3.containsVaccine(testVaccine1));
        assertTrue(testProfile3.containsVaccine(testVaccine2));
        assertTrue(testProfile3.containsVaccine(testVaccine3));
    }

    @Test
        // testing whether a vaccine element exists in the profile list
    void testContainsVaccine() {
        assertTrue(testProfile1.containsVaccine(testVaccine1));
        assertFalse(testProfile1.containsVaccine(testVaccine2));

        assertTrue(testProfile2.containsVaccine(testVaccine1));
        assertTrue(testProfile2.containsVaccine(testVaccine2));
    }

}