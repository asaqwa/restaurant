package restaurant.model;
public class Bestellung {

    private Gericht gericht;
    private int menge;
    double gesamtepreis;

    public Bestellung() {
        setGesamtepreis();
    }

    public Bestellung(Gericht gericht, int menge) {
        this.gericht = gericht;
        this.menge = menge;
        setGesamtepreis();
    }

    public Gericht getGericht() {
        return gericht;
    }

    public void setGericht(Gericht gericht) {
        this.gericht = gericht;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public double getGesamtepreis() {
        return gesamtepreis;
    }

    public void setGesamtepreis() {
        this.gesamtepreis = menge*gericht.getEinzelpreis();
    }

    @Override
    public String toString() {
        return String.format("%S\t\t%d\t\t\t%.2f", gericht, menge, gesamtepreis);
    }

}
