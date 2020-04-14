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

    public void addKnightListToOrder(ArrayList<Knight> list) {
        this.chooseKnights =  list;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", knightsInOrderList=" + chooseKnights +
                '}';
    }


}
