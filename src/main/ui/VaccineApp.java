package ui;

import model.Vaccine;
import model.VaccineProfile;

import java.util.Scanner;

// Vaccine Passport application
// UI Functionality and methods are implemented from Teller App
public class VaccineApp {
    private Vaccine covid19;
    private Vaccine mmr;
    private VaccineProfile yourprofile;
    private Scanner input;

    //EFFECTS: runs the vaccine passport application
    public VaccineApp() {
        runVaccineApp();

    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runVaccineApp() {
        boolean keepGoing = true;
        String command = null;

        initVaccineProfiles();
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

        } else {
            System.out.println("Selection not valid...");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes vaccine profiles
    private void initVaccineProfiles() {
        yourprofile = new VaccineProfile("You");
    }

    //MODIFIES: this
    //EFFECTS: initializes vaccine
    private void initVaccines() {
        covid19 = new Vaccine("COVID-19", "2021-05-05", true);
        mmr = new Vaccine("MMR", "2001-01-01", false);
        input = new Scanner(System.in);
    }

    //EFFECTS: displays menu of options to user (create profile, select profile, delete profile,...
    // //.. add vaccine, remove, edit vaccine)
    private void displayMenu() {
        System.out.println("\nWelcome to Your Vaccine Profile");
        System.out.println("\nSelect from:");
        System.out.println("\tv -> add vaccine");
        System.out.println("\tr -> remove vaccine");
        System.out.println("\tq -> quit");
    }

    //REQUIRES: Vaccine parameter
    //MODIFIES: this
    //EFFECTS: processes adding of vaccine to profile
    private void addVaccineToProfile(Vaccine v) {
        yourprofile.addVaccine(v);

    }

    //REQUIRES: Vaccine parameter
    //MODIFIES: this
    //EFFECTS: processes removal of vaccine to profile
    private void removeVaccineFromProfile(Vaccine v) {
        yourprofile.removeVaccine(v);

    }

    // EFFECTS: prompts user to select COVID-19 OR MMR vaccine to add to profile
    private void selectVaccine() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("c") || selection.equals("m"))) {
            System.out.println("c for COVID-19");
            System.out.println("m for MMR");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("c")) {
            addVaccineToProfile(covid19);
        } else {
            addVaccineToProfile(mmr);
        }
    }

    // EFFECTS: prompts user to select COVID-19 OR MMR vaccine to add to profile
    private void removeVaccine() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("c") || selection.equals("m"))) {
            System.out.println("c for COVID-19");
            System.out.println("m for MMR");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("c")) {
            removeVaccineFromProfile(covid19);
        } else {
            removeVaccineFromProfile(mmr);
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
