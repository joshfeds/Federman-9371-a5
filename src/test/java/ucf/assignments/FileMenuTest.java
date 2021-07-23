package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileMenuTest {

    @Test
    void fileExists_true() throws IOException {
        FileMenu fileMenu = new FileMenu();
        boolean expected = true;
        String location = "test";
        String name = "blah";
        Path path = Paths.get("resources/" + location);
        Files.createDirectories(path);
        String fileName = path + "/" + name + ".txt";
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        boolean actual = fileMenu.fileExists(file);
        assertEquals(expected, actual);
    }
    @Test
    void fileExists_false() throws IOException {
        FileMenu fileMenu = new FileMenu();
        boolean expected = false;
        String location = "test";
        String name = "invincible";
        Path path = Paths.get("resources/" + location);
        Files.createDirectories(path);
        String fileName = path + "/" + name + ".txt";
        File file = new File(fileName);

        boolean actual = fileMenu.fileExists(file);
        assertEquals(expected, actual);
    }

    @Test
    void listToTabString() {
        FileMenu fileMenu  = new FileMenu();
        ObservableList<Item> list = FXCollections.observableArrayList();
        String expected = "Xbox\t0ohi8u7y6t\t225.99\t\n" +
                "Oculus\t0o9i8u7y6t\t475.99\t\n";
        list.add(new Item("Xbox", "0ohi8u7y6t", "225.99"));
        list.add(new Item("Oculus", "0o9i8u7y6t", "475.99"));
        String actual = fileMenu.listToTabString(list);
        assertEquals(actual, expected);
    }

    @Test
    void listToHTML() {
        FileMenu fileMenu  = new FileMenu();
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Xbox", "0987654321", "$500.00"));
        list.add(new Item("Playstation", "0987bb4321", "$480.00"));
        list.add(new Item("Nintendo", "0987mm4321", "$479.40"));
        String expected = "<html>\n" +
                "\t<head>\n" +
                "\t\t<title>case</title>\n" +
                "</head> <table  style=\"width:100%\">\n" +
                "  <tr>\n" +
                "  <th>Name</th>\n" +
                " <th>Serial Number</th>\n" +
                " <th>Value</th>\n" +
                "</tr>\n" +
                " <tr>\n" +
                "  <td style=\"text-align:center\">Xbox</td>\n" +
                "  <td style=\"text-align:center\">0987654321</td>\n" +
                "  <td style=\"text-align:center\">$500.00</td>\n" +
                "  </tr>\n" +
                " <tr>\n" +
                "  <td style=\"text-align:center\">Playstation</td>\n" +
                "  <td style=\"text-align:center\">0987bb4321</td>\n" +
                "  <td style=\"text-align:center\">$480.00</td>\n" +
                "  </tr>\n" +
                " <tr>\n" +
                "  <td style=\"text-align:center\">Nintendo</td>\n" +
                "  <td style=\"text-align:center\">0987mm4321</td>\n" +
                "  <td style=\"text-align:center\">$479.40</td>\n" +
                "  </tr>\n" +
                " </table>\n" +
                " </html>";
        String actual = fileMenu.listToHTML(list, "case");
        assertEquals(actual, expected);
    }


    @Test
    void listFromTSV() throws FileNotFoundException {
        FileMenu fileMenu = new FileMenu();
        ObservableList<Item> listExpected = FXCollections.observableArrayList();
        ObservableList<Item> listActual = FXCollections.observableArrayList();
        String name = "base";
        String location = "test";
        listExpected.add(new Item("Xbox", "0987654321", "$500.00"));
        listExpected.add(new Item("Playstation", "0987bb4321", "$480.00"));
        listExpected.add(new Item("Nintendo", "0987mm4321", "$479.40"));
        fileMenu.createTSV(name, location, listExpected);
        Path path = Paths.get("resources/" + location);
        FileReader reader = new FileReader(path + "/" + name + ".txt");
        Scanner inputIO = new Scanner(reader);
        listActual = fileMenu.listFromTSV(listActual, inputIO);
        assertArrayEquals(listActual, listExpected);
    }

    private void assertArrayEquals(ObservableList<Item> listActual, ObservableList<Item> listExpected) {
    }

    @Test
    void listFromHTML() throws IOException {
        FileMenu fileMenu = new FileMenu();
        ObservableList<Item> listExpected = FXCollections.observableArrayList();
        ObservableList<Item> listActual = FXCollections.observableArrayList();
        String name = "base";
        String location = "test";
        listExpected.add(new Item("Xbox", "0987654321", "$500.00"));
        listExpected.add(new Item("Playstation", "0987bb4321", "$480.00"));
        listExpected.add(new Item("Nintendo", "0987mm4321", "$479.40"));
        fileMenu.createHTML(name, location, listExpected);
        Path path = Paths.get("resources/" + location);
        FileReader reader = new FileReader(path + "/" + name + ".html");
        Scanner inputIO = new Scanner(reader);
        listActual = fileMenu.listFromHTML(listActual, inputIO);
        assertArrayEquals(listActual, listExpected);
    }
}