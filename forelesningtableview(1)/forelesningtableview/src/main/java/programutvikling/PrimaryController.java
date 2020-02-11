package programutvikling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    TextField txtField, intField;

    @FXML
    private TextField txtMobil;

    @FXML
    private TextField txtEpost;

    @FXML
    private TextField intDag;

    @FXML
    private TextField intMnd;

    @FXML
    private TextField intÅr;

    @FXML
    TableView tableView;

    @FXML
    TableColumn<DataModel, Integer> intAlderColumn;

    @FXML
    private TableColumn<?, ?> intMobilColumn;

    @FXML
    private TableColumn<?, ?> intEpostColumn;

    @FXML
    private TableColumn<?, ?> intFødtdatoColumn;

    private DataCollection collection = new DataCollection();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        collection.attachTableView(tableView);

        intAlderColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    @FXML
    private void addElemBtnClicked() {
        DataModel obj = createDataModelObjectFromGUI();

        if(obj != null) {
            resetTxtFields();
            collection.addElement(obj);
        }
    }

    private DataModel createDataModelObjectFromGUI() {
        String txt = txtField.getText();
        try {
            int i = Integer.parseInt(intField.getText());
            return new DataModel(txt, i);
        } catch (IllegalArgumentException e) {
            intField.setText("<< Input here must be a positive number! >>");
            return null;
        }
    }

    private void resetTxtFields() {
        txtField.setText("");
        intField.setText("");
    }

    @FXML
    private void txtNavnEdited(TableColumn.CellEditEvent<DataModel, String> event) {
        event.getRowValue().setTxtNavn(event.getNewValue());
    }

    @FXML
    private void intAlderEdited(TableColumn.CellEditEvent<DataModel, Integer> event) {
        if(IntegerStringConverter.conversionSuccessful) {
            try {
                event.getRowValue().setIntAlder(event.getNewValue());
            } catch (IllegalArgumentException e) {
                programutvikling.gui.Dialogs.showErrorDialog("Du kan ikke taste inn et negativt tall!");
            }
        }

        tableView.refresh();
    }

    @FXML
    void intEpostEdited(ActionEvent event) {

    }

    @FXML
    void intFødtdatoEdited(ActionEvent event) {

    }

    @FXML
    void intMobilEdited(ActionEvent event) {

    }

    @FXML
    void txtNavnEdited(ActionEvent event) {

    }

}
