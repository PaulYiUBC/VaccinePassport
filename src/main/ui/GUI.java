package ui;


import model.Vaccine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// GUI functionality and methods implemented from Phase 3 project page examples/sources:
// Link (https://stackoverflow.com/questions/6578205/swing-jlabel-text-change-on-the-running-application)
// Link (https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html)
// Link (https://docs.oracle.com/javase/tutorial/uiswing/examples/zipfiles/components-TextSamplerDemoProject.zip)
public class GUI extends JFrame {
    private VaccineApp app;
    private final JLabel label;
    private final JTextArea field;


    public GUI() {

        super("The title");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));

        JButton btn = new JButton("FilterBoosterVaccines");
//        btn.setActionCommand("myButton");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.filterBoosterVaccines();

            }
        }); // Sets "this" object as an action listener for btn
        // so that when the btn is clicked,
        // this.actionPerformed(ActionEvent e) will be called.
        // You could also set a different object, if you wanted
        // a different object to respond to the button click
        label = new JLabel("flag");
        field = new JTextArea();
        field.setPreferredSize(new Dimension(20, 20));
        field.setBounds(20, 20, 100, 500);
        add(field);
        add(btn);
        btn.setBounds(120, 20, 100, 20);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

//    private makeButtons(String label, Runable fn)

    public void setApp(VaccineApp app) {
        this.app = app;
    }
//
//    public LabelChanger() {
//
//    }

    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            label.setText(field.getText());
        }
    }

    public void updateLabel(ArrayList<Vaccine> vp) {
        String msg = "";
        for (Vaccine v : vp) {
            msg += "\n" + v.getVaccineType();
        }
        field.setText(msg);
    }
//
//    public static void main(String[] args) {
//        new LabelChanger();
//    }
//}


//    public void update
}
