package model;



// Represents a vaccine record having a vaccine type and date of vaccination
public class Vaccine {
    private String vaccineType;
    private String vaccineDate; //TO-DO: Change implementation of date to Date or SimpleDate format



    //REQUIRES: vaccine type (String) and date of vaccination (String)
    //EFFECTS: instantiates new vaccine record
    public Vaccine(String newVaccineType, String newVaccineDate) {
        vaccineType = newVaccineType;
        vaccineDate = newVaccineDate;

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
    public void editVaccineType(String newType) {

    }

    //REQUIRES: date of new vaccination date
    //MODIFIES: this
    //EFFECTS: changes date of vaccination in cases of needed correction
    public void editVaccineDate(String newDate) {

    }

}
