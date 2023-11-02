package restaurant.kundenView;

import javafx.fxml.FXML;

public class Start extends KundenViewBean {

    @FXML
    private void handleStart() {
        terminal.setBestellung();
    }
}
