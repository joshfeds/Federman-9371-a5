package ucf.assignments;

import javafx.collections.ObservableList;

public class SearchItem {
    public boolean nameExists(String key, Item item) {
        if (item.getName().contains(key))
            return true;
        return false;
    }
    public boolean serialExists(String key, Item item){
        if (item.getSerial().contains(key))
            return true;
        return false;
    }
}
