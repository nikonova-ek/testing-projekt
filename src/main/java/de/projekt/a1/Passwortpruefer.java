package de.projekt.a1;

public class Passwortpruefer {

    public static final int MIN_LAENGE = 8;
    public static final int MAX_LAENGE = 20;

    public boolean istLangGenug(String passwort) {
        pruefeNichtNull(passwort);
        return passwort.length() >= MIN_LAENGE;
    }

    public boolean istNichtZuLang(String passwort) {
        pruefeNichtNull(passwort);
        return passwort.length() <= MAX_LAENGE;
    }

    public boolean hatZiffer(String passwort) {
        pruefeNichtNull(passwort);
        for (char c : passwort.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean istGueltig(String passwort) {
        return istLangGenug(passwort) && istNichtZuLang(passwort) && hatZiffer(passwort);
    }

    private void pruefeNichtNull(String passwort) {
        if (passwort == null) {
            throw new IllegalArgumentException("Passwort darf nicht null sein.");
        }
    }
}