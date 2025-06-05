package zusatzaufgaben;

import java.awt.*;

public class Karte {
    private String frage;
    private String antwort;
    private boolean gelernt;
    private int anzahlGefragt;
    private int anzahlRichtig;

    private Kategorie kategorie;

    private String farbe;

//    public Color getFarbe() {
//        return farbe;
//    }
//
//    public void setFarbe(Color farbe) {
//        this.farbe = farbe;
//    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Karte(String frage, String antwort, boolean gelernt, int anzahlGefragt, int anzahlRichtig, Kategorie kategorie) {
        this.frage = frage;
        this.antwort = antwort;
        this.gelernt = gelernt;
        this.anzahlGefragt = anzahlGefragt;
        this.anzahlRichtig = anzahlRichtig;
        this.kategorie = kategorie;
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

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(Color color) {
        if (color == null) {
            this.farbe = null;
        } else {
            this.farbe = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        }
    }

    public Color getFarbeAsColor() {
        if(farbe != null){
            return Color.decode(farbe);
        }
        return null;
    }
}
