package gui;

import orderAndKnights.Knight;
import orderAndKnights.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Models extends DefaultTableModel {

    public Models() {
    }

    public void createTableKnight(JTable jTable) {
        Object[] tablename = {"ID", "Imie", "Kolor Miecza", "Moc", "Strona Mocy"};
        jTable.setModel(new DefaultTableModel(new Object[][]{}, tablename));
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.setAutoscrolls(true);
        jTable.setAutoResizeMode(4);
    }

    public void createTableOrder(JTable jTable) {
        String[] orderTableHeader = {"ID", "Nazwa Zakonu"};
        jTable.setModel(new DefaultTableModel(new Object[][]{}, orderTableHeader));
        jTable.setAutoscrolls(true);
    }

    public void createNameTable(JTable jTable) {
         String[] names = {"Imie"};
        jTable.setModel(new DefaultTableModel(new Object[][]{},names));
        jTable.setAutoscrolls(true);
    }

    public void addOrderToTable(Order o, JTable jTable) {
        int id = jTable.getRowCount();
        ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{id + 1, o.getOrderName()
        });
        o.setId(id);
    }

    public void addOrderListToTable(ArrayList<Order> orders, JTable jTable) {
        for (Order o : orders) {
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{o.getId(), o.getOrderName()
            });
        }
    }

    public void addKnightsListToTable(ArrayList<Knight> knights, JTable jTable) {
        for (Knight k : knights) {
            ((DefaultTableModel) jTable.getModel()).
                    addRow(new Object[]{k.getId(), k.getName(), k.getSwordColor(), k.getPower(), k.getSite()
                    });
        }
    }

    public void addOneKnightToTable(Knight k, JTable jTable) {
        int id = jTable.getRowCount();

        ((DefaultTableModel) jTable.getModel()).
                addRow(new Object[]{id + 1, k.getName(), k.getSwordColor(), k.getPower(), k.getSite()
                });

        k.setId(id);
    }

    public void addName(Knight k, JTable jTable) {


        ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{k.getName()
        });

    }

    public void removeValuetTable(JTable jTable) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }

    }
}
