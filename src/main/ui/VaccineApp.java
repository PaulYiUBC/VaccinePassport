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
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;
    private GUI gui;


    //EFFECTS: constructs vaccine profile and runs the vaccine passport application
    public VaccineApp() throws FileNotFoundException {
        initVaccines();
        vaccineProfile1 = new VaccineProfile("Your Profile");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    //REQUIRE: GUI
    //EFFECTS: Established bi-directional relationship with GUI class to construct graphical interface for vaccine app
    public void setGUI(GUI gui) {
        this.gui = gui;
    }

    //REQUIRES: sound file
    //EFFECTS: plays sound effect in data folder
    private static void playSound(String soundFile) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        File f = new File(soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }


    // EFFECTS: filters vaccine profile and updates text field with vaccines with needed booster shots
    public void filterBoosterVaccines() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        playSound("./data/positive-beep.wav");
        gui.updateField(vaccineProfile1.filterBoosterProfile());

    }

    //MODIFIES: vaccine profile
    //EFFECT: Adds COVID-19 Vaccine to vaccine Profile - For graphical interface
    public void addCovidVaccine() {
        addVaccineToProfile(covid19);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Adds MMR Vaccine to vaccine Profile - For graphical interface
    public void addMmrVaccine() {
        addVaccineToProfile(mmr);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Adds Tetanus Vaccine to vaccine Profile - For graphical interface
    public void addTetanusVaccine() {
        addVaccineToProfile(tetanus);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Adds Shingles Vaccine to vaccine Profile - For graphical interface
    public void addShinglesVaccine() {
        addVaccineToProfile(shingles);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Adds Chickenpox Vaccine to vaccine Profile - For graphical interface
    public void addChickenpoxVaccine() {
        addVaccineToProfile(chickenpox);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Removes COVID-19 Vaccine to vaccine Profile - For graphical interface
    public void removeCovidVaccine() {
        removeVaccineFromProfile(covid19);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Removes MMR Vaccine to vaccine Profile - For graphical interface
    public void removeMmrVaccine() {
        removeVaccineFromProfile(mmr);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Removes Tetanus Vaccine to vaccine Profile - For graphical interface
    public void removeTetanusVaccine() {
        removeVaccineFromProfile(tetanus);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Removes Shingles Vaccine to vaccine Profile - For graphical interface
    public void removeShinglesVaccine() {
        removeVaccineFromProfile(shingles);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //MODIFIES: vaccine profile
    //EFFECT: Removes Chickenpox Vaccine to vaccine Profile - For graphical interface
    public void removeChickenpoxVaccine() {
        removeVaccineFromProfile(chickenpox);
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }

    //EFFECT: Shows all vaccines in profile - For graphical interface
    public void showAllVaccines() {
        gui.updateField(vaccineProfile1.filterNormalProfile());
    }


    //REQUIRES: Vaccine parameter
    //MODIFIES: this
    //EFFECTS: processes adding of vaccine to profile
    public void addVaccineToProfile(Vaccine v) {
//        System.out.println("\nVaccine added to profile");
        vaccineProfile1.addVaccine(v);

    }


    // EFFECTS: saves the Vaccine Profile to file
    public void saveVaccineProfile() {
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
    public void loadVaccineProfile() {
        try {
            vaccineProfile1 = jsonReader.read();
            System.out.println("Loaded " + vaccineProfile1.getProfileName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //REQUIRES: Vaccine parameter
    //MODIFIES: vaccine profile
    //EFFECTS: processes removal of vaccine to profile
    private void removeVaccineFromProfile(Vaccine v) {
//        System.out.println("\nVaccine removed from profile"); // Commented out - console use
        vaccineProfile1.removeVaccine(v);

    }


    //EFFECTS: initializes vaccine objects
    public void initVaccines() {
        covid19 = new Vaccine("COVID-19", "2021-05-05", true);
        mmr = new Vaccine("MMR", "2001-01-01", false);
        tetanus = new Vaccine("Tetanus", "1999-09-09", true);
        shingles = new Vaccine("Shingles", "2020-02-02", false);
        chickenpox = new Vaccine("Chickenpox", "2021-01-01", true);
    }

}


