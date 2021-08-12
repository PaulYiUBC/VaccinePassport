package ui;

import javafx.embed.swing.JFXPanel;
import model.Vaccine;
import model.VaccineProfile;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.sound.sampled.*;
import java.io.File;
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

    //EFFECTS: initializes JavaFX to enable play sound functionality
    static {
        JFXPanel fxPanel = new JFXPanel();
    }

    private Vaccine covid19;
    private Vaccine mmr;
    private Vaccine tetanus;
    private Vaccine shingles;
    private Vaccine chickenpox;
    private VaccineProfile vaccineProfile1;
    private Scanner input;
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;
    private GUI gui;


    //EFFECTS: constructs vaccine profile and runs the vaccine passport application
    public VaccineApp() throws FileNotFoundException {
        initVaccines();
        input = new Scanner(System.in);
        vaccineProfile1 = new VaccineProfile("Your Profile");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        // EFFECTS: fill vaccine profile with five test vaccines
        // COMMENT: temporary test for show booster button
        for (int i = 0; i < 10; i += 2) {
            Vaccine v = new Vaccine("Chickenpox", "2021-01-01", true);
            vaccineProfile1.addVaccine(v);
        }

    }

    //EFFECTS: plays sound effect in data folder
    private static void playSound(String soundFile) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        File f = new File(soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    //REQUIRES: boolean
    //EFFECTS: returns string of Yes or No given true or false boolean, respectively
    public static String translate(boolean trueOrFalse) {
        return trueOrFalse ? "Yes" : "No";
    }

    //REQUIRE: GUI
    //EFFECTS: Established bi-directional relationship with GUI class to construct graphical interface for vaccine app
    public void setGUI(GUI gui) {
        this.gui = gui;
    }

    // EFFECTS: filters vaccine profile and updates text field with vaccines with needed booster shots
    public void filterBoosterVaccines() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        playSound("./data/positive-beep.wav");
        gui.updateField(vaccineProfile1.filterBoosterProfile());

    }

    //EFFECT: Adds COVID-19 Vaccine to vaccine Profile - For graphical interface
    public void addCovidVaccine() {
        addVaccineToProfile(covid19);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //EFFECT: Adds MMR Vaccine to vaccine Profile - For graphical interface
    public void addMmrVaccine() {
        addVaccineToProfile(mmr);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //EFFECT: Adds Tetanus Vaccine to vaccine Profile - For graphical interface
    public void addTetanusVaccine() {
        addVaccineToProfile(tetanus);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //EFFECT: Adds Shingles Vaccine to vaccine Profile - For graphical interface
    public void addShinglesVaccine() {
        addVaccineToProfile(shingles);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //EFFECT: Adds Chickenpox Vaccine to vaccine Profile - For graphical interface
    public void addChickenpoxVaccine() {
        addVaccineToProfile(chickenpox);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //EFFECT: Shows all vaccines in profile - For graphical interface
    public void showAllVaccines() {
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }


    //REQUIRES: Vaccine parameter
    //MODIFIES: this
    //EFFECTS: processes adding of vaccine to profile
    private void addVaccineToProfile(Vaccine v) {
//        System.out.println("\nVaccine added to profile");
        vaccineProfile1.addVaccine(v);

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
//        System.out.println("\nVaccine removed from profile"); // Commented out - console use
        vaccineProfile1.removeVaccine(v);

    }

    //MODIFIES: this
    //EFFECTS: initializes vaccine
    private void initVaccines() {
        covid19 = new Vaccine("COVID-19", "2021-05-05", true);
        mmr = new Vaccine("MMR", "2001-01-01", false);
        tetanus = new Vaccine("Tetanus", "1999-09-09", true);
        shingles = new Vaccine("Shingles", "2020-02-02", false);
        chickenpox = new Vaccine("Chickenpox", "2021-01-01", true);
//        input = new Scanner(System.in);
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
        List<Vaccine> vaccines = vaccineProfile1.getVaccines();

        for (Vaccine v : vaccines) {
            String toprint =
                    (v.getVaccineType() + " " + v.getVaccineDate() + " Need Booster? " + translate(v.checkBooster()));
            System.out.println(toprint);
        }
    }

    // EFFECTS: saves the Vaccine Profile to file
    private void saveVaccineProfile() {
        try {
            jsonWriter.open();
            jsonWriter.write(vaccineProfile1);
            jsonWriter.close();
            System.out.println("Saved " + vaccineProfile1.getProfileName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads vaccine profile from file
    private void loadVaccineProfile() {
        try {
            vaccineProfile1 = jsonReader.read();
            System.out.println("Loaded " + vaccineProfile1.getProfileName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
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
}


