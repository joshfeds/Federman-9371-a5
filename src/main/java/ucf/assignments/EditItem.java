package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Joshua Federman
 */
public class EditItem {
    public Item editName(Item item, String name){
        item.setName(name);
        return item;
    }
    public Item editSerial(Item item, String name){
        item.setSerial(name);
        return item;
    }
    public Item editValue(Item item, String name){
        item.setValue(name);
        return item;
    }
}
