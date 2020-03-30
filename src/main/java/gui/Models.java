package gui;

import orderAndKnights.Knight;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class Models extends DefaultTableModel {

    public Models() {
    }

    public void addListToTable(ArrayList<Knight> knights, JTable jTable) {
        for (Knight k : knights) {
            ((DefaultTableModel) jTable.getModel()).
                    addRow(new Object[]{k.getId(), k.getName(), k.getSwordColor(), k.getPower(), k.getSite()
                    });
        }
    }

    public void addValueToTable(Knight k, JTable jTable) {

        int id = jTable.getRowCount();
        ((DefaultTableModel) jTable.getModel()).
                addRow(new Object[]{id + 1, k.getName(), k.getSwordColor(), k.getPower(), k.getSite()
                });
        k.setId(id);
    }

    public void removeValueFromKnightTable(JTable jTable) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }

    }
}
