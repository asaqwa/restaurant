package restaurant.model;

public class Gericht {

    private int gericht_Nr;
    private String name;
    private String zutaten;
    private double einzelpreis;
    private GerichtType type;

    public Gericht(int gericht_Nr, String name, String zutaten, double einzelpreis, GerichtType type) {
        this.gericht_Nr = gericht_Nr;
        this.name = name;
        this.zutaten = zutaten;
        this.einzelpreis = einzelpreis;
        this.type = type;
    }

    public int getGericht_Nr() {
        return gericht_Nr;
    }

    public void setGericht_Nr(int gericht_Nr) {
        this.gericht_Nr = gericht_Nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZutaten() {
        return zutaten;
    }

    public void setZutaten(String zutaten) {
        this.zutaten = zutaten;
    }

    public double getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(double einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public GerichtType getType() {
        return type;
    }

    public void setType(GerichtType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%d : %-12s %.2f", gericht_Nr, name, einzelpreis);
    }

    public String getImagePath() {
        return "assets/images/gerichte/" + type.titel + name.charAt(name.length()-1) + ".jpg";
    }
}
