package ui;


import javafx.embed.swing.JFXPanel;
import model.Vaccine;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        JButton btn1 = new JButton("Show Booster Vaccines");
//        btn.setActionCommand("myButton");
        btn1.addActionListener(this);
        label = new JLabel("Status");
        field = new JTextArea();
        field.setPreferredSize(new Dimension(20, 20));
        field.setBounds(20, 20, 100, 150);
        add(field);
        add(btn1);
        btn1.setBounds(140, 20, 200, 20);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //REQUIRES: Action Event
    //EFFECTS: This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Show Booster Vaccines")) {
            try {
                app.filterBoosterVaccines();
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
            label.setText("Here are the vaccines that need booster shots");
        }
    }

    //REQUIRES: Vaccine app
    //EFFECTS: sets up the functionality of the vaccine app to use in the graphical interface
    public void setApp(VaccineApp app) {
        this.app = app;
    }

    //EFFECTS: provides updated list of vaccine names in profile
    public void updateLabel(ArrayList<Vaccine> vp) {
        String msg = "";
        for (Vaccine v : vp) {
            msg += "\n" + v.getVaccineType();
        }
        field.setText(msg);
    }


}
