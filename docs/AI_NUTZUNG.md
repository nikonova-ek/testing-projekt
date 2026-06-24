# Nutzung von KI

Ich habe die KI als Schritt-für-Schritt-Tutor benutzt, die mir bei jedem TDD-Schritt
geholfen hat. Hier lege ich offen, wie ich sie eingesetzt habe und welche Kritik ich
selbst beigesteuert habe.

Verwendetes KI-Werkzeug: Claude (Anthropic).

## Wie ich die KI benutzt habe
Ich habe nicht einfach einen fertigen Warenkorb generieren lassen, sondern das Projekt
selbst in IntelliJ Schritt für Schritt aufgebaut. Die KI hat mir bei jedem Schritt
erklärt, was zu tun ist (welche Klasse, welcher Test, welcher Commit) und worauf ich
achten muss. Ein typischer Einstieg sah z. B. so aus:

> "Schreib mir in Java einen Warenkorb (Shopping Cart) mit addItem, getTotal,
> getQuantity und removeItem, dazu passende JUnit-5-Tests."

Eine solche KI-Antwort liefert aber nur den fertigen Endzustand und den normalen Fall
("Happy Path"). Genau deshalb habe ich vieles selbst ergänzt und korrigiert.

## Was ich selbst ergänzt / korrigiert habe

- **Echte TDD-History.** Statt den Code in einem Stück zu übernehmen, habe ich für
  jedes Feature die Schritte rot → grün → refactor als einzelne Commits gemacht. In
  einem Schritt habe ich extra erst eine "falsche" einfache Lösung geschrieben (nur der
  letzte Preis wird gespeichert), damit der Test mit mehreren Artikeln wirklich
  fehlschlägt – so wird man gezwungen, eine richtige Liste zu benutzen.

- **removeItem.** Eine naive Lösung hätte mit `removeIf` alle gleichen Artikel auf
  einmal entfernt. Ich entferne absichtlich nur einen, sonst stimmt die Anzahl danach
  nicht.

- **Grenzfälle.** Beim Passwortprüfer (A1) waren am Anfang nur Werte klar über oder
  unter dem Limit getestet, aber nie genau die Grenze (8 oder 20 Zeichen). Das ist mir
  erst durch das Mutation Testing (A4) aufgefallen – da haben genau diese Mutanten
  überlebt. Ich habe dann Tests für genau 8 und genau 20 Zeichen ergänzt.

- **Exception.** Den Test für `null` (mit `IllegalArgumentException`) habe ich
  dazugeschrieben.

## Fazit
Die KI war ein guter Tutor für Erklärungen, Gerüst und den normalen Fall. Die richtige
Test-Arbeit – TDD-Schritte, Grenzfälle, Exceptions und die Lücken, die das Mutation
Testing gefunden hat – habe ich selbst umgesetzt.