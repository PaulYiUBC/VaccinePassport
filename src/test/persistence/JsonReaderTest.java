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
            assertEquals("Your Profile", vp.getProfileName());
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
            assertEquals("Your Profile", vp.getProfileName());
            List<Vaccine> vaccines = vp.getVaccines();
            assertEquals(2, vaccines.size());
            checkVaccine("COVID-19", "2021-05-05", true, vaccines.get(0));
            checkVaccine("MMR", "2001-01-01", false, vaccines.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}