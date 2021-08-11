package persistence;

import org.json.JSONObject;

// Persistence functionality and methods implemented from JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
