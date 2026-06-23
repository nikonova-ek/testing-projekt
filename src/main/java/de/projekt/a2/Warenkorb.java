package de.projekt.a2;

public class Warenkorb {

    // vorläufig: nur der zuletzt hinzugefügte Preis
    private double letzterPreis = 0.0;

    public double getTotal() {
        return letzterPreis;
    }

    public void addItem(String name, double preis) {
        this.letzterPreis = preis;
    }
}