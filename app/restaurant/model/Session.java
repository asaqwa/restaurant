package restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Session {
    ArrayList<Bestellung> bestellungen = new ArrayList<>();
    double wert;


    public double getWert() {
        return wert;
    }

    public void add(Bestellung bestellung) {
        bestellungen.add(bestellung);
        wert += bestellung.getGesamtPreis();
    }

    public boolean isLeer() {
        return bestellungen.isEmpty();
    }

    public void remove() {
        bestellungen.clear();
        wert = 0;
    }

    public void remove(List<Bestellung> bestellungen) {
        bestellungen.forEach(this::remove);
    }

    public void remove(Bestellung bestellung) {
        wert = Math.round((wert - bestellung.getGesamtPreis()) * 100) / 100D;
        this.bestellungen.remove(bestellung);
    }

    public ArrayList<Bestellung> getList() {
        return bestellungen;
    }
}
