package restaurant.model;

import java.util.ArrayList;

public class Bestellung_Liste {
private ArrayList<Bestellung> bestellung_Liste= new ArrayList<>();
private double summe;

    public Bestellung_Liste(ArrayList<Bestellung> bestellung_Liste, double  summe) {
        this.bestellung_Liste = bestellung_Liste;
        setSumme();
    }

    public ArrayList<Bestellung> getBestellung_Liste() {
        return bestellung_Liste;
    }

    public void setBestellung_Liste(Bestellung B) {
        bestellung_Liste.add(B);
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme() {
        this.summe = summe +bestellung_Liste.get(0).getGesamtepreis();
    }

    @Override
    public String toString() {
        return String.format("%s\n\t\t\t\t\t\t%.2f", bestellung_Liste,summe);
    }

}
