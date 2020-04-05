package orderAndKnights;

import javax.swing.*;
import java.util.ArrayList;

public class Order {
    private int id;
    private String orderName;
    private ArrayList<Knight> knightsInOrderList;
    private ArrayList<Knight> chooseKnights;

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

    public void addKnightToOrder(Knight k) {
        knightsInOrderList.add(k);
    }

    public ArrayList<Knight> getChooseKnights() {
        return chooseKnights;
    }

    public ArrayList<Knight> addKnightListToOrder(ArrayList<Knight> list, JTable jTable) {
        chooseKnights = new ArrayList<>();
        knightsInOrderList = new ArrayList<>();
        if (list.isEmpty()) {
            System.out.println("Lista jest pusta");
        } else {
            knightsInOrderList.addAll(list);
//            System.out.println(knightsInOrderList);
        }
        chooseKnights.add(knightsInOrderList.get(jTable.getSelectedRow()));
        System.out.println(chooseKnights);
        return chooseKnights;

    }

    public ArrayList<Knight> selectKnight(JTable jTable) {
        chooseKnights.add(knightsInOrderList.get(jTable.getSelectedRow()));
        return chooseKnights;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", knightsInOrderList=" + knightsInOrderList +
                '}';
    }


}
