package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileMenu {
    public ValidateItem validateItem = new ValidateItem();

    public void createTSV(String name, String location, ObservableList<Item> list){
        //future note: make this return a string to confirm a file was created
        try {
            Path path = Paths.get("resources/" + location);
            Files.createDirectories(path);
            FileWriter writer = new FileWriter(path + "/" + name + ".txt");
            String listData = listToTabString(list);
            writer.write(listData);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String listToTabString(ObservableList<Item> list){
        String tabString = "";
        for(int i = 0; i < list.size(); i++){
            tabString += list.get(i).getName() + "\t" + list.get(i).getSerial() +
                    "\t" + list.get(i).getValue() + "\t\n";
        }
        return tabString;
    }
    public void createHTML(String name, String location, ObservableList<Item> list){
        try {
            Path path = Paths.get("resources/" + location);
            Files.createDirectories(path);
            FileWriter writer = new FileWriter(path + "/" + name + ".html");
            String listData = listToHTML(list, name);
            writer.write(listData);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String listToHTML(ObservableList<Item> list, String name){
        String htmlString = "<html>\n" + "\t<head>\n" + "\t\t<title>" + name + "</title>\n" + "</head> " +
                "<table  style=\"width:100%\">\n  <tr>\n  <th>Name</th>\n <th>Serial Number</th>\n" +
                " <th>Value</th>\n</tr>\n ";

        for (Item item : list) {
            htmlString += "<tr>\n  <td style=\"text-align:center\">" + item.getName() + "</td>\n  " +
                    "<td style=\"text-align:center\">" + item.getSerial() + "</td>\n  " +
                    "<td style=\"text-align:center\">" + item.getValue() + "</td>\n  " +
                    "</tr>\n ";
        }
        htmlString += "</table>\n " + "</html>";
        return htmlString;
    }
    public ObservableList<Item> loadTSV(String name, String location, ObservableList<Item> list){
        //return list
        System.out.println("teest");
        try {
            Path path = Paths.get("resources/" + location);
            FileReader reader = new FileReader(path + "/" + name + ".txt");
            Scanner inputIO = new Scanner(reader);
            return listFromTSV(list, inputIO);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return list;
        }

    }
    public ObservableList<Item> listFromTSV(ObservableList<Item> list, Scanner inputIO){
        int i = 0;
        while(inputIO.hasNextLine()){
            String data = inputIO.nextLine();
            String [] itemAsArray = data.split("\\t");
            String name = itemAsArray[0];
            String serial = itemAsArray[1];
            String value = itemAsArray[2];
            list = validateItem.addToList(name, serial, value, list);
            i++;
        }
        return list;
    }
}
