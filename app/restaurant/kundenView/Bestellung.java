package restaurant.kundenView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import restaurant.KundenTerminal;
import restaurant.model.Gericht;

import static restaurant.model.GerichtType.*;

public class Bestellung extends KundenViewBean {
    restaurant.model.Bestellung bestellung = new restaurant.model.Bestellung();

    @FXML
    Label name;
    @FXML
    Label zutaten;
    @FXML
    Label einzelpreis;
    @FXML
    ImageView image;
    @FXML
    Label anzahlGerichte;
    @FXML
    Label preisBestellung;
    @FXML
    Label presInsgesamt;
    @FXML
    Button buttonHinzufuegen;
    @FXML
    Button buttonBestellen;

    @FXML
    ListView<Gericht> gerichtsListe;

    private final ObservableList<Gericht> vorspeisen = FXCollections.observableArrayList();
    private final ObservableList<Gericht> hauptgerichte = FXCollections.observableArrayList();
    private final ObservableList<Gericht> nachspeisen = FXCollections.observableArrayList();
    private final ObservableList<Gericht> kindermenue = FXCollections.observableArrayList();
    private final ObservableList<Gericht> getraenke = FXCollections.observableArrayList();
    private final ObservableList<Gericht> alkohol = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        gerichtsListe.getSelectionModel().selectedItemProperty().addListener((o,a,n)-> showGericht(n));
        showGericht(null);
    }

    @Override
    public void initBean(KundenTerminal terminal) {
        super.initBean(terminal);
        showBestellung();
        vorspeisen.addAll(terminal.getMenue().stream().filter(g -> Vorspeise == g.getType()).toArray(Gericht[]::new));
        hauptgerichte.addAll(terminal.getMenue().stream().filter(g -> Hauptgericht == g.getType()).toArray(Gericht[]::new));
        nachspeisen.addAll(terminal.getMenue().stream().filter(g -> Nachspeise == g.getType()).toArray(Gericht[]::new));
        kindermenue.addAll(terminal.getMenue().stream().filter(g -> Kindermenue == g.getType()).toArray(Gericht[]::new));
        getraenke.addAll(terminal.getMenue().stream().filter(g -> Getraenk == g.getType()).toArray(Gericht[]::new));
        alkohol.addAll(terminal.getMenue().stream().filter(g -> Alkohol == g.getType()).toArray(Gericht[]::new));
    }

    @FXML
    private void handleAbbrechen() {
        if (terminal.getBestelungen().isLeer()) {
            terminal.setStart();
        } else {
            terminal.setKundenMenu();
        }
    }

    @FXML
    private void handleHinzufuegen() {
        Gericht selectedGericht = gerichtsListe.getSelectionModel().getSelectedItem();
        MengeAnfrage anfrage = MengeAnfrage.get(terminal.getPrimaryStage(), selectedGericht.getName());
        anfrage.stage.showAndWait();
        if (anfrage.menge>0) {
            bestellung.setGericht(selectedGericht, anfrage.menge);
        }
        showBestellung();
    }

    @FXML
    private void handleBestellen() {
        terminal.getBestelungen().add(bestellung);
        terminal.setKundenMenu();
    }

    @FXML
    private void handleVorspeisen() {
        gerichtsListe.setItems(vorspeisen);
    }

    @FXML
    private void handleHauptgerichte() {
        gerichtsListe.setItems(hauptgerichte);
    }
    @FXML
    private void handleNachspeisen() {
        gerichtsListe.setItems(nachspeisen);
    }
    @FXML
    private void handleKindermenue() {
        gerichtsListe.setItems(kindermenue);
    }
    @FXML
    private void handleGetraenke() {
        gerichtsListe.setItems(getraenke);
    }
    @FXML
    private void handleAlkohol() {
        gerichtsListe.setItems(alkohol);
    }

    private void showGericht(Gericht gericht) {
        if (gericht != null) {
            name.setText(gericht.getName());
            zutaten.setText(gericht.getZutaten());
            einzelpreis.setText("" + gericht.getEinzelpreis());

            String path = KundenTerminal.class.getResource(gericht.getImagePath()).toString();
            image.setImage(new Image(path));
            buttonHinzufuegen.setDisable(false);
        } else {
            name.setText("");
            zutaten.setText("");
            einzelpreis.setText("");
            image.setImage(null);
            buttonHinzufuegen.setDisable(true);
        }
    }
    
    private void showBestellung() {
        anzahlGerichte.setText(String.valueOf(bestellung.getGesamtMenge()));
        preisBestellung.setText(bestellung.getGesamtPreis() + "€");
        presInsgesamt.setText(terminal.getBestelungen().getWert() + bestellung.getGesamtPreis() + "€");
        if (!bestellung.isLeer() && buttonBestellen.isDisable()) buttonBestellen.setDisable(false);
    }
}
