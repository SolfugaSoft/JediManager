package orderAndKnights;

import java.awt.*;
import java.util.ArrayList;

public interface Functions {
    public void add();

    public ArrayList<String> get();

    public void saveIntoFile(Component parent, ArrayList<Knight> objectsToSave);

    public ArrayList<Knight> readFromFile(Component parent);


}
