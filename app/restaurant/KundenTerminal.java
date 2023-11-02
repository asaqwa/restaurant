package restaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import restaurant.kundenView.KundenViewBean;
import restaurant.model.Bestellung;
import restaurant.model.Gericht;
import restaurant.model.Menue;
import restaurant.model.Session;

public class KundenTerminal extends Application {
    Stage primaryStage;
    BorderPane rootPane;

    private final ArrayList<Gericht> menue = new Menue().getMenue();

    Session bestelungen ;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        bestelungen = new Session();

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Kundenterminal");

        rootPane = new BorderPane();
        rootPane.setPrefWidth(615);
        this.primaryStage.setScene(new Scene(rootPane));
        setStart();
        primaryStage.show();
    }


    private void setScreen(String path) {
        FXMLLoader loader = new FXMLLoader(KundenTerminal.class.getResource(path));
        try {

            rootPane.setCenter(loader.load());
            KundenViewBean bean = loader.getController();
            bean.initBean(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setStart() {
        setScreen("kundenView/start.fxml");
    }

    public void setBestellung() {
        setScreen("kundenView/bestellung.fxml");
    }

    public void setKundenMenu() {
        setScreen("kundenView/kundenMenu.fxml");
    }

    public void setZahlung() {
        setScreen("kundenView/bezahlung.fxml");
    }

    public void setEnde() {
        setScreen("kundenView/ende.fxml");
    }

    public ArrayList<Gericht> getMenue() {
        return menue;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Session getBestelungen() {
        return bestelungen;
    }
}
