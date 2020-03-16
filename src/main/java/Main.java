import gui.RunGui;
import orderAndKnights.Knight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RunGui Gui = new RunGui();

        List<Knight> list = new ArrayList();

        Knight andrzej = new Knight();
        andrzej.setName("Andrzej");
        andrzej.setPower(200);
        andrzej.setSite(1);
        andrzej.setSwordColor(1);


        System.out.println(andrzej);
        System.out.println(andrzej.getSwordColor());

        list.add(andrzej);

        for (Knight k : list) {
            System.out.println(k);
        }
    }




}

