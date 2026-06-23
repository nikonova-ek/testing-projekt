package de.projekt.a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswortprueferTest {

    private final Passwortpruefer pruefer = new Passwortpruefer();

    @Test
    void langesPasswortIstLangGenug() {
        assertTrue(pruefer.istLangGenug("geheim123"));
    }

    @Test
    void kurzesPasswortIstNichtLangGenug() {
        assertFalse(pruefer.istLangGenug("abc"));
    }

    @Test
    void normalesPasswortIstNichtZuLang() {
        assertTrue(pruefer.istNichtZuLang("geheim123"));
    }

    @Test
    void sehrLangesPasswortIstZuLang() {
        assertFalse(pruefer.istNichtZuLang("dieses-passwort-ist-viel-zu-lang"));
    }

    @Test
    void passwortMitZifferWirdErkannt() {
        assertTrue(pruefer.hatZiffer("geheim123"));
    }

    @Test
    void passwortOhneZifferWirdErkannt() {
        assertFalse(pruefer.hatZiffer("geheim"));
    }

    @Test
    void gueltigesPasswortErfuelltAlleRegeln() {
        assertTrue(pruefer.istGueltig("geheim123"));
    }

    @Test
    void passwortOhneZifferIstUngueltig() {
        assertFalse(pruefer.istGueltig("geheimwort"));
    }

    @Test
    void nullPasswortWirftException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> pruefer.istGueltig(null));
        assertEquals("Passwort darf nicht null sein.", ex.getMessage());
    }
}