package model;

import java.util.LinkedList;

// Represents a list of vaccines received by an individual with its own profile name
public class VaccineProfile {
    private String profileName;
    private LinkedList<Vaccine> vaccineList;

    //REQUIRES: Individual's desired profile name (String)
    //EFFECTS: instantiates new vaccine profile
    public VaccineProfile(String newProfileName) {
        profileName = newProfileName;
        vaccineList = new LinkedList<>();

    }

    //REQUIRES: Vaccine Profile
    //EFFECTS: returns name (String) of vaccine profile
    public String getVaccineProfileName() {
        return profileName;

    }

    //REQUIRES: vaccine record (Vaccine)
    //MODIFIES: this
    //EFFECTS: adds vaccine record to vaccination profile and returns true; otherwise false
    public boolean addVaccine(Vaccine newVaccine) {
        vaccineList.add(newVaccine);
        return true;

    }

    //REQUIRES: vaccine record (Vaccine)
    //MODIFIES: this
    //EFFECTS: removes vaccine record from vaccination profile and return true; otherwise false if not found
    public boolean removeVaccine(Vaccine removedVaccine) {
        vaccineList.remove(removedVaccine);
        return true;

    }

}
