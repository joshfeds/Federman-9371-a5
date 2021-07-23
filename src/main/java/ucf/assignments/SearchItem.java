package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Joshua Federman
 */

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
