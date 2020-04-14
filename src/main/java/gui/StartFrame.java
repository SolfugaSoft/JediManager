package gui;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class StartFrame extends JFrame {

KnightPane knightPane = new KnightPane();


    public StartFrame() throws HeadlessException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(150, 150);
        setSize(1000, 600);
        setTitle("Manago Jedi");
        add(new KnightPane(), BorderLayout.EAST);
        add(new FunctionPane(), BorderLayout.CENTER);
        add(new OrderPane(), BorderLayout.WEST);
        pack();


    }
}
