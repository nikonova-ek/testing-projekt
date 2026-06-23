package de.projekt.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * Warenkorb (TDD). Speichert die Artikel als Liste von Positionen
 * und summiert beim getTotal() über alle Preise.
 */
public class Warenkorb {

    private final List<Position> positionen = new ArrayList<>();

    public double getTotal() {
        double summe = 0.0;
        for (Position p : positionen) {
            summe += p.preis();
        }
        return summe;
    }

    public void addItem(String name, double preis) {
        positionen.add(new Position(name, preis));
    }
}