package zusatzaufgaben;

public enum Kategorie {
    DEUTSCH, ENGLISCH, MATHEMATIK, NETZWERKTECHNIK, SYSTEMTECHNIK, INFORMATIONSSYSTEME, GEOGRAPHIE_GESCHICHTE_POLITISCHE_BILDUNG, NATURWISSENSCHAFTEN, TURNEN, ETHIK_RELIGION, MEDIENTECHNIK, IT_SECURITY, SOFTWAREENTWICKLUNG, INFORMATIONSTECHNISCHE_PROJEKTE;

    // Anmerkung: Die Enum-Werte sind in Großbuchstaben geschrieben, um den Konventionen für Enum-Namen zu entsprechen. Um die Lesbarkeit zu erhöhen, könnten Sie auch eine Methode hinzufügen, die den Enum-Wert in ein lesbares Format umwandelt (z.B. durch Ersetzen von Unterstrichen mit Leerzeichen und Umwandeln in Kleinbuchstaben). Dies könnte nützlich sein, wenn Sie die Werte in einer Benutzeroberfläche anzeigen möchten.



    // Beispiel für eine solche Methode die den Enum-Wert in ein lesbares Format umwandelt:

     public String getDisplayName() {
        String bezeichnung = this.name().replace("_", " ").toLowerCase(); // Unterstriche durch Leerzeichen ersetzen und in Kleinbuchstaben umwandeln
        // Capitalize -> jeder Wortanfang wird großgeschrieben auf eine kompliziertere Art
        String[] worte = bezeichnung.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String wort : worte) {
            sb.append(Character.toUpperCase(wort.charAt(0))).append(wort.substring(1)).append(" "); // Erstes Zeichen groß und Rest bleibt gleich
        }
        return sb.toString().trim(); // Entfernt das letzte Leerzeichen
     }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
