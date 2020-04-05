package gui;

import orderAndKnights.Order;

import javax.swing.*;
import java.awt.*;

public class FunctionPane extends JPanel {

    KnightPane knightPane;
    OrderPane orderPane;
    Order order = new Order();
    JButton addToOrderButton;
    JButton delFromOrderButton;
    public Dimension getPreferredSize() {
        return new Dimension(150, 900);
    }
    public FunctionPane() {
        setLayout(null);

        addToOrderButton = new JButton();
        addToOrderButton.setText("Dodaj do Zakonu");
        addToOrderButton.setBounds(10,100,130,50);
        addToOrderButton.addActionListener(e->{
            System.out.println(order.getChooseKnights());
        });

        add(addToOrderButton);

        delFromOrderButton = new JButton();
        delFromOrderButton.setText("Usuń z zakonu");
        delFromOrderButton.setBounds(10,170,130,50);
        add(delFromOrderButton);


    }
}
