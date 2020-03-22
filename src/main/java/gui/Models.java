package gui;


import orderAndKnights.Knight;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class Models extends DefaultTableModel {

    public Models() {
    }
    public void addToTable(ArrayList<Knight> knights, JTable jTable) {
        for (Knight k : knights) {
            ((DefaultTableModel) jTable.getModel()).
                    addRow(new Object[]{k.getName(), k.getSwordColor(), k.getPower(), k.getSite()
                    });

        }
    }
}
