package restaurant.kundenView;

import javafx.fxml.FXML;

public class KundenMenu extends KundenViewBean {

    @FXML
    private void handleBestellung() {
        terminal.setBestellung();
    }
    @FXML
    private void handleZahlen() {
        terminal.setZahlung();
    }
}
