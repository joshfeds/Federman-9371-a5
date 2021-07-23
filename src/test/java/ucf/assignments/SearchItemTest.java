package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchItemTest {

    @Test
    void nameExists() {
        SearchItem searchItem = new SearchItem();
        boolean expected = true;
        Item item = new Item("Xbox", "1q2w3e4r5t", "499.99");
        boolean actual = searchItem.nameExists("Xbox", item);
        assertEquals(expected, actual);
    }
    @Test
    void nameExists_false() {
        SearchItem searchItem = new SearchItem();
        boolean expected = false;
        Item item = new Item("Xb", "1q2w3e4r5t", "499.99");
        boolean actual = searchItem.nameExists("Xbox", item);
        assertEquals(expected, actual);
    }

    @Test
    void serialExists() {
        SearchItem searchItem = new SearchItem();
        boolean expected = true;
        Item item = new Item("Xbox", "1q2w3e4r5t", "499.99");
        boolean actual = searchItem.serialExists("1q2w3e4r5t", item);
        assertEquals(expected, actual);
    }
    @Test
    void serialExists_false() {
        SearchItem searchItem = new SearchItem();
        boolean expected = false;
        Item item = new Item("Xbox", "1q2w3e4r5m", "499.99");
        boolean actual = searchItem.serialExists("1q2w3e4r5t", item);
        assertEquals(expected, actual);
    }
}