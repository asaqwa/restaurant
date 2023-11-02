package restaurant.kundenView;

import javafx.fxml.FXML;

public class Bezahlung extends KundenViewBean {

    @FXML
    private void handleZahlenAusgewaehlte() {
    }
    @FXML
    private void handleZahlenAlle() {
        terminal.setEnde();
    }
}
