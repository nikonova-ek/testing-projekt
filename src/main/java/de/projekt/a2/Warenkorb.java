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
        return (int) positionen.stream()
                .filter(p -> p.name().equals(name))
                .count();
    }
    public void removeItem(String name) {
        for (int i = 0; i < positionen.size(); i++) {
            if (positionen.get(i).name().equals(name)) {
                positionen.remove(i);
                return;
            }
        }
    }
}