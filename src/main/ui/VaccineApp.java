package ui;

import model.Vaccine;
import model.VaccineProfile;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Vaccine Passport application
// Console UI Functionality and methods are implemented from Teller App
// Persistence functionality and methods implemented from JsonSerializationDemo
// PlaySound implemented from Stackoverflow - Link:
// (https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java)
public class VaccineApp {
    private static final String JSON_STORE = "./data/vaccineprofile.json";
    private Vaccine covid19;
    private Vaccine mmr;
    private Vaccine tetanus;
    private Vaccine shingles;
    private VaccineProfile vaccineProfile;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private GUI gui;



    //EFFECTS: constructs vaccine profile and runs the vaccine passport application
    public VaccineApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        vaccineProfile = new VaccineProfile("Your Profile");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        for (int i = 0; i < 10; i += 2) {
            Vaccine v = new Vaccine("Chickenpox", "2021-01-01", true);
            vaccineProfile.addVaccine(v);
        }

//        runVaccineApp();

    }

    public void setGUI(GUI gui) {
        this.gui = gui;
    }


    public void filterBoosterVaccines() {
        gui.updateLabel(vaccineProfile.filterProfile());
    }




    //MODIFIES: this
    //EFFECTS: processes user input
    private void runVaccineApp() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

//        initVaccineProfiles();
        initVaccines();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }


    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            selectVaccine();
        } else if (command.equals("r")) {
            removeVaccine();
        } else if (command.equals("s")) {
            saveVaccineProfile();
        } else if (command.equals("l")) {
            loadVaccineProfile();
        } else if (command.equals("p")) {
            printVaccines();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //REQUIRES: Vaccine parameter
    //MODIFIES: this
    //EFFECTS: processes removal of vaccine to profile
    private void removeVaccineFromProfile(Vaccine v) {
        System.out.println("\nVaccine removed from profile");
        vaccineProfile.removeVaccine(v);

    }

    //MODIFIES: this
    //EFFECTS: initializes vaccine
    private void initVaccines() {
        covid19 = new Vaccine("COVID-19", "2021-05-05", true);
        mmr = new Vaccine("MMR", "2001-01-01", false);
        tetanus = new Vaccine("Tetanus", "1999-09-09", true);
        shingles = new Vaccine("Shingles", "2020-02-02", false);

        input = new Scanner(System.in);
    }

    //EFFECTS: displays menu of options to user (create profile, select profile, delete profile,...
    // //.. add vaccine, remove, edit vaccine)
    private void displayMenu() {
        System.out.println("\nWelcome to Your Vaccine Profile");
        System.out.println("\nSelect from:");
        System.out.println("\tv -> add vaccine");
        System.out.println("\tr -> remove vaccine");
        System.out.println("\ts -> save vaccine profile to file");
        System.out.println("\tl -> load vaccine profile form file");
        System.out.println("\tp -> print vaccines");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: prints all the vaccines in vaccine profile to the console
    private void printVaccines() {
        List<Vaccine> vaccines = vaccineProfile.getVaccines();

        for (Vaccine v : vaccines) {
            String toprint =
                    (v.getVaccineType() + " " + v.getVaccineDate() + " Need Booster? " + translate(v.checkBooster()));
            System.out.println(toprint);
        }
    }

    //REQUIRES: boolean
    //EFFECTS: returns string of Yes or No given true or false boolean, respectively
    public static String translate(boolean trueOrFalse) {
        return trueOrFalse ? "Yes" : "No";
    }

    // EFFECTS: saves the Vaccine Profile to file
    private void saveVaccineProfile() {
        try {
            jsonWriter.open();
            jsonWriter.write(vaccineProfile);
            jsonWriter.close();
            System.out.println("Saved " + vaccineProfile.getProfileName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads vaccine profile from file
    private void loadVaccineProfile() {
        try {
            vaccineProfile = jsonReader.read();
            System.out.println("Loaded " + vaccineProfile.getProfileName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //REQUIRES: Vaccine parameter
    //MODIFIES: this
    //EFFECTS: processes adding of vaccine to profile
    private void addVaccineToProfile(Vaccine v) {
        System.out.println("\nVaccine added to profile");
        vaccineProfile.addVaccine(v);

    }


    // EFFECTS: prompts user to select COVID-19 OR MMR OR Tetanus vaccine to add to profile
    private void selectVaccine() {
        String selection = "";  // force entry into loop

        System.out.println("c for COVID-19 Vaccine");
        System.out.println("m for MMR Vaccine");
        System.out.println("t for Tetanus Vaccine");
        System.out.println("s for Shingles Vaccine");
        selection = input.next();
        selection = selection.toLowerCase();


        if (selection.equals("c")) {
            addVaccineToProfile(covid19);
        }
        if (selection.equals("m")) {
            addVaccineToProfile(mmr);
        }
        if (selection.equals("t")) {
            addVaccineToProfile(tetanus);
        }
        if (selection.equals("s")) {
            addVaccineToProfile(shingles);
        }
    }

    // EFFECTS: prompts user to select COVID-19 OR MMR OR Tetanus vaccine to add to profile
    private void removeVaccine() {
        String selection = "";  // force entry into loop

        System.out.println("c for COVID-19 Vaccine");
        System.out.println("m for MMR Vaccine");
        System.out.println("t for Tetanus Vaccine");
        System.out.println("s for Shingles Vaccine");
        selection = input.next();
        selection = selection.toLowerCase();

        if (selection.equals("c")) {
            removeVaccineFromProfile(covid19);
        }
        if (selection.equals("m")) {
            removeVaccineFromProfile(mmr);
        }
        if (selection.equals("t")) {
            removeVaccineFromProfile(tetanus);
        }
        if (selection.equals("s")) {
            removeVaccineFromProfile(shingles);
        }
    }


//    //MODIFIES: this
//    //EFFECTS: processes creation of new vaccine profile
//    private void doCreateProfile() {
//
//    }

//    //MODIFIES: this
//    //EFFECTS: shows list of vaccine in selected vaccine profile
//    private void displayVaccines() {
//
//    }

//    //MODIFIES: this
//    //EFFECTS: deletes vaccine profile
//    private void deleteVaccineProfile() {
//
//    }


//    //MODIFIES: this
//    //EFFECTS: edits vaccine from profile
//    private void editVaccineFromProfile() {
//
//    }
}