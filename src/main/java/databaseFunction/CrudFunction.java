package databaseFunction;

import orderAndKnights.Functions;
import orderAndKnights.Knight;
import orderAndKnights.Site;
import orderAndKnights.SwordColor;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class CrudFunction extends JDBCConnector implements Functions {
    private static File file;
    private static Scanner scaner;

    public void add(ArrayList<Knight> knightsList) {
        String tableName = "JediKnight";
        String addQuery = String.format("INSERT INTO %s(FirstName,SwordColor,Power,ForceSite) VALUES", tableName);

        try {
            for (Knight k : knightsList) {
                StartConnection().executeUpdate(
                        addQuery + k.sqlFormat());
            }
            System.out.println("poszło zdalnie");
        } catch (SQLException e) {
            System.out.println("nie poszło");
            e.printStackTrace();
        }

    }

    public ArrayList<Knight> get() {
        ArrayList<Knight>getKnightList = new ArrayList<>();
        Knight k = null;
        String knight = "";
        ArrayList<String> getJediArray = new ArrayList<>();
        String tableName = "JediKnight";
        String addQuery = "SELECT * FROM " + tableName;
        try {
            ResultSet resultSet = StartConnection().executeQuery(addQuery);
            while (resultSet.next()) {
            k = new Knight();
            k.setId(resultSet.getInt("ID"));
            k.setName(resultSet.getString("FirstName"));
            k.setSwordColorString(resultSet.getString("SwordColor"));
            k.setPower(resultSet.getInt("Power"));
            k.setSiteString(resultSet.getString("ForceSite"));
            getKnightList.add(k);
            }

        } catch (SQLException e) {
            System.out.println("OOOoooo motyla noga cos nie działa");
            e.printStackTrace();
        }
        return getKnightList;
    }

    @Override
    public void saveIntoFile(Component parent, ArrayList<Knight> objectsToSave, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Place this Data File in the safest place");
        int value = fileChooser.showSaveDialog(parent);
        if (value == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            System.out.println("Kaj sie to zapisało " + file.getAbsolutePath());
            textField.setText(file.getAbsolutePath());
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                PrintWriter printWriter = new PrintWriter(file, "UTF-8");
                for (Knight o : objectsToSave) {
                    printWriter.write(o.simlpeFormat());
                }
                printWriter.flush();
                printWriter.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Knight> readFromFile(Component parent, JTextField textField) {
        ArrayList<Knight> knightArrayList = new ArrayList<>();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Looking and Serching");
        int val = jFileChooser.showOpenDialog(parent);

        if (val == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            System.out.println("Pobrano dane z " + file.getAbsolutePath());
            textField.setText(file.getAbsolutePath());
            try {
                scaner = new Scanner(file);
                while (scaner.hasNextLine()) {
                    String[] knightStringArray = scaner.nextLine().split(" ");
                    String stringId = knightStringArray[0];
                    String stringName = knightStringArray[1];
                    String stringSwortdColor = knightStringArray[2];
                    String stringPower = knightStringArray[3];
                    String stringForceSite = knightStringArray[4];

                    Knight knight = new Knight();
                    knight.setId(Integer.parseInt(stringId));
                    knight.setName(stringName);
                    for (int i = 0; i < SwordColor.values().length; i++) {
                        if (stringSwortdColor.equals(String.valueOf(SwordColor.values()[i]))) {
                            knight.setSwordColor(i);
                        }

                    }
                    knight.setPower(Integer.parseInt(stringPower));

                    for (int i = 0; i < Site.values().length; i++) {
                        if (stringForceSite.equals(String.valueOf(Site.values()[i]))) {
                            knight.setSite(i);
                        }
                    }
                    knightArrayList.add(knight);

                }
            } catch (FileNotFoundException e) {
                System.out.println("Nie ma pliku z którego można odczytać dane");
                e.printStackTrace();
            }
        }
        return knightArrayList;
    }


}
