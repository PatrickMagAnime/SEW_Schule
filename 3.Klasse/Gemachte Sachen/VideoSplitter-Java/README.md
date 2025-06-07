# Video Splitter

## Projektinhalt

Der **Video Splitter** ist ein Java-Programm, mit dem Videodateien unkompliziert in mehrere Abschnitte zerlegt werden können. Ziel ist eine Anwendung, die das Aufteilen von Videos nach Zeitintervallen oder benutzerdefinierten Markierungen einfach und übersichtlich macht. Neben dem Schneiden gibt es Funktionen wie die Vorschau der Segmente und das Exportieren in verschiedene Formate.

### Geplantes Konzept und Hauptablauf

- **Video auswählen:** Das gewünschte Video wird per Datei-Dialog ins Programm geladen.
- **Schnittpunkte setzen:** Über eine Zeitleiste oder direkte Eingabe können Schnittpunkte festgelegt werden.
- **Vorschau:** Die einzelnen Segmente lassen sich vor dem Export ansehen, um sicherzustellen, dass die Schnitte passen.
- **Export:** Die ausgewählten Abschnitte werden als neue Videodateien gespeichert.
- **(Optional) Automatische Szenenerkennung:** Bei Bedarf wird experimentiert, ob sich Schnittpunkte automatisch erkennen lassen.

## Aufgabenverteilung

Wir sind ein Team aus **Patrick Riedl** und **Nikola Logofetic**.

- **Nikola** ist hauptsächlich für die grafische Benutzeroberfläche (GUI) zuständig und kümmert sich um das Bedienkonzept und die Dokumentation.
- **Patrick** übernimmt die technische Umsetzung der Videobearbeitung – insbesondere das Schneiden, das Handling der Videodateien und den Export. Außerdem betreut er die Einbindung und das Testen neuer Features.

## Umsetzung der Anforderungen

### Mindestanforderungen

- **2er Team:** Projekt wird von Patrick Riedl und Nikola Logofetic gemeinsam umgesetzt.
- **Thema:** Videobearbeitung/Graphics.
- **Mindestens 4 Klassen:**  
  - Beispiel: `VideoLoader`, `VideoSplitter`, `ExportManager`, `MainWindow` (GUI zählt nicht als Klasse).
- **Mindestens 2 Packages:**  
  - Das Projekt ist in sinnvolle Packages (z.B. `logic`, `ui`) organisiert.
- **Vererbung:**  
  - Verschiedene Export-Strategien oder Schnittmethoden werden über Vererbung/Interfaces implementiert.
- **Datenspeicherung:**  
  - Schnittdaten und Einstellungen werden in einer Datei (z.B. JSON) gespeichert und wieder geladen.
- **Fehlerabfangen:**  
  - Fehler wie ungültige Dateien, nicht unterstützte Formate oder fehlgeschlagene Exporte werden per Exception Handling abgefangen und benutzerfreundlich angezeigt.
- **Benutzereingabe/Interaktion:**  
  - Das Setzen von Schnittpunkten, das Laden/Speichern von Dateien und die Steuerung der Vorschau erfolgt durch aktive Benutzereingaben.
- **2 GUI-Fenster:**  
  - Es gibt z.B. ein Hauptfenster und ein separates Fenster für die Vorschau oder die Schnitteinstellungen.
- **Dialogfenster:**  
  - Datei-Dialoge für Laden/Speichern sowie Hinweis- und Fehlermeldungen sind als Dialogfenster umgesetzt.
- **Graphics:**  
  - Die Anwendung arbeitet mit Videodateien und zeigt Vorschaubilder bzw. eine Zeitleiste mit Thumbnails an.
- **Dokumentation:**  
  - Das Projekt ist dokumentiert (README, Kommentare im Code).

### Zusätzliche Anforderungen (mindestens eine umgesetzt)

- **Verwendung von externen Libraries:**  
  - Für das Laden, Schneiden und Exportieren der Videodateien wird eine externe Bibliothek genutzt (z.B. FFmpeg, gson).
- **(Optional) Enum:**  
  - An bestimmten Stellen, etwa für Export-Formate oder Statusanzeigen, kommen Enums zum Einsatz.

## Zusätzliche Features & Vorgehensweise

- **Szenenerkennung:** Wir testen, ob wir eine automatische Erkennung von Szenen/Schnittpunkten einbauen können.
- **Fortschrittsanzeige:** Während des Schneidens wird der aktuelle Fortschritt angezeigt.
- **Benutzerfreundlichkeit:** Das Programm ist so gestaltet, dass auch technisch weniger versierte Nutzer es bedienen können.

