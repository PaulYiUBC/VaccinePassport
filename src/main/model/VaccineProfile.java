package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;


import java.util.LinkedList;

// Represents a list of vaccines received by an individual with its own profile name
// Persistence functionality and methods implemented from JsonSerializationDemo
public class VaccineProfile {
    private String profileName;
    private final LinkedList<Vaccine> vaccineList;

    //REQUIRES: Individual's desired profile name (String)
    //EFFECTS: constructs new vaccine profile and empty list of vaccines
    public VaccineProfile(String newProfileName) {
        profileName = newProfileName;
        vaccineList = new LinkedList<>();

    }

    Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Name", profileName);
        json.put("Vaccine Profile", vaccinesToJson());
        return json;
    }

    // EFFECTS: returns vaccines in this profile as a JSON array
    private JSONArray vaccinesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Vaccine v : vaccineList) {
            jsonArray.put(v.toJson());
        }

        return jsonArray;
    }


    //EFFECTS: returns name (String) of vaccine profile
    public String getVaccineProfileName() {
        return this.profileName;

    }

    //REQUIRES: new vaccine profile name (String)
    //MODIFIES: this
    //EFFECTS: edits the vaccine profile name
    public void setProfileName(String s) {
        this.profileName = s;
    }

    //REQUIRES: vaccine record (Vaccine)
    //MODIFIES: this
    //EFFECTS: adds vaccine record to vaccination profile
    public void addVaccine(Vaccine newVaccine) {
        vaccineList.add(newVaccine);

    }

    //REQUIRES: vaccine record (Vaccine)
    //MODIFIES: this
    //EFFECTS: removes vaccine record from vaccination profile
    public void removeVaccine(Vaccine removedVaccine) {
        vaccineList.remove(removedVaccine);

    }

    //Requires: vaccine record (Vaccine)
    //EFFECTS: returns true if given vaccine record element is in vaccine profile
    public boolean containsVaccine(Vaccine v) {
        return this.vaccineList.contains(v);

    }

}
