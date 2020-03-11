package gui;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class StartFrame extends JFrame {


    public StartFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(150, 150);
        setSize(800, 600);
        setTitle("Manago Jedi");

        add(new KnightPane(), BorderLayout.EAST);
        add(new KnightPane(), BorderLayout.WEST);
        pack();


    }
}
