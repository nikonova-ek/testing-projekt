# Einsendeaufgabe TST-E1 – Testen (Java)

Sprache: Java 21, Build mit Maven. Tests mit JUnit 5, Mutation Testing mit PIT.

Ich habe die Aufgaben A1, A2 und A4 gemacht (bei "A3 oder A4" habe ich A4 gewählt,
also Mutation Testing statt Mocking).

## A1 – Unit-Tests
Eigene Klasse `Passwortpruefer` (prüft Länge und ob eine Ziffer enthalten ist) mit
Unit-Tests. Dabei ist auch ein Test, der eine Exception prüft: bei `null` wird eine
`IllegalArgumentException` geworfen.
Liegt unter `src/main/java/de/projekt/a1/` und `src/test/java/de/projekt/a1/`.

## A2 – TDD Shopping Cart
Ein Warenkorb, im TDD-Stil entwickelt. Wichtig ist hier die Git-History: für jedes
Feature gibt es die Commits rot → grün → refactor einzeln, mit Zeitstempeln.
Man sieht den Weg im Git-Log. Methoden: addItem, getTotal, getQuantity, removeItem.
Liegt unter `src/.../a2/`.

## A4 – Mutation Testing
Mit PIT habe ich den Code aus A1 mutiert. Zwei Grenzwert-Mutanten haben überlebt
(genau 8 bzw. genau 20 Zeichen). Ich habe Zusatztests geschrieben, die sie töten.
Dadurch ist die Mutation Coverage von 76 % auf 88 % gestiegen.
- Bericht (HTML): `docs/pit-reports/index.html`
- Erklärung der Mutanten: `docs/A4_MUTATION_REPORT.md`

## KI-Nutzung
Wie ich KI benutzt habe (Prompt, Ausgabe, meine Kritik), steht in `docs/AI_NUTZUNG.md`.

## Ausführen
- Alle Tests: `mvn test`
- Mutation Testing: `mvn test-compile org.pitest:pitest-maven:mutationCoverage`
  (Bericht danach unter `target/pit-reports/index.html`)