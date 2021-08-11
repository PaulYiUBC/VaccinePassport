package persistence;


import model.Vaccine;
import model.VaccineProfile;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            VaccineProfile wr = new VaccineProfile("My work room");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            VaccineProfile vp = new VaccineProfile("My vaccine profile");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(vp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            vp = reader.read();
            assertEquals("My vaccine profile", vp.getVaccineProfileName());
            assertEquals(0, vp.numVaccines());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            VaccineProfile vp = new VaccineProfile("My vaccine profile");
            vp.addVaccine(new Vaccine("COVID-19", "2021-01-01", true ));
            vp.addVaccine(new Vaccine("MNR", "2020-02-02", false));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(vp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            vp = reader.read();
            assertEquals("My vaccine profile", vp.getVaccineProfileName());
            List<Vaccine> vaccines = vp.getVaccines();
            assertEquals(2, vaccines.size());
            checkVaccine("COVID-19", "2021-01-01", true,  vaccines.get(0));
            checkVaccine("MMR", "2020-02-02", false, vaccines.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}