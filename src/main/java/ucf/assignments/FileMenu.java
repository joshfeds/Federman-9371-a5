package ucf.assignments;

import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Joshua Federman
 */
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
        try {
            Path path = Paths.get("resources/" + location);
            FileReader reader = new FileReader(path + "/" + name + ".txt");

            int size = list.size();
            while(!list.isEmpty()){
                list.remove(size - 1);
                size--;
            }

            Scanner inputIO = new Scanner(reader);
            return listFromTSV(list, inputIO);
        } catch (FileNotFoundException e) {
            return list;
        }

    }
    public ObservableList<Item> listFromTSV(ObservableList<Item> list, Scanner inputIO){
        int i = 0;
        while(inputIO.hasNextLine()){
            String data = inputIO.nextLine();
            String [] itemAsArray = data.split("\\t");

            list = validateItem.addToList(itemAsArray[0], itemAsArray[1], itemAsArray[2], list);
            i++;
        }
        return list;
    }
    public ObservableList<Item> loadHTML(String name, String location, ObservableList<Item> list){
        //return list
        try {

            Path path = Paths.get("resources/" + location);
            FileReader reader = new FileReader(path + "/" + name + ".html");
            String filePath = path + "/" + name + ".html";
            int size = list.size();
            while(!list.isEmpty()){
                list.remove(size - 1);
                size--;
            }

            Scanner inputIO = new Scanner(reader);
            return listFromHTML(list, inputIO, filePath);
        } catch (IOException e) {
            return list;
        }

    }
    public ObservableList<Item> listFromHTML(ObservableList<Item> list, Scanner inputIO, String path) throws IOException {
        String html = "";
        while(inputIO.hasNextLine()){
            html += inputIO.nextLine();
        }
        Document document = Jsoup.parse(html);
        Element table = document.select("table").get(0);
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++){
            Element singleRow = rows.get(i);
            Elements columns = singleRow.select("td");
            String [] colmToArray = new String[3];
            for(int j = 0; j < columns.size(); j++){
                colmToArray[j] = columns.get(j).text();
            }
            list = validateItem.addToList(colmToArray[0], colmToArray[1], colmToArray[2], list);
        }
        return list;
    }
}
