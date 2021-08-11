package persistence;


import model.Vaccine;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkVaccine(String vaccineType, String vaccineDate, boolean b, Vaccine vaccine) {
        assertEquals(vaccineType, vaccine.getVaccineType());
        assertEquals(vaccineDate, vaccine.getVaccineDate());
        assertEquals(b, vaccine.checkBooster());

    }
}
