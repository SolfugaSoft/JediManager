package gui;

import javax.swing.*;
import java.awt.*;

public class OrderPane extends JPanel {

    private JLabel labelOrder; // ok
    private JTextArea textAreaOrder; // ok
    private JLabel labelOrderRegister; // ok
    private JLabel labelOrderName;//ok
    private JTextField textFieldOrderName; //ok
    private JButton buttonOrderChoose;
    private JTextArea textFieldChooseJedi; // ok
    private JButton buttonOrderImport; //ok
    private JTextField textFieldOrderImport;
    private JButton buttonOrderExport;//ok
    private JTextField textFieldOrderExport;//ok
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
        textFieldOrderName.setBounds(100, 480, 320, 30);
        add(textFieldOrderName);

        buttonOrderChoose = new JButton();
        buttonOrderChoose.setText("Wybierz");
        buttonOrderChoose.setBounds(10, 520, 80, 30);
        add(buttonOrderChoose);

        textFieldChooseJedi = new JTextArea();
        textFieldChooseJedi.setBounds(100, 520, 320, 100);
        add(textFieldChooseJedi);


        buttonOrderImport = new JButton();
        buttonOrderImport.setText("Import");
        buttonOrderImport.setBounds(10, 650, 80, 30);
        add(buttonOrderImport);

        textFieldOrderImport = new JTextField();
        textFieldOrderImport.setText("skąd otworzyć");

        textFieldOrderImport.setBounds(100, 650, 300, 30);
        textFieldOrderImport.setEnabled(true);
        textFieldOrderImport.setBackground(Color.LIGHT_GRAY);
        textFieldOrderImport.setForeground(Color.red);
        add(textFieldOrderImport);

        buttonOrderExport = new JButton();
        buttonOrderExport.setText("Eksport");
        buttonOrderExport.setBounds(10, 695, 80, 30);
        add(buttonOrderExport);

        textFieldOrderExport = new JTextField();
        textFieldOrderExport.setText("gdzie zapisać");
        textFieldOrderExport.setBounds(100, 695, 300, 30);
        textFieldOrderExport.setEnabled(true);
        textFieldOrderExport.setBackground(Color.lightGray);
        textFieldOrderExport.setForeground(Color.black);
        add(textFieldOrderExport);


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
