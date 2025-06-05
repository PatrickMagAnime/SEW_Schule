package hauptanforderungen.mittextarea.comboboxjoptionpane;

public class Karte {
    private String frage;
    private String antwort;
    private boolean gelernt;
    private int anzahlGefragt;
    private int anzahlRichtig;

    public Karte(String frage, String antwort, boolean gelernt, int anzahlGefragt, int anzahlRichtig) {
        this.frage = frage;
        this.antwort = antwort;
        this.anzahlGefragt = anzahlGefragt;
        this.anzahlRichtig = anzahlRichtig;
        this.gelernt = this.checkGelernt();
    }

    public String toString() {
        if(checkGelernt()) {
            this.gelernt = true;
            return this.frage + " (" + this.anzahlRichtig + "/" + this.anzahlGefragt + ")" + " bereits gelernt :)";
        }else{
            this.gelernt = false;
            return this.frage + " (" + this.anzahlRichtig + "/" + this.anzahlGefragt + ")";
        }
    }

    public boolean checkGelernt() {
        return this.anzahlRichtig >= 3 && this.anzahlGefragt >= 3;
    }
    public String getFrage() {
        return this.frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return this.antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public boolean isGelernt() {
        return this.gelernt;
    }

    public void setGelernt(boolean gelernt) {
        this.gelernt = gelernt;
    }

    public int getAnzahlGefragt() {
        return this.anzahlGefragt;
    }

    public void setAnzahlGefragt(int anzahlGefragt) {
        this.anzahlGefragt = anzahlGefragt;
    }

    public int getAnzahlRichtig() {
        return this.anzahlRichtig;
    }

    public void setAnzahlRichtig(int anzahlRichtig) {
        this.anzahlRichtig = anzahlRichtig;
    }
}
