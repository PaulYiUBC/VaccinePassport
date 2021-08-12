package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a list of vaccines received by an individual with its own profile name
// Persistence functionality and methods implemented from JsonSerializationDemo
public class VaccineProfile implements Writable {
    private String name;
    private ArrayList<Vaccine> vaccineList;

    //REQUIRES: Individual's desired profile name (String)
    //EFFECTS: constructs new vaccine profile and empty list of vaccines
    public VaccineProfile(String name) {
        this.name = name;
        vaccineList = new ArrayList<>();

    }

    public ArrayList<Vaccine> filterProfile() {
        ArrayList<Vaccine> subList = new ArrayList<Vaccine>();
        for (Vaccine v : vaccineList) {
            if (v.checkBooster()) {
                subList.add(v);
            }
        }
        return subList;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("vaccineList", vaccinesToJson());
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
    public String getProfileName() {
        return name;

    }

    // EFFECTS: returns an unmodifiable list of vaccines in this vaccine profile
    public List<Vaccine> getVaccines() {
        return Collections.unmodifiableList(vaccineList);
    }

    // EFFECTS: returns number of thingies in this workroom
    public int numVaccines() {
        return vaccineList.size();
    }

    //REQUIRES: new vaccine profile name (String)
    //MODIFIES: this
    //EFFECTS: edits the vaccine profile name
    public void setProfileName(String s) {
        this.name = s;
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
