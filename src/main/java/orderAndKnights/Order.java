package orderAndKnights;

import javax.swing.*;
import java.util.ArrayList;

public class Order {
    private int id;
    private String orderName;
    private ArrayList<Knight>  chooseKnights = new ArrayList<>();

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public ArrayList<Knight> getChooseKnights() {
        return chooseKnights;
    }

    public ArrayList<Knight> addKnightListToOrder(ArrayList<Knight> list, JTable jTable) {
        System.out.println(list.size());
        if (list.size() > 0) {
            chooseKnights.add(list.get(jTable.getSelectedRow()));
            System.out.println(chooseKnights);

        } else {
            System.out.println("Lista jest pusta");
        } return chooseKnights;

    }

    public void setChooseKnights(ArrayList<Knight> chooseKnights) {
        this.chooseKnights = chooseKnights;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", knightsInOrderList=" + chooseKnights +
                '}';
    }


}
