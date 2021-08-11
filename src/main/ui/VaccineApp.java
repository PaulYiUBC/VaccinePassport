package ui;

import java.util.Scanner;

// Vaccine Passport application
// UI Functionality and methods are implemented from Teller App
public class VaccineApp {

    //EFFECTS: runs the vaccine passport application
    public VaccineApp() {

    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runVaccineHelper() {
        boolean keepGoing = true;
        String command = null;

        init();

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
        if (command.equals("d")) {
            doDeposit();
        } else if (command.equals("w")) {
            doWithdrawal();
        } else if (command.equals("t")) {
            doTransfer();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes vaccine profiles
    private void initVaccineProfiles() {
        cheq = new Account("Joe", 145.00);
        sav = new Account("Joe", 256.50);
        input = new Scanner(System.in);
    }


    //EFFECTS: displays menu of options to user (create profile, select profile, delete profile,...
    // //.. add vaccine, remove, edit vaccine)
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> deposit");
        System.out.println("\tw -> withdraw");
        System.out.println("\tt -> transfer");
        System.out.println("\tq -> quit");
    }
    }

    //MODIFIES: this
    //EFFECTS: processes creation of new vaccine profile
    private void doCreateProfile() {

    }

    //MODIFIES: this
    //EFFECTS: shows list of vaccine in selected vaccine profile
    private void displayVaccines() {

    }

    //MODIFIES: this
    //EFFECTS: deletes vaccine profile
    private void deleteVaccineProfile() {

    }

    //MODIFIES: this
    //EFFECTS: processes adding of vaccine to profile
    private void addVaccineToProfile() {

    }

    //MODIFIES: this
    //EFFECTS: processes removal of vaccine to profile
    private void removeVaccineFromProfile() {

    }

    //MODIFIES: this
    //EFFECTS: edits vaccine from profile
    private void editVaccineFromProfile() {

    }
}
