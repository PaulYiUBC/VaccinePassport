package persistence;


import model.Vaccine;
import model.VaccineProfile;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            VaccineProfile wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyVaccineProfile() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            VaccineProfile vp = reader.read();
            assertEquals("My vaccine profile", vp.getVaccineProfileName());
            assertEquals(0, vp.numVaccines());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            VaccineProfile vp = reader.read();
            assertEquals("My vaccine profile", vp.getVaccineProfileName());
            List<Vaccine> vaccines = vp.getVaccines();
            assertEquals(2, vaccines.size());
            checkVaccine("COVID_19", "2021-01-01", true, vaccines.get(0));
            checkVaccine("saw", "2020-02-02", false, vaccines.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}