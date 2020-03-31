package orderAndKnights;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface Functions {
    public void add(ArrayList<Knight> knightsList);

    public ArrayList<String> get();

    public void saveIntoFile(Component parent, ArrayList<Knight> objectsToSave,JTextField textField);

    public ArrayList<Knight> readFromFile(Component parent , JTextField textField);




}
