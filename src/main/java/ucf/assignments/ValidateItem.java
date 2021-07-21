package ucf.assignments;

import javafx.collections.ObservableList;

import java.text.NumberFormat;
import java.util.Locale;

public class ValidateItem {
    public boolean addItem(String name, String serial, String value, ObservableList<Item> list){
        if(!isName(name) || !isValue(value) || !isSerial(serial, list))
            return false;

        return true;
    }
    public boolean isName(String name){
        if(name.length() < 2 || name.length() > 256)
            return false;
        return true;
    }
    public boolean isValue(String value){
        int countDecimal = 0;
        if(value.matches("[0-9.]+")){
            for(int i = 0; i < value.length(); i++){
                if(value.charAt(i) == '.')
                    countDecimal++;
                if(countDecimal > 1)
                    return false;
            }
            return true;
        }

            return false;
    }
    public boolean isSerial(String serial, ObservableList<Item> list){
        if(serial.length() != 10)
            return false;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSerial().compareTo(serial) == 0){
                return false;
            }
        }
        return true;
    }
    public String formatToDollar(String value){
        double money = Double.parseDouble(value);
        Locale USD = new Locale("en", "US");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(USD);
        return numberFormat.format(money);
    }
    public ObservableList<Item> addToList(String name, String serial, String value, ObservableList<Item> list){
        list.add(new Item(name, serial, value));
        return list;
    }
}
