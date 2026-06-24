# A4 – Mutation Testing (PIT)

## Werkzeug & Ausführung
- Tool: **PIT / PITest** (pitest-maven 1.16.1, pitest-junit5-plugin 1.2.1), konfiguriert in `pom.xml`.
- Ausgeführt mit:
  mvn test-compile org.pitest:pitest-maven:mutationCoverage
- - Der HTML-Report liegt unter `docs/pit-reports/index.html` (Original: `target/pit-reports/`).
- Gemutierte Klasse: `de.projekt.a1.Passwortpruefer`.

## Was ist ein überlebender Mutant?
PIT verändert den Produktivcode minimal (z. B. `>=` zu `>`) und führt danach die Tests aus.
Schlägt mindestens ein Test fehl, gilt der Mutant als *getötet* (killed). Laufen alle Tests
trotz der Änderung grün durch, hat der Mutant *überlebt* (survived) – ein Hinweis auf eine
Testlücke.

## Ergebnis
- Erster Lauf: **Mutation Coverage 76 % (13/17 getötet)** – 4 Mutanten überlebten.
- Nach Ergänzung der Grenzwert-Tests: **Mutation Coverage 88 % (15/17 getötet)**.
- Die Line Coverage war durchgehend 100 % – das zeigt: Code wird zwar ausgeführt, aber nicht
  scharf genug geprüft. Genau das macht Mutation Testing sichtbar.

## Kommentierte überlebende Mutanten

### Mutant 1 – Mindestlänge (Conditionals Boundary), Zeile 10
- Stelle: `istLangGenug`, Bedingung `passwort.length() >= MIN_LAENGE`.
- Mutation: `>=` wird zu `>` ("changed conditional boundary").
- Bedeutung: Der mutierte Code würde ein Passwort von **genau 8 Zeichen** (== MIN_LAENGE)
  fälschlich als zu kurz ablehnen. Die ursprünglichen Tests prüfen nur 9 Zeichen (klar darüber)
  und 3 Zeichen (klar darunter), nie genau die Grenze – deshalb überlebte der Mutant.
- Tötender Test: `assertTrue(pruefer.istLangGenug("12345678"));` (genau 8 Zeichen muss `true`
  sein). Siehe `PasswortprueferGrenzwertTest.genauMindestlaenge()`.

### Mutant 2 – Maximallänge (Conditionals Boundary), Zeile 15
- Stelle: `istNichtZuLang`, Bedingung `passwort.length() <= MAX_LAENGE`.
- Mutation: `<=` wird zu `<`.
- Bedeutung: Ein Passwort von **genau 20 Zeichen** (== MAX_LAENGE) würde fälschlich als zu lang
  abgelehnt. Auch diese Grenze wurde ursprünglich nicht getestet – der Mutant überlebte.
- Tötender Test: `assertTrue(pruefer.istNichtZuLang("12345678901234567890"));` (genau 20 Zeichen
  muss `true` sein). Siehe `PasswortprueferGrenzwertTest.genauMaximallaenge()`.

### Verbleibende Mutanten (Zeile 14 und 19) – bewusst nicht getötet
- Stelle: entfernter Aufruf von `pruefeNichtNull` in `istNichtZuLang` bzw. `hatZiffer`.
- Mutation: "removed call to pruefeNichtNull".
- Bedeutung: Diese Mutanten überleben, weil die `null`-Prüfung bisher nur über `istGueltig(null)`
  getestet wird, nicht für jede Einzelmethode. Sie ließen sich durch zusätzliche Exception-Tests
  pro Methode töten. Für diese Aufgabe wurden bewusst zwei Mutanten kommentiert und getötet;
  diese beiden bleiben als dokumentierte Lücke bestehen.

## Fazit
Mutation Testing hat zwei echte Grenzwert-Lücken aufgedeckt, die durch reine Line Coverage
unsichtbar geblieben wären. Die gezielten Boundary-Tests (genau 8 / genau 20 Zeichen) schließen
sie und heben die Mutation Coverage von 76 % auf 88 %.