package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryManager {

    public ObservableList<Item> list = FXCollections.observableArrayList();

    @FXML public TextField nameID;

    @FXML public TextField serialCodeID;

    @FXML public TextField valueID;

    @FXML public TextField searchNumberID;

    @FXML public TextField searchItemID;

    @FXML public TextField fileNameID;

    @FXML public TextField fileLocationID;

    @FXML public TableView<Item> tableView;

    @FXML private TableColumn<Item, String> nameColumn;

    @FXML private TableColumn<Item, String> serialColumn;

    @FXML private TableColumn<Item, String> valueColumn;

    public ControlMenu controlMenu = new ControlMenu();
    @FXML
    public void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Serial"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Value"));
        tableView.setItems(list);
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
        if(controlMenu.addItem(name, serial, value, list)){
            String asDollar = controlMenu.formatToDollar(value);
            list.add(new Item(name, serial, asDollar));
        }

    }

    @FXML
    public void removeItemButton(ActionEvent actionEvent) {
        int focusedIndex = tableView.getFocusModel().getFocusedIndex();
        if(focusedIndex > -1)
            list.remove(focusedIndex);
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
