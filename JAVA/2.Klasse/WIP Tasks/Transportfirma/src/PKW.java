class PKW extends Fahrzeug {
    public PKW(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        super(gewicht, laenge, breite, hoehe, geschwindigkeit);
    }

    @Override
    public void bremsen() {
        // Implementierung der Bremsen-Logik für PKW
        System.out.println("PKW bremst.");
    }

    @Override
    public void beschleunigen() {
        // Implementierung der Beschleunigen-Logik für PKW
        System.out.println("PKW beschleunigt.");
    }

    @Override
    public boolean isTransportierbar() {
        return gewicht <= 2000 && laenge <= 4.5 && breite <= 2 && hoehe <= 1.5;
    }
}

