package restaurant.kundenView;

import javafx.fxml.FXML;

public class Ende extends KundenViewBean {

    @FXML
    private void handleNewSession() {
        terminal.getBestelungen().remove();
        terminal.setStart();
    }
}
