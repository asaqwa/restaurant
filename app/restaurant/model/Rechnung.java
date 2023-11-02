package restaurant.model;

import java.util.ArrayList;

public class Rechnung extends Bestellung_Liste implements Kasse{
    private int rechnung_Nr;

    public Rechnung(int rechnung_Nr, ArrayList<Bestellung> bestellung_Liste, double summe) {
        super(bestellung_Liste, summe);
        this.rechnung_Nr = rechnung_Nr;
    }

 
    public int getRechnung_Nr() {
        return rechnung_Nr;
    }

    public void setRechnung_Nr(int rechnung_Nr) {
        this.rechnung_Nr = rechnung_Nr;
    }

    @Override
    public void speichern() {
        System.out.println("es wird zum kasse gelifert und gespeichert");
    }

}
