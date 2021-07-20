package ucf.assignments;

public class Item {
    private String name;
    private String value;
    private String serial;

    public Item(String name, String serial, String value){
        this.name = name;
        this.value = value;
        this.serial = serial;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
