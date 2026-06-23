package de.projekt.a2;

/**
 * Warenkorb (TDD). Aktuell noch naiv: es wird nur der zuletzt hinzugefügte Preis
 * gemerkt. Das reicht für einen Artikel; mehrere Artikel folgen im nächsten Zyklus.
 */
public class Warenkorb {

    /** Vorläufig: nur der zuletzt hinzugefügte Preis. */
    private double letzterPreis = 0.0;

    /** Liefert die aktuelle Gesamtsumme des Warenkorbs. */
    public double getTotal() {
        return letzterPreis;
    }

    /** Fügt einen Artikel hinzu (noch ohne Liste/Mengen). */
    public void addItem(String name, double preis) {
        this.letzterPreis = preis;
    }
}