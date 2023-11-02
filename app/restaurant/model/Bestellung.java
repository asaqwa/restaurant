package restaurant.model;

import java.util.HashMap;

public class Bestellung {

    private final HashMap<Gericht, Integer> gerichte = new HashMap<>();
    private double gesamtPreis;
    private int gesamtMenge;

    public Bestellung() {
    }

    public void setGericht(Gericht gericht, int menge) {
        gerichte.merge(gericht, menge, Integer::sum);
        gesamtMenge += menge;
        gesamtPreis += (gericht.getEinzelpreis()*menge);
        roundPreis();
    }

    public void removeGericht(Gericht gericht, int menge) {
        gerichte.merge(gericht, menge, (a,b)->a-b);
        gesamtMenge -= menge;
        gesamtPreis -= (gericht.getEinzelpreis()*menge);
        roundPreis();
    }

    public void removeGericht(Gericht gericht) {
        gesamtMenge -= gerichte.get(gericht);
        gesamtPreis -= (gericht.getEinzelpreis()*gerichte.get(gericht));
        gerichte.remove(gericht);
        roundPreis();
    }

    private void roundPreis() {
        gesamtPreis = Math.round(gesamtPreis * 100) / 100D;
    }

    public HashMap<Gericht, Integer> getGerichte() {
        return gerichte;
    }

    public double getGesamtPreis() {
        return gesamtPreis;
    }

    public int getGesamtMenge() {
        return gesamtMenge;
    }

    public boolean isLeer() {
        return gerichte.isEmpty();
    }
}
