package gui;

import orderAndKnights.Knight;
import orderAndKnights.Order;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


import static gui.OrderPane.*;


public class FunctionPane extends JPanel {


    Order order;
    JButton addToOrderButton;
    JButton delFromOrderButton;
    public static JTable jTableFunction;
    JScrollPane scrollPane;
    Models models = new Models();
    private ArrayList<Knight> choosenList = KnightPane.getChoosen();

    public Dimension getPreferredSize() {
        return new Dimension(150, 900);
    }

    public FunctionPane() {
        setLayout(null);
        addToOrderButton = new JButton();
        addToOrderButton.setText("Dodaj do Zakonu");
        addToOrderButton.setBounds(10, 100, 130, 50);
        addToOrderButton.addActionListener(e -> {
            order = orderList.get(tableOrder.getSelectedRow());
            order.addKnightListToOrder(choosenList);
        });

        add(addToOrderButton);

        delFromOrderButton = new JButton();
        delFromOrderButton.setText("Usuń z zakonu");
        delFromOrderButton.setBounds(10, 170, 130, 50);
        add(delFromOrderButton);

        jTableFunction = new JTable();
        models.createNameTable(jTableFunction);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 240, 130, 200);
        scrollPane.setViewportView(jTableFunction);
        add(scrollPane);

    }
}
