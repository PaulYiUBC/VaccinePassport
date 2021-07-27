package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VaccineTest {

    private Vaccine testVaccine1;
    private Vaccine testVaccine2;
    private Vaccine testVaccine3;
    private Vaccine testVaccine4;
    private Vaccine testVaccine5;
    private Vaccine testVaccine6;

    @BeforeEach
    void runBefore() {
        testVaccine1 = new Vaccine("TestVaccine1", "2001-01-01");
        testVaccine2 = new Vaccine("TestVaccine2", "2002-03-03");
        testVaccine3 = new Vaccine("TestVaccine3", "2003-03-03");
        testVaccine4 = new Vaccine("TestVaccine4", "2004-04-04");
        testVaccine5 = new Vaccine("TestVaccine5", "2005-05-05");
        testVaccine6 = new Vaccine("TestVaccine6", "2006-06-06");

    }

    @Test
    void testGetVaccineType() {
        assertEquals("TestVaccine1", testVaccine1.getVaccineType());
        assertEquals("TestVaccine2", testVaccine2.getVaccineType());
        assertEquals("TestVaccine3", testVaccine3.getVaccineType());
        assertEquals("TestVaccine4", testVaccine4.getVaccineType());
    }

    @Test
    void testGetVaccineDate() {
        assertEquals("2001-01-01", testVaccine1.getVaccineDate());
        assertEquals("2002-02-02", testVaccine2.getVaccineDate());
        assertEquals("2003-03-03", testVaccine3.getVaccineDate());
        assertEquals("2004-04-04", testVaccine4.getVaccineDate());
    }

    @Test
    void testEditVaccineType() {
        testVaccine5.editVaccineType("TestVaccine5");
        assertEquals("TestVaccine5", testVaccine4.getVaccineType());

    }

    @Test
    void testEditVaccineDate() {
        testVaccine6.editVaccineDate("2006-06-06");
        assertEquals("2006-06-06", testVaccine6.getVaccineDate());
    }

}