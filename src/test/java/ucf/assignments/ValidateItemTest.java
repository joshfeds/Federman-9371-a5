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
        String name = """
                Nature, nurture, heaven, and home
                Sum of all, and by them, driven
                To conquer every mountain shown
                But I've never crossed the river
                Braved the forests, braved the stone
                Braved the icy winds and fire
                Braved and beat them on my own
                Yet I'm helpless by the river
                Angel, angel, what have I done?
                I've faced the quakes, the wind, the fire
                I've conquered country, crown, and throne
                Why can't I cross this river?
                Angel, angel, what have I done?
                I've faced the quakes, the wind, the fire
                I've conquered country, crown, and throne
                Why can't I cross this river?
                Pay no mind to the battles you've won
                It'll take a lot more than rage and muscle
                Open your heart and hands, my son
                Or you'll never make it over the river
                It'll take a lot more than words and guns
                A whole lot more than riches and muscle
                The hands of the many must join as one
                And together we'll cross the river
                It'll take a lot more than words and guns
                A whole lot more than riches and muscle
                The hands of the many must join as one
                And together we'll cross the river
                Nature, nurture, heaven, and home
                It'll take a lot more than words and guns
                Sum of all, and by them, driven
                A whole lot more than riches and muscle
                To conquer every mountain shown
                The hands of the many must join as one
                And together we'll cross the river
                Braved the forests, braved the stone
                It'll take a lot more than words and guns
                Braved the icy winds and fire
                A whole lot more than riches and muscle
                Braved and beat them on my own
                The hands of the many must join as one
                And together we'll cross the river
                And together we'll cross the river
                And together we'll cross the river
                Nature, nurture, heaven, and home
                And together we'll cross the river
                And together we'll cross the river
                Nature, nurture, heaven, and home
                And together we'll cross the river
                And together we'll cross the river""";
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
    void addItem_value_two_decimals() {
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
    void addItem_value_two_commas() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "Xbox";
        String serial = "0o9i8u7y6t";
        String value = "100,64,9";
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.add(new Item("Playstation", "0o9i8u7y6t", "425.99"));
        boolean actual = validateItem.addItem(name, serial, value, list);
        assertEquals(expected, actual);
    }
    @Test
    void addItem_value_letters() {
        ValidateItem validateItem = new ValidateItem();
        boolean expected = false;
        String name = "Xbox";
        String serial = "0o9i8u7y6t";
        String value = "100,23.67a";
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