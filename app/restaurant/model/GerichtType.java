package restaurant.model;

public enum GerichtType {
    Vorspeise("vorspeisen/vorspeise "),
    Hauptgericht("hauptgerichte/hauptgericht "),
    Nachspeise("nachspeisen/nachspeise "),
    Kindermenue("kindermenue/kind "),
    Getraenk("getraenke/getraenk "),
    Alkohol("alkohol/alkohol ");

    public final String titel;
    GerichtType(String titel) {
        this.titel = titel;
    }
}
