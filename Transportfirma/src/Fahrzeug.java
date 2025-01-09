abstract class Fahrzeug {
    // protected objekte ertsellt
    protected double gewicht;
    protected double laenge;
    protected double breite;
    protected double hoehe;
    protected double geschwindigkeit;
    // konstruktor
    public Fahrzeug(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        this.gewicht = gewicht;
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;
        this.geschwindigkeit = geschwindigkeit;
    }
    //getter und setter
    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
    // to string
    @Override
    public String toString() {
        return "Fahrzeug [gewicht=" + gewicht + ", laenge=" + laenge + ", breite=" + breite + ", hoehe=" + hoehe
                + ", geschwindigkeit=" + geschwindigkeit + "]";
    }
    // abstract methoden (abstracte methoden haben keinen body)
    public abstract void bremsen();

    public abstract void beschleunigen();

    public abstract boolean isTransportierbar();
}