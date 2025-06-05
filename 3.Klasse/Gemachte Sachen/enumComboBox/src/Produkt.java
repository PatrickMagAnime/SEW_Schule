public class Produkt {
    private String name;
    private double preis;

    private Kategorien kategorie;

    public Produkt(String name, double preis, Kategorien kategorie) {
        this.name = name;
        this.preis = preis;
        this.kategorie = kategorie;
    }

    public Kategorien getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorien kategorie) {
        this.kategorie = kategorie;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String toString() {
        return name + " " + preis;
    }



}
