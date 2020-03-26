package gui;

import databaseFunction.CrudFunction;
import databaseFunction.JDBCConnector;
import orderAndKnights.Knight;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class KnightPane extends JPanel {
    CrudFunction crudFunction = new CrudFunction();
    Models models = new Models();
    private ArrayList<Knight> knightList = new ArrayList();
    private Knight knight;

    private JLabel labelKnight; // ok
    private JTextArea textAreaKnight; // ok
    private JScrollPane scrollKnight;
    private JTable tableKnight; //ok

    private JLabel labelKnightRegister; // ok
    private JLabel labelKnightName;//ok
    private JTextField textFieldKnightName; //ok
    private JLabel labelKnightSwordColor;//ok
    private JComboBox comboBoxKnightSwordColor;//ok
    private JLabel labelKnightPower; //ok
    private JSlider sliderKnightPower;//ok
    private JLabel labelKnightForceSite;//ok
    private JRadioButton radioButtonKnightDarkSite;//ok
    private JRadioButton radioButtonKnightBright;//ok
    private ButtonGroup buttonGroupKnightForceSide;//ok
    private JButton buttonKnightImport; //ok
    private JTextField textFieldKnightImport;
    private JButton buttonKnightExport;//ok
    private JTextField textFieldKnightExport;//ok
    private JButton buttonRegister;
    private JButton buttonClear;


    public Dimension getPreferredSize() {
        return new Dimension(500, 900);
    }


    public KnightPane() {
        setLayout(null);
        labelKnight = new JLabel();
        labelKnight.setText("Jedi");
        labelKnight.setBounds(250, 20, 70, 30);
        add(labelKnight);

//        textAreaKnight = new JTextArea();
//        textAreaKnight.setAlignmentX(CENTER_ALIGNMENT);
//        textAreaKnight.setBounds(10, 50, 480, 400);
//        textAreaKnight.setColumns(2);
//        textAreaKnight.setRows(50);
//        textAreaKnight.setLineWrap(true);
//        add(textAreaKnight);

        String[] tablename = {"ID", "Imie", "Kolor Miecza", "Moc", "Strona Mocy"};
        tableKnight = new JTable();
        tableKnight.setAutoscrolls(true);
        tableKnight.setModel(new DefaultTableModel(new Object[][]{}, tablename));
//        tableKnight.setBounds(10, 50, 480, 400);

        scrollKnight = new JScrollPane();
        scrollKnight.setViewportView(tableKnight);
        scrollKnight.setBounds(10, 50, 480, 400);
        add(scrollKnight);

        labelKnightRegister = new JLabel();
        labelKnightRegister.setText("Rejestracja Jedi");
        labelKnightRegister.setBounds(200, 450, 200, 30);
        add(labelKnightRegister);

        labelKnightName = new JLabel();
        labelKnightName.setText("Nazwa :");
        labelKnightName.setBounds(10, 480, 150, 30);
        add(labelKnightName);

        textFieldKnightName = new JTextField();
        textFieldKnightName.setBounds(100, 480, 370, 30);
        textFieldKnightName.setToolTipText("Jak zwą tego dzielnego wojaka");
        add(textFieldKnightName);

        labelKnightSwordColor = new JLabel();
        labelKnightSwordColor.setText("Kolor miecza");
        labelKnightSwordColor.setBounds(10, 520, 150, 30);
        add(labelKnightSwordColor);


        String[] swordColor = {"RED", "BLUE", "GRYNSZPAN"};
        comboBoxKnightSwordColor = new JComboBox(swordColor);
        comboBoxKnightSwordColor.setBounds(100, 520, 150, 30);
        add(comboBoxKnightSwordColor);

        labelKnightPower = new JLabel();
        labelKnightPower.setText("Moc");
        labelKnightPower.setBounds(10, 560, 150, 30);
        add(labelKnightPower);

        sliderKnightPower = new JSlider();
        sliderKnightPower.setBounds(90, 560, 390, 45);
        sliderKnightPower.setMajorTickSpacing(250);
        sliderKnightPower.setMinorTickSpacing(25);
        sliderKnightPower.setMaximum(1000);
        sliderKnightPower.setMinimum(0);
        sliderKnightPower.setValue(500);
        sliderKnightPower.setPaintTicks(true);
        sliderKnightPower.setPaintLabels(true);
        sliderKnightPower.setOrientation(SwingConstants.HORIZONTAL);
        add(sliderKnightPower);

        labelKnightForceSite = new JLabel();
        labelKnightForceSite.setText("Strona Mocy");
        labelKnightForceSite.setBounds(10, 600, 100, 40);
        add(labelKnightForceSite);

        radioButtonKnightBright = new JRadioButton();
        radioButtonKnightDarkSite = new JRadioButton();
        buttonGroupKnightForceSide = new ButtonGroup();

        radioButtonKnightBright.setText("Jasności");
        radioButtonKnightBright.setBounds(190, 600, 90, 40);
        buttonGroupKnightForceSide.add(radioButtonKnightBright);
        add(radioButtonKnightBright);

        radioButtonKnightDarkSite.setText("Ciemności");
        radioButtonKnightDarkSite.setBounds(280, 600, 90, 40);
        buttonGroupKnightForceSide.add(radioButtonKnightDarkSite);
        add(radioButtonKnightDarkSite);


        buttonKnightImport = new JButton();
        buttonKnightImport.setText("Import");
        buttonKnightImport.setBounds(10, 650, 80, 30);
        buttonKnightImport.addActionListener(e -> {
            models.addListToTable(crudFunction.readFromFile(buttonKnightImport, textFieldKnightImport), tableKnight);
        });
        add(buttonKnightImport);

        textFieldKnightImport = new JTextField();
        textFieldKnightImport.setText("skąd otworzyć");

        textFieldKnightImport.setBounds(100, 650, 300, 30);
        textFieldKnightImport.setEnabled(true);
        textFieldKnightImport.setBackground(Color.LIGHT_GRAY);
        textFieldKnightImport.setForeground(Color.red);
        add(textFieldKnightImport);


        buttonKnightExport = new JButton();
        buttonKnightExport.setText("Eksport");
        buttonKnightExport.setBounds(10, 695, 80, 30);
        buttonKnightExport.addActionListener(e -> {
            crudFunction.saveIntoFile(buttonKnightExport, knightList, textFieldKnightExport);

        });

        add(buttonKnightExport);

        textFieldKnightExport = new JTextField();
        textFieldKnightExport.setText("gdzie zapisać");
        textFieldKnightExport.setBounds(100, 695, 300, 30);
        textFieldKnightExport.setEnabled(true);
        textFieldKnightExport.setBackground(Color.lightGray);
        textFieldKnightExport.setForeground(Color.black);

        add(textFieldKnightExport);

        buttonRegister = new JButton();
        buttonRegister.setText("Zarejestruj");
        buttonRegister.setBounds(250, 730, 100, 50);
        buttonRegister.addActionListener(e ->
        {
            knight = new Knight();
            knight.setName(textFieldKnightName.getText());
            knight.setPower(sliderKnightPower.getValue());
            knight.setSwordColor(comboBoxKnightSwordColor.getSelectedIndex());
            if (radioButtonKnightDarkSite.isSelected()) {

                knight.setSite(0);
            } else if (radioButtonKnightBright.isSelected()) {
                knight.setSite(1);
            }
            knightList.add(knight);
            models.addValueToTable(knight, tableKnight);
        });

        add(buttonRegister);

        buttonClear = new JButton();
        buttonClear.setText("Wyczyść");
        buttonClear.addActionListener(e -> {
            System.out.println(knightList);
        });

        buttonClear.setBounds(100, 730, 100, 50);

        add(buttonClear);

    }

}
