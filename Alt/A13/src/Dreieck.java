public class Dreieck {
    private double sA;
    private double sB;
    private double sC;
    private String farbe;
    private double groesse;

    public Dreieck(double sA, double sB, double sC, String farbe, double groesse) { //Eigene <Methode erstellt für Dreiecke
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
        this.farbe = farbe;
        this.groesse = groesse;
    }

    public double getSeiteA() {
        return sA;
    }

    public void setSeiteA(double sA) {
        if (sA > 0) {
            this.sA = sA;
        }
    }

    public double getSeiteB() {
        return sB;
    }

    public void setSeiteB(double sB) {
        if (sB > 0) {
            this.sB = sB;
        }
    }

    public double getSeiteC() {
        return sC;
    }

    public void setSeiteC(double sC) {
        if (sC > 0) {
            this.sC = sC;
        }
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        if (groesse > 0) {
            this.groesse = groesse;
        }
    }

    public double berechneUmfang() {
        return sA + sB + sC;
    }
}
