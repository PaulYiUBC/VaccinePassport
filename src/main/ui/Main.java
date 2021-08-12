package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            VaccineApp app = new VaccineApp();
            GUI gui = new GUI();
            app.setGUI(gui);
            gui.setApp(app);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

}
