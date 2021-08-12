package persistence;


import model.Vaccine;
import model.VaccineProfile;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
// Persistence functionality and methods implemented from JsonSerializationDemo

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads vaccine profile from file and returns it;
    // throws IOException if an error occurs reading data from file
    public VaccineProfile read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseVaccineProfile(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses vaccine profile from JSON object and returns it
    private VaccineProfile parseVaccineProfile(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        VaccineProfile vp = new VaccineProfile(name);
        addVaccines(vp, jsonObject);
        return vp;
    }

    // MODIFIES: vp
    // EFFECTS: parses vaccines from JSON object and adds them to vaccine profile
    private void addVaccines(VaccineProfile vp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("vaccineList");
        for (Object json : jsonArray) {
            JSONObject nextVaccine = (JSONObject) json;
            addVaccine(vp, nextVaccine);
        }
    }

    // MODIFIES: vp
    // EFFECTS: parses vaccine from JSON object and adds it to vaccine profile
    private void addVaccine(VaccineProfile vp, JSONObject jsonObject) {
        String name = jsonObject.getString("type");
        String vaccineDate = jsonObject.getString("date");
        Boolean booster = jsonObject.getBoolean("booster");
        Vaccine vaccine = new Vaccine(name, vaccineDate, booster);
        vp.addVaccine(vaccine);
    }
}
