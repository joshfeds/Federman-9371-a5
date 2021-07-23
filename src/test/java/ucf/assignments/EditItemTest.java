package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditItemTest {

    @Test
    void editName() {
        EditItem editItem = new EditItem();
        Item itemExpected = new Item("Xbox", "1q2w3e4r5t", "499.99");
        Item itemActual = new Item("Playstation", "1q2w3e4r5t", "499.99");
        itemActual = editItem.editName(itemActual, "Xbox");
        assertArrayEquals(itemExpected ,itemActual);
    }

    private void assertArrayEquals(Item itemExpected, Item itemActual) {
    }

    @Test
    void editSerial() {
        EditItem editItem = new EditItem();
        Item itemExpected = new Item("Xbox", "0o9i8u7y6t", "499.99");
        Item itemActual = new Item("Playstation", "1q2w3e4r5t", "499.99");
        itemActual = editItem.editName(itemActual, "0o9i8u7y6t");
        assertArrayEquals(itemExpected ,itemActual);
    }

    @Test
    void editValue() {
        EditItem editItem = new EditItem();
        Item itemExpected = new Item("Xbox", "1q2w3e4r5t", "399.99");
        Item itemActual = new Item("Playstation", "1q2w3e4r5t", "499.99");
        itemActual = editItem.editName(itemActual, "399.99");
        assertArrayEquals(itemExpected ,itemActual);
    }
}