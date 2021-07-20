package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventoryManager {
    @FXML
    public TableView tableView;
    public ObservableList<Item> list = FXCollections.observableArrayList();
    public TextField nameID;
    public TextField serialCodeID;
    public TextField valueID;
    public TextField searchNumberID;
    public TextField searchItemID;
    public TextField fileNameID;
    public TextField fileLocationID;

    @FXML
    public void initialize(){
        itemDisplay.setItems(filteredList);
    }
    @FXML
    public void SortButton(SortEvent<TableView> tableViewSortEvent) {
    }

    @FXML
    public String nameField(ActionEvent actionEvent) {
        return nameID.getText();
    }
    @FXML
    public String serialCodeField(ActionEvent actionEvent) {
        return serialCodeID.getText();
    }

    @FXML
    public String valueField(ActionEvent actionEvent) {
        return valueID.getText();
    }

    @FXML
    public void addItemButton(ActionEvent actionEvent) {
        String name = nameField(actionEvent);
        String serial = serialCodeField(actionEvent);
        String value = valueField(actionEvent);
        list.add(new Item(name, serial, value));
        System.out.println("added");
    }

    @FXML
    public void removeItemButton(ActionEvent actionEvent) {
    }

    @FXML
    public void searchNumberField(ActionEvent actionEvent) {
    }

    @FXML
    public void searchButton(ActionEvent actionEvent) {
    }

    @FXML
    public void searchName(ActionEvent actionEvent) {
    }

    @FXML
    public void editNameButton(ActionEvent actionEvent) {
    }

    @FXML
    public void editSerialCodeButton(ActionEvent actionEvent) {
    }

    @FXML
    public void editValueButton(ActionEvent actionEvent) {
    }

    @FXML
    public void fileNameField(ActionEvent actionEvent) {
    }

    @FXML
    public void fileLocationField(ActionEvent actionEvent) {
    }

    @FXML
    public void saveTSVButton(ActionEvent actionEvent) {
    }

    @FXML
    public void saveHTMLButton(ActionEvent actionEvent) {
    }

    @FXML
    public void loadTSVButton(ActionEvent actionEvent) {
    }

    @FXML
    public void loadHTMLButton(ActionEvent actionEvent) {
    }
}
