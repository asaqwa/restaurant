package restaurant.kundenView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import restaurant.KundenTerminal;

import java.io.IOException;

public class MengeAnfrage {
    int menge;
    Stage stage = new Stage();

    @FXML
    Label name;

    @FXML
    TextField eingabe;

    @FXML
    private void handleOK() {
        try {
            menge = Integer.parseInt(eingabe.getText());
            stage.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Falsche Eingabe.");
            alert.setContentText("Bitte geben Sie eine ganze Zahl ein.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancel() {
        stage.close();
    }

    static MengeAnfrage get(Stage primaryStage, String name) {
        Stage dialogWindow = new Stage();
        dialogWindow.setTitle("Geben Sie Menge ein:");
        dialogWindow.initModality(Modality.WINDOW_MODAL);
        dialogWindow.initOwner(primaryStage);
        FXMLLoader loader = new FXMLLoader(KundenTerminal.class.getResource("kundenView/mengeAnfrage.fxml"));
        try {
            dialogWindow.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MengeAnfrage anfrage = loader.getController();
        anfrage.stage = dialogWindow;
        anfrage.name.setText(name);
        anfrage.eingabe.setText("1");
        return anfrage;
    }
}
