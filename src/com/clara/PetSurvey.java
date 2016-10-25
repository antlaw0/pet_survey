package com.clara;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PetSurvey extends JPanel{

    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JCheckBox dogCheckBox;
    private JButton quitButton;
    private JLabel instructionsLabel;
    private JLabel surveyResultsLabel;
    private JPanel rootPanel;

    private boolean fish, cat, dog;


    PetSurvey() {
        //Set up GUI components here

        instructionsLabel = new JLabel("Select the pets you have");

        catCheckBox = new JCheckBox("Cat");
        fishCheckBox = new JCheckBox("Fish");
        dogCheckBox = new JCheckBox("Dog");

        surveyResultsLabel = new JLabel("Results here");

        quitButton = new JButton("Quit");

        add(instructionsLabel);
        add(catCheckBox);
        add(dogCheckBox);
        add(fishCheckBox);

        add(surveyResultsLabel);
        add(quitButton);

        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });

        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });

        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);

                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }



            }
        });



    }

    private void updateResults() {

        String hasDog = dog ? "a dog" : "no dogs";
        String hasCat = cat ? "a cat" : "no cats";

        String hasFish;
        if (fish == true) {
            hasFish = "a fish";
        } else {
            hasFish = "no fish";
        }

        String results = "You have " + hasCat + ", " + hasDog + " and " + hasFish;
        surveyResultsLabel.setText(results);

    }


    public static void main(String[] args) {

        JFrame petSurveyFrame = new JFrame("Pet survey");
        PetSurvey surveyGUI = new PetSurvey();
        petSurveyFrame.setSize(350, 200);
        petSurveyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        petSurveyFrame.add(surveyGUI);
        petSurveyFrame.setVisible(true);

    }
}
