package gui;

import javax.swing.*;
import java.awt.*;

public class KnightPane extends JPanel {


    private JLabel labelKnight; // ok
    private JTextArea textAreaKnight; // ok
    private JLabel labelKnightRegister; // ok
    private JLabel labelKnightName;//ok
    private JTextField textFieldKnightName; //ok
    private JLabel labelKnightSwordColor;//ok
    private JComboBox comboBoxKnightSwordColor;//ok
    private JLabel labelKnightPower;
    private JSlider sliderKnightPower;
    private JLabel labelKnightForceSite;
    private JRadioButton radioButtonKnightDarkSite;
    private JRadioButton radioButtonKnightBright;
    private ButtonGroup buttonGroupKnightForceSide;
    private JButton buttonKnightImport;
    private JButton buttonKnightExport;
    private JTextField textFieldKnight;
    private JButton buttonRegister;
    private JButton buttonClear;


    public Dimension getPreferredSize() {
        return new Dimension(500, 700);
    }


    public KnightPane() {

        setLayout(null);
        labelKnight = new JLabel();
        labelKnight.setText("Jedi");
        labelKnight.setBounds(250, 20, 70, 30);
        add(labelKnight);

        textAreaKnight = new JTextArea();
        textAreaKnight.setAlignmentX(CENTER_ALIGNMENT);
        textAreaKnight.setBounds(10, 50, 480, 400);
        textAreaKnight.setColumns(2);
        textAreaKnight.setRows(50);
        textAreaKnight.setLineWrap(true);
        add(textAreaKnight);

        labelKnightRegister = new JLabel();
        labelKnightRegister.setText("Rejestracja");
        labelKnightRegister.setBounds(200, 450, 70, 30);
        add(labelKnightRegister);

        labelKnightName = new JLabel();
        labelKnightName.setText("Nazwa :");
        labelKnightName.setBounds(10,480,150,30);
        add(labelKnightName);

        textFieldKnightName = new JTextField();
        textFieldKnightName.setBounds(100,480,370,30);
        add(textFieldKnightName);

        labelKnightSwordColor = new JLabel();
        labelKnightSwordColor.setText("Kolor miecza");
        labelKnightSwordColor.setBounds(10,520,150,30);
        add(labelKnightSwordColor);


        String [] swordColor = {"RED","BLUE","GRYNSZPAN"};
        comboBoxKnightSwordColor = new JComboBox(swordColor);
        comboBoxKnightSwordColor.setBounds(100,520,150,30);
        add(comboBoxKnightSwordColor);











    }

}
