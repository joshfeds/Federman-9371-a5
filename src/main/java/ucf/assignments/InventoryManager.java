package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InventoryManager {

    public ObservableList<Item> list = FXCollections.observableArrayList();
    public FilteredList<Item> filteredList = new FilteredList<>(list);
    public SortedList<Item> sortedList = new SortedList<>(filteredList);
    @FXML public TextField nameID;

    @FXML public TextField serialCodeID;

    @FXML public TextField valueID;

    @FXML public TextField searchNumberID;

    @FXML public TextField searchNameID;

    @FXML public TextField fileNameID;

    @FXML public TextField fileLocationID;

    @FXML public TableView<Item> tableView;

    @FXML public TextField editItem;

    @FXML private TableColumn<Item, String> nameColumn;

    @FXML private TableColumn<Item, String> serialColumn;

    @FXML private TableColumn<Item, String> valueColumn;

    public SearchItem searchItem = new SearchItem();

    public ValidateItem validateItem = new ValidateItem();

    @FXML
    public void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Serial"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Value"));
        tableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());
    }
    @FXML
    public void SortButton(SortEvent<TableView<Item>> tableViewSortEvent) {
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
    public String searchNumberField(ActionEvent actionEvent) {
        return searchNumberID.getText();
    }
    @FXML
    public String searchNameField(ActionEvent actionEvent) {
        return searchNameID.getText();
    }
    @FXML
    public String editItemField(ActionEvent actionEvent) {
        return editItem.getText();
    }
    @FXML
    public String fileNameField(ActionEvent actionEvent) {
        return fileNameID.getText();
    }

    @FXML
    public String fileLocationField(ActionEvent actionEvent) {
        return fileLocationID.getText();
    }
    @FXML
    public void addItemButton(ActionEvent actionEvent) {
        String name = nameField(actionEvent);
        String serial = serialCodeField(actionEvent);
        String value = valueField(actionEvent);
        if(validateItem.addItem(name, serial, value, list)){
            String asDollar = validateItem.formatToDollar(value);
            list = validateItem.addToList(name, serial, asDollar, list);
        }
        else{
            Label label = new Label("Error Window");

        }
    }

    @FXML
    public void removeItemButton(ActionEvent actionEvent) {
        int focusedIndex = tableView.getFocusModel().getFocusedIndex();
        if(focusedIndex > -1){
            int sourceIndex = sortedList.getSourceIndex(focusedIndex);
            list.remove(sourceIndex);
        }
    }
    @FXML
    public void searchNameButton(ActionEvent actionEvent) {
        String key = searchNameField(actionEvent);
        filteredList.setPredicate(item -> searchItem.nameExists(key, item));
    }
    @FXML
    public void searchNumberButton(ActionEvent actionEvent) {
        String key = searchNumberField(actionEvent);
        filteredList.setPredicate(item -> searchItem.serialExists(key, item));
    }
    @FXML
    public void editNameButton(ActionEvent actionEvent) {
        Item item = getCurrentItem();
        String name = editItemField(actionEvent);
        if(validateItem.isName(name)){
            item.setName(name);
            tableView.refresh();
        }
    }

    @FXML
    public void editSerialCodeButton(ActionEvent actionEvent) {
        Item item = getCurrentItem();
        String serial = editItemField(actionEvent);
        if(validateItem.isSerial(serial, list)){
            item.setName(serial);
            tableView.refresh();
        }
    }

    @FXML
    public void editValueButton(ActionEvent actionEvent) {
        Item item = getCurrentItem();
        String value = editItemField(actionEvent);
        if(validateItem.isValue(value)){
            item.setName(value);
            tableView.refresh();
        }
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
    public Item getCurrentItem(){
        //grabs index within listView
        int focusedIndex = tableView.getFocusModel().getFocusedIndex();
        //sends index of the item and retuns
        Item item = tableView.getItems().get(focusedIndex);
        return item;
    }


}
