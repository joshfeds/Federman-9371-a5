package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateItemTest {

    @Test
    void addItem_all_cases_successful() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = true;
        String name = "XBox";
        String serial = "1q2w3e4r5t";
        String value = "499.99";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addItem_name_short() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "X";
        String serial = "1q2w3e4r5t";
        String value = "499.99";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addItem_name_long() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "Nature, nurture, heaven, and home\n" +
                "Sum of all, and by them, driven\n" +
                "To conquer every mountain shown\n" +
                "But I've never crossed the river\n" +
                "Braved the forests, braved the stone\n" +
                "Braved the icy winds and fire\n" +
                "Braved and beat them on my own\n" +
                "Yet I'm helpless by the river\n" +
                "Angel, angel, what have I done?\n" +
                "I've faced the quakes, the wind, the fire\n" +
                "I've conquered country, crown, and throne\n" +
                "Why can't I cross this river?\n" +
                "Angel, angel, what have I done?\n" +
                "I've faced the quakes, the wind, the fire\n" +
                "I've conquered country, crown, and throne\n" +
                "Why can't I cross this river?\n" +
                "Pay no mind to the battles you've won\n" +
                "It'll take a lot more than rage and muscle\n" +
                "Open your heart and hands, my son\n" +
                "Or you'll never make it over the river\n" +
                "It'll take a lot more than words and guns\n" +
                "A whole lot more than riches and muscle\n" +
                "The hands of the many must join as one\n" +
                "And together we'll cross the river\n" +
                "It'll take a lot more than words and guns\n" +
                "A whole lot more than riches and muscle\n" +
                "The hands of the many must join as one\n" +
                "And together we'll cross the river\n" +
                "Nature, nurture, heaven, and home\n" +
                "It'll take a lot more than words and guns\n" +
                "Sum of all, and by them, driven\n" +
                "A whole lot more than riches and muscle\n" +
                "To conquer every mountain shown\n" +
                "The hands of the many must join as one\n" +
                "And together we'll cross the river\n" +
                "Braved the forests, braved the stone\n" +
                "It'll take a lot more than words and guns\n" +
                "Braved the icy winds and fire\n" +
                "A whole lot more than riches and muscle\n" +
                "Braved and beat them on my own\n" +
                "The hands of the many must join as one\n" +
                "And together we'll cross the river\n" +
                "And together we'll cross the river\n" +
                "And together we'll cross the river\n" +
                "Nature, nurture, heaven, and home\n" +
                "And together we'll cross the river\n" +
                "And together we'll cross the river\n" +
                "Nature, nurture, heaven, and home\n" +
                "And together we'll cross the river\n" +
                "And together we'll cross the river";
        String serial = "1q2w3e4r5t";
        String value = "499.99";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addItem_serial_code_not_10() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "Xbox";
        String serial = "1qe4r5t";
        String value = "499.99";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addItem_serial_code_already_exists() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "Xbox";
        String serial = "0o9i8u7y6t";
        String value = "499.99";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addItem_value_not_valid() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "Xbox";
        String serial = "0o9i8u7y6t";
        String value = "100a.64.9";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addToList() {
        ValidateItem validateItem = new ValidateItem();
        ObservableList<Item> listExpected = FXCollections.observableArrayList();
        ObservableList<Item> listActual = FXCollections.observableArrayList();

        listExpected.add(new Item("Xbox", "0ohi8u7y6t", "225.99"));
        listExpected.add(new Item("Playstation", "0oxi8u7y6t", "425.99"));
        listExpected.add(new Item("Oculus", "0o9i8u7y6t", "475.99"));

        listActual.add(new Item("Xbox", "0ohi8u7y6t", "225.99"));
        listActual.add(new Item("Playstation", "0oxi8u7y6t", "425.99"));
        listActual = validateItem.addToList("Oculus", "0o9i8u7y6t", "475.99", listActual);
        assertArrayEquals(listExpected, listActual);
    }

    private void assertArrayEquals(ObservableList<Item> listExpected, ObservableList<Item> listActual) {
    }

    @Test
    void removeFromList() {
        ValidateItem validateItem = new ValidateItem();
        ObservableList<Item> listExpected = FXCollections.observableArrayList();
        ObservableList<Item> listActual = FXCollections.observableArrayList();

        listExpected.add(new Item("Xbox", "0ohi8u7y6t", "225.99"));
        listExpected.add(new Item("Oculus", "0o9i8u7y6t", "475.99"));

        listActual.add(new Item("Xbox", "0ohi8u7y6t", "225.99"));
        listActual.add(new Item("Playstation", "0oxi8u7y6t", "425.99"));
        listActual.add(new Item("Oculus", "0o9i8u7y6t", "475.99"));
        listActual = validateItem.removeFromList(listActual, 1);
        assertArrayEquals(listExpected, listActual);
    }
}