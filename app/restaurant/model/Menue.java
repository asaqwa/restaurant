package restaurant.model;

import java.util.ArrayList;
import static restaurant.model.GerichtType.*;

public class Menue {
    private ArrayList<Gericht> menue= new ArrayList<>();

    {
        String lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has";
        menue.add(new Gericht(1, "Vorspeise 1", lorem, 8.99, Vorspeise));
        menue.add(new Gericht(2, "Vorspeise 2", lorem, 7.99, Vorspeise));
        menue.add(new Gericht(3, "Vorspeise 3", lorem, 6.99, Vorspeise));
        menue.add(new Gericht(4, "Hauptgericht 1", lorem, 14.99, Hauptgericht));
        menue.add(new Gericht(5, "Hauptgericht 2", lorem, 15.99, Hauptgericht));
        menue.add(new Gericht(6, "Hauptgericht 3", lorem, 6.99, Hauptgericht));
        menue.add(new Gericht(7, "Hauptgericht 4", lorem, 11.99, Hauptgericht));
        menue.add(new Gericht(8, "Nachspeise 1", lorem, 7.99, Nachspeise));
        menue.add(new Gericht(9, "Nachspeise 2", lorem, 4.99, Nachspeise));
        menue.add(new Gericht(10, "Nachspeise 3", lorem, 3.99, Nachspeise));
        menue.add(new Gericht(11, "Kindermenü 1", lorem, 5.99, Kindermenue));
        menue.add(new Gericht(12, "Kindermenü 2", lorem, 4.99, Kindermenue));
        menue.add(new Gericht(13, "Kindermenü 3", lorem, 4.99, Kindermenue));
        menue.add(new Gericht(14, "Getränk 1", lorem, 8.99, Getraenk));
        menue.add(new Gericht(15, "Getränk 2", lorem, 8.99, Getraenk));
        menue.add(new Gericht(16, "Getränk 3", lorem, 8.99, Getraenk));
        menue.add(new Gericht(17, "Alkohol 1", lorem, 8.99, Alkohol));
        menue.add(new Gericht(18, "Alkohol 2", lorem, 8.99, Alkohol));
        menue.add(new Gericht(19, "Alkohol 3", lorem, 8.99, Alkohol));
    }

    public ArrayList<Gericht> getMenue() {
        return menue;
    }

    public void setMenue(Gericht G) {
        this.menue.add(G);
    }

    @Override
    public String toString() {
        return String.format("%s", menue);
    }

}
