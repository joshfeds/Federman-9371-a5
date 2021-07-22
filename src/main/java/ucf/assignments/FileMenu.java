package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMenu {
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
                    "\t" + list.get(i).getValue() + "\n";
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
}
