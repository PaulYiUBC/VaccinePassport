package model;


import org.json.JSONObject;
import persistence.Writable;

// Represents a vaccine record having a vaccine type and date of vaccination
public class Vaccine implements Writable {
    private String vaccineType;  // tracks vaccine type
    private String vaccineDate;  // tracks when vaccine was administered
    private boolean booster; // tracks if vaccine requires booster shot


    //REQUIRES: vaccine type (String) and date of vaccination (String)
    //EFFECTS: instantiates new vaccine record
    public Vaccine(String newVaccineType, String newVaccineDate, boolean initialBooster) {
        vaccineType = newVaccineType;
        vaccineDate = newVaccineDate;
        booster = initialBooster;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("type", vaccineType);
        json.put("date", vaccineDate);
        json.put("booster", booster);
        return json;
    }

    //EFFECTS: returns type of vaccine (String)
    public String getVaccineType() {
        return this.vaccineType;

    }

    //EFFECTS: returns date of vaccination (String)
    public String getVaccineDate() {
        return this.vaccineDate;
    }

    //REQUIRES: name of new vaccine type
    //MODIFIES: this
    //EFFECTS: changes type of vaccine in cases of needed correction
    public void setVaccineType(String newType) {
        this.vaccineType = newType;
    }

    //REQUIRES: date of new vaccination date
    //MODIFIES: this
    //EFFECTS: changes date of vaccination in cases of needed correction
    public void setVaccineDate(String newDate) {
        this.vaccineDate = newDate;

    }

    //EFFECTS: returns true if vaccine requires a booster shot; otherwise false
    public boolean checkBooster() {
        return this.booster;
    }

    //REQUIRES: true or false parameter value (boolean)
    //MODIFIES: this
    //EFFECTS: changes whether booster shot is needed for vaccine
    public void setBooster(Boolean b) {
        this.booster = b;
    }

}
