package ui;


import model.Vaccine;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

// GUI functionality and methods implemented from Phase 3 project page examples/sources:
// Link (https://stackoverflow.com/questions/6578205/swing-jlabel-text-change-on-the-running-application)
// Link (https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html)
// Link (https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/components-TextSamplerDemoProject.zip)
public class GUI extends JFrame implements ActionListener {
    private VaccineApp app;
    private final JLabel label;
    private final JTextArea field;


    //EFFECTS: constructs the graphical user interface for Vaccine app
    public GUI() {
        super("Welcome to Vaccine Passport");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        initilizeAddBtns();
        initilizeRemoveBtns();
        label = new JLabel("Status", SwingConstants.CENTER);
        field = new JTextArea();
        field.setPreferredSize(new Dimension(20, 20));
        field.setBounds(20, 20, 100, 400);
        add(field);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void initilizeRemoveBtns() {
        setupBtn("Remove COVID-19 Vaccine", 350, 40, 200, 20);
        setupBtn("Remove MMR Vaccine", 350, 60, 200, 20);
        setupBtn("Remove Tetanus Vaccine", 350, 80, 200, 20);
        setupBtn("Remove Shingles Vaccine", 350, 100, 200, 20);
        setupBtn("Remove Chickenpox Vaccine", 350, 120, 200, 20);
    }

    public void initilizeAddBtns() {
        setupBtn1(); // show booster vaccine(s) button
        setupBtn2(); // add covid-19 vaccine button
        setupBtn3(); // add mmr vaccine button
        setupBtn4(); // add tentanus vaccine button
        setupBtn5(); // add shingles vaccine button
        setupBtn6(); // add chickenpox vaccine button
        setupBtn7(); // show call vaccine(s) button
        setupBtn8(); // save profile button
        setupBtn9(); // load profile button
    }


    public void setupBtn(String command, int x, int y, int w, int h) {
        JButton btn10 = new JButton(command);
        btn10.setActionCommand(command);
        btn10.addActionListener(this);
        add(btn10);
        btn10.setBounds(x, y, w, h);
    }


    // EFFECTS: Constructs button 1 - Show Booster Vacines
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn1() {
        JButton btn1 = new JButton("Show Booster Vaccines");
        btn1.setActionCommand("Show Booster Vaccines");
        btn1.addActionListener(this);
        add(btn1);
        btn1.setBounds(140, 20, 200, 20);
    }

    // EFFECTS: Constructs button 2 - Add covid vaccine
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn2() {
        JButton btn2 = new JButton("Add COVID-19 Vaccine");
        btn2.setActionCommand("Add COVID-19 Vaccine");
        btn2.addActionListener(this);
        add(btn2);
        btn2.setBounds(140, 40, 200, 20);
    }

    // EFFECTS: Constructs button 3 - Add mmr vaccine
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn3() {
        JButton btn3 = new JButton("Add MMR Vaccine");
        btn3.setActionCommand("Add MMR Vaccine");
        btn3.addActionListener(this);

        add(btn3);
        btn3.setBounds(140, 60, 200, 20);
    }

    // EFFECTS: Constructs button 4 - Add tetanus vaccine
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn4() {
        JButton btn3 = new JButton("Add Tetanus Vaccine");
        btn3.setActionCommand("Add Tetanus Vaccine");
        btn3.addActionListener(this);
        add(btn3);
        btn3.setBounds(140, 80, 200, 20);
    }

    // EFFECTS: Constructs button 5 - Add shingles vaccine
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn5() {
        JButton btn3 = new JButton("Add Shingles Vaccine");
        btn3.setActionCommand("Add Shingles Vaccine");
        btn3.addActionListener(this);
        add(btn3);
        btn3.setBounds(140, 100, 200, 20);
    }

    // EFFECTS: Constructs button 6 - Add chickenpox vaccine
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn6() {
        JButton btn3 = new JButton("Add Chickenpox Vaccine");
        btn3.setActionCommand("Add Chickenpox Vaccine");
        btn3.addActionListener(this);
        add(btn3);
        btn3.setBounds(140, 120, 200, 20);
    }

    // EFFECTS: Constructs button 7 - show all vaccines
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn7() {
        JButton btn3 = new JButton("Show all vaccines");
        btn3.setActionCommand("Show all vaccines");
        btn3.addActionListener(this);
        add(btn3);
        btn3.setBounds(140, 140, 200, 20);
    }

    // EFFECTS: Constructs button 8 - save profile
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn8() {
        JButton btn3 = new JButton("Save Profile");
        btn3.setActionCommand("Save Profile");
        btn3.addActionListener(this);
        add(btn3);
        btn3.setBounds(140, 160, 200, 20);
    }

    // EFFECTS: Constructs button 9 - load profile
    // COMMENT: made this helper function to fix checkstyle limit of 27 lines in GUI  method
    public void setupBtn9() {
        JButton btn3 = new JButton("Load Profile");
        btn3.setActionCommand("Load Profile");
        btn3.addActionListener(this);
        add(btn3);
        btn3.setBounds(140, 180, 200, 20);
    }


    //REQUIRES: Action Event
    //EFFECTS: This is the method that is called when the the JButtons are clicked
    // function is to filter list of vaccines and show ones needing boosters
    public void actionPerformed(ActionEvent e) {
        addAction(e);
        removeAction(e);
    }

    public void removeAction(ActionEvent e) {
        if ((e.getActionCommand().equals("Remove COVID-19 Vaccine"))) {
            app.removeCovidVaccine();
            label.setText("Status: COVID-19 Vaccine Removed");
        } else if ((e.getActionCommand().equals("Remove MMR Vaccine"))) {
            app.removeMmrVaccine();
            label.setText("Status: MMR Vaccine Removed");

        } else if ((e.getActionCommand().equals("Remove Tetanus Vaccine"))) {
            app.removeTetanusVaccine();
            label.setText("Status: Tetanus Vaccine Removed");

        } else if ((e.getActionCommand().equals("Remove Shingles Vaccine"))) {
            app.removeShinglesVaccine();
            label.setText("Status: Shingles Vaccine Removed");

        } else if ((e.getActionCommand().equals("Remove Chickenpox Vaccine"))) {
            app.removeChickenpoxVaccine();
            label.setText("Status: Chickenpox Vaccine Removed");
        }

    }

    private void addAction(ActionEvent e) {
        if (e.getActionCommand().equals("Show Booster Vaccines")) {
            actionCommandBooster();
        } else if ((e.getActionCommand().equals("Add COVID-19 Vaccine"))) {
            actionCommandCovid();
        } else if ((e.getActionCommand().equals("Add MMR Vaccine"))) {
            actionCommandMmr();
        } else if ((e.getActionCommand().equals("Add Tetanus Vaccine"))) {
            actionCommandTetanus();
        } else if ((e.getActionCommand().equals("Add Shingles Vaccine"))) {
            actionCommandShingles();
        } else if ((e.getActionCommand().equals("Add Chickenpox Vaccine"))) {
            actionCommandPox();
        } else if ((e.getActionCommand().equals("Show all vaccines"))) {
            actionCommandShowAll();
        } else if ((e.getActionCommand().equals("Save Profile"))) {
            app.saveVaccineProfile();
            label.setText("Status: Profile Saved");
        } else if ((e.getActionCommand().equals("Load Profile"))) {
            app.loadVaccineProfile();
            label.setText("Status: Profile Loaded");
        }
    }


    //EFFECT: implements action for show all button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandShowAll() {
        app.showAllVaccines();
        label.setText("Status: All vaccines in profile shown");
    }

    //EFFECT: implements action for add chicken pox button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandPox() {
        app.addChickenpoxVaccine();
        label.setText("Status: Chickenpox Vaccine added to your profile");
    }

    //EFFECT: implements action for add mmr button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandMmr() {
        app.addMmrVaccine();
        label.setText("Status: MMR Vaccine added to your profile");
    }

    //EFFECT: implements action for add tetanus button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandTetanus() {
        app.addTetanusVaccine();
        label.setText("Status: Tetanus Vaccine added to your profile");
    }

    //EFFECT: implements action for add shingles button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandShingles() {
        app.addShinglesVaccine();
        label.setText("Status: Shingles Vaccine added to your profile");
    }


    //EFFECT: implements action for show booster button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandBooster() {
        try {
            app.filterBoosterVaccines();
            label.setText("Status: Vaccine(s) in your profile that need booster shots");
        } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
            unsupportedAudioFileException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (LineUnavailableException lineUnavailableException) {
            lineUnavailableException.printStackTrace();
        }
    }

    //EFFECT: implements action for add covid button
// COMMENT: Helper function to reduce max line limit checkstyle error
    public void actionCommandCovid() {
        app.addCovidVaccine();
        label.setText("Status: COVID-19 Vaccine added to your profile");
    }


    //REQUIRES: Vaccine app
//EFFECTS: sets up the functionality of the vaccine app to use in the graphical interface
    public void setApp(VaccineApp app) {
        this.app = app;

    }

    //REQUIRES: vaccine profile
//EFFECTS: provides updated list of vaccine names in profile
    public void updateField(ArrayList<Vaccine> vp) {
        String updatedList = "";
        for (Vaccine v : vp) {
            updatedList += "\n" + v.getVaccineType();
        }
        field.setText(updatedList);
    }


}
