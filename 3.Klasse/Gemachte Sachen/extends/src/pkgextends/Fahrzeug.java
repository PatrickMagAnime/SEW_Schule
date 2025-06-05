package pkgextends;

/**
 *
 * @author riedl
 */
public abstract class Fahrzeug {

    //Objekt
    //setter und getter

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
    public abstract void fahren();

    protected double geschwindigkeit;

    //haupt konstruktor
    public Fahrzeug(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
}

