package restaurant.kundenView;

import restaurant.KundenTerminal;

public abstract class KundenViewBean {
    KundenTerminal terminal;

    public void initBean(KundenTerminal terminal) {
        this.terminal = terminal;
    }
}
