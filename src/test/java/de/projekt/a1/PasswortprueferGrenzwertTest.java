package de.projekt.a1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A4 – Zusatztests, die die ueberlebenden Grenzwert-Mutanten toeten.
 *
 * Mutant 1: istLangGenug, ">=" wird zu ">" (changed conditional boundary).
 * Mutant 2: istNichtZuLang, "<=" wird zu "<" (changed conditional boundary).
 *
 * Die urspruenglichen Tests pruefen nur Laengen klar ueber/unter dem Limit,
 * nie genau die Grenze (8 bzw. 20). Genau diese Grenzfaelle toeten die Mutanten.
 */
class PasswortprueferGrenzwertTest {

    private final Passwortpruefer pruefer = new Passwortpruefer();

    @Test
    @DisplayName("genau 8 Zeichen ist lang genug (toetet >= -> >)")
    void genauMindestlaenge() {
        assertTrue(pruefer.istLangGenug("12345678")); // genau 8 Zeichen
    }

    @Test
    @DisplayName("7 Zeichen ist nicht lang genug")
    void einsUnterMindestlaenge() {
        assertFalse(pruefer.istLangGenug("1234567")); // 7 Zeichen
    }

    @Test
    @DisplayName("genau 20 Zeichen ist nicht zu lang (toetet <= -> <)")
    void genauMaximallaenge() {
        assertTrue(pruefer.istNichtZuLang("12345678901234567890")); // genau 20 Zeichen
    }

    @Test
    @DisplayName("21 Zeichen ist zu lang")
    void einsUeberMaximallaenge() {
        assertFalse(pruefer.istNichtZuLang("123456789012345678901")); // 21 Zeichen
    }
}