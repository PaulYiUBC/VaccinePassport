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
