package gui;

import databaseFunction.CrudFunction;
import orderAndKnights.Knight;
import orderAndKnights.Order;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KnightPane extends JPanel {
    CrudFunction crudFunction = new CrudFunction();
    Models models = new Models();
    private ArrayList<Knight> knightList = new ArrayList();
    private  ArrayList<Knight>choosen = new ArrayList<>();
    private Knight knight;
    private Order order = new Order();

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

    private JButton button1;

    private static String[] localRemote = {"Lokalnie", "Zdalnie"};

    public Dimension getPreferredSize() {
        return new Dimension(500, 900);
    }

    public KnightPane() {
        setLayout(null);
        labelKnight = new JLabel();
        labelKnight.setText("Jedi");
        labelKnight.setBounds(250, 20, 70, 30);
        add(labelKnight);

        Object[] tablename = {"ID", "Imie", "Kolor Miecza", "Moc", "Strona Mocy"};
        tableKnight = new JTable();
        tableKnight.setAutoscrolls(true);
        tableKnight.setAutoResizeMode(4);
        tableKnight.setModel(new DefaultTableModel(new Object[][]{}, tablename));
        tableKnight.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableKnight.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableKnight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                choosen.add(knightList.get(tableKnight.getSelectedRow()));
                System.out.println(choosen);
            }
        });



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
        textFieldKnightName.setBounds(100, 480, 390, 30);
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

            int i = JOptionPane.showOptionDialog(this, "Gdzie chcesz zapisać", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, localRemote, localRemote[0]);

            if (i == 1) {
                knightList.clear();
                models.removeValuetTable(tableKnight);
                knightList.addAll(crudFunction.get());
                models.addKnightsListToTable(knightList, tableKnight);


            } else if (i == 0) {
                knightList.clear();
                System.out.println(tableKnight.getRowCount());
                models.removeValuetTable(tableKnight);
                knightList.addAll(crudFunction.readFromFile(buttonKnightImport, textFieldKnightImport));
                models.addKnightsListToTable(knightList, tableKnight);
            } else {
                JOptionPane.showMessageDialog(this, "wybierz coś");
            }
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
            if (knightList.size() > 0) {

                int i = JOptionPane.showOptionDialog(this, "Gdzie chcesz zapisać", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, localRemote, localRemote[0]);
                System.out.println(i);
                if (i == 0) {
                    crudFunction.saveIntoFile(buttonKnightExport, knightList, textFieldKnightExport);
                } else if (i == 1) {
                    crudFunction.add(knightList);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Lista jest pusta");
            }
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
            models.addOneKnightToTable(knight, tableKnight);
        });

        add(buttonRegister);

        buttonClear = new JButton();
        buttonClear.setText("Wyczyść");
        buttonClear.addActionListener(e -> {
            int knightListSize = knightList.size();
            knightList.clear();
            ((DefaultTableModel) tableKnight.getModel()).setNumRows(0);
            JOptionPane.showMessageDialog(this, "Dane wyczysztone ilosc danych przed wyczyszczeniem :" + knightListSize + " po wyczysczeniu : " + knightList.size());
        });

        buttonClear.setBounds(100, 730, 100, 50);
        add(buttonClear);


    }

}
