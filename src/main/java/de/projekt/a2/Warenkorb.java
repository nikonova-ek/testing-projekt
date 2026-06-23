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
        return positionen.stream()
                .mapToDouble(Position::preis)
                .sum();
    }
    public void addItem(String name, double preis) {
        positionen.add(new Position(name, preis));
    }
    public int getQuantity(String name) {
        int anzahl = 0;
        for (Position p : positionen) {
            if (p.name().equals(name)) {
                anzahl++;
            }
        }
        return anzahl;
    }
}