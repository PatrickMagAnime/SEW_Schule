import java.io.Serializable;

public class Karteikarte implements Serializable {
    private String frage;
    private String antwort;
    private boolean gelernt;
    private int anzahlGefragt;
    private int anzahlRichtig;

    public Karteikarte(String frage, String antwort) {
        this.frage = frage;
        this.antwort = antwort;
        this.gelernt = false;
        this.anzahlGefragt = 0;
        this.anzahlRichtig = 0;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public boolean isGelernt() {
        return gelernt;
    }

    public int getAnzahlGefragt() {
        return anzahlGefragt;
    }

    public void incrementAnzahlGefragt() {
        this.anzahlGefragt++;
    }

    public int getAnzahlRichtig() {
        return anzahlRichtig;
    }

    public void incrementAnzahlRichtig() {
        this.anzahlRichtig++;
        if (anzahlRichtig >= 3) {
            this.gelernt = true;
        }
    }

    @Override
    public String toString() {
        return "Frage: " + frage + " | Antwort: " + antwort + " | Gelernt: " + gelernt;
    }
}