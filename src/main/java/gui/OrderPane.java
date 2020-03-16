package gui;

import javax.swing.*;
import java.awt.*;

public class OrderPane extends JPanel {

    private JLabel labelOrder; // ok
    private JTextArea textAreaOrder; // ok
    private JLabel labelOrderRegister; // ok
    private JLabel labelOrderName;//ok
    private JTextField textFieldOrderName; //ok
    private JTextArea textFieldChooseJedi; // ok
    private JButton buttonKnightImport; //ok
    private JTextField textFieldKnightImport;
    private JButton buttonKnightExport;//ok
    private JTextField textFieldKnightExport;//ok
    private JButton buttonOrderRegister;
    private JButton buttonOrderClear;


    public Dimension getPreferredSize() {
        return new Dimension(500, 900);
    }


    public OrderPane() {

        setLayout(null);
        labelOrder = new JLabel();
        labelOrder.setText("Zakon");
        labelOrder.setBounds(250, 20, 70, 30);
        add(labelOrder);

        textAreaOrder = new JTextArea();
        textAreaOrder.setAlignmentX(CENTER_ALIGNMENT);
        textAreaOrder.setBounds(10, 50, 480, 400);
        textAreaOrder.setColumns(2);
        textAreaOrder.setRows(50);
        textAreaOrder.setLineWrap(true);
        add(textAreaOrder);

        labelOrderRegister = new JLabel();
        labelOrderRegister.setText("Rejestracja Zakonu");
        labelOrderRegister.setBounds(200, 450, 200, 30);
        add(labelOrderRegister);

        labelOrderName = new JLabel();
        labelOrderName.setText("Nazwa :");
        labelOrderName.setBounds(10, 480, 150, 30);
        add(labelOrderName);

        textFieldOrderName = new JTextField();
        textFieldOrderName.setBounds(100, 480, 370, 30);
        add(textFieldOrderName);

        textFieldChooseJedi = new JTextArea();
        textFieldChooseJedi.setBounds(100, 520, 370, 100);
        add(textFieldChooseJedi);


        buttonKnightImport = new JButton();
        buttonKnightImport.setText("Import");
        buttonKnightImport.setBounds(10, 650, 80, 30);
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
        add(buttonKnightExport);

        textFieldKnightExport = new JTextField();
        textFieldKnightExport.setText("gdzie zapisać");
        textFieldKnightExport.setBounds(100, 695, 300, 30);
        textFieldKnightExport.setEnabled(true);
        textFieldKnightExport.setBackground(Color.lightGray);
        textFieldKnightExport.setForeground(Color.black);
        add(textFieldKnightExport);


        buttonOrderRegister = new JButton();
        buttonOrderRegister.setText("Zarejestruj");
        buttonOrderRegister.setBounds(250, 730, 100, 50);
        add(buttonOrderRegister);


        buttonOrderClear = new JButton();
        buttonOrderClear.setText("Wyczyść");
        buttonOrderClear.setBounds(100, 730, 100, 50);
        add(buttonOrderClear);

    }
}
