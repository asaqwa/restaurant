package restaurant.kundenView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import restaurant.KundenTerminal;
import restaurant.model.Bestellung;
import restaurant.model.Gericht;

import java.util.Set;

public class KundenMenu extends KundenViewBean {
    @FXML
    TableView<Bestellung> tableBestellungen;
    @FXML
    TableColumn<Bestellung, String> nrColumn;
    @FXML
    TableColumn<Bestellung, String> anzahlColumn;
    @FXML
    TableColumn<Bestellung, String> bestellungsPreis;
    @FXML
    Label preisInsgesamt;
    @FXML
    Label bestellungsInfo;
    @FXML
    TableView<Gericht> tableGerichte;
    @FXML
    TableColumn<Gericht, String> gerichteColumn;
    @FXML
    TableColumn<Gericht, String> mengeColumn;
    @FXML
    TableColumn<Gericht, String> preisColumn;

    ObservableList<Bestellung> bestellungsListe;

    @Override
    public void initBean(KundenTerminal terminal) {
        super.initBean(terminal);
        bestellungsListe = FXCollections.observableArrayList(terminal.getBestelungen().getList());
        tableBestellungen.setItems(bestellungsListe);
        nrColumn.setCellValueFactory(cell-> new SimpleStringProperty(bestellungsListe.indexOf(cell.getValue())+1 + ""));
        anzahlColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getGesamtMenge() + ""));
        bestellungsPreis.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getGesamtPreis() + "€"));

        tableBestellungen.getSelectionModel().selectedItemProperty().addListener((a,o,n)-> showGerichte(n.getGerichte().keySet()));

        tableGerichte.setSelectionModel(null);
        gerichteColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getName()));
        mengeColumn.setCellValueFactory(cell-> new SimpleStringProperty(
                tableBestellungen.getSelectionModel().getSelectedItem().getGerichte().get(cell.getValue())+""));
        preisColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getEinzelpreis()+""));
        showMoney();
    }

    private void showMoney() {
        preisInsgesamt.setText( terminal.getBestelungen().getWert() + "");
    }

    private void showGerichte(Set<Gericht> gerichte) {
        tableGerichte.setItems(FXCollections.observableArrayList(gerichte));
        tableGerichte.setDisable(gerichte == null);
        bestellungsInfo.setDisable(gerichte == null);
    }

    @FXML
    private void handleBestellung() {
        terminal.setBestellung();
    }
    @FXML
    private void handleZahlen() {
        terminal.setZahlung();
    }
}
