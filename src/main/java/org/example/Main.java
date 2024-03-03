package org.example;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Project Directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            try {
                File outputFile = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "output.txt");
                FileOutputStream fos = new FileOutputStream(outputFile);
                PrintStream ps = new PrintStream(fos);

                PrintStream console = System.out;
                System.setOut(ps);

                CommonOperations projectHandler = new CommonOperations();
                projectHandler.listPackagesAndClasses(selectedDirectory);

                System.setOut(console);
                JOptionPane.showMessageDialog(null, "Report saved to: " + outputFile.getAbsolutePath(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while saving the report.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("No Project Directory selected");
        }
    }
}