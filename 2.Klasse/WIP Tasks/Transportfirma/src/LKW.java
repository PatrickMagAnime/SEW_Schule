class LKW extends Fahrzeug {
    public LKW(double gewicht, double laenge, double breite, double hoehe, double geschwindigkeit) {
        super(gewicht, laenge, breite, hoehe, geschwindigkeit);
    }

    @Override
    public void bremsen() {
        System.out.println("LKW bremst.");
    }

    @Override
    public void beschleunigen() {
        System.out.println("LKW beschleunigt.");
    }

    @Override
    public boolean isTransportierbar() {
        // Maximalwerte für LKW (20% der Standardwerte)
        double maxGewicht = 2000 * 0.2; // 400 kg
        double maxLaenge = 4.5 * 0.2;    // 0.9 m
        double maxBreite = 2 * 0.2;      // 0.4 m
        double maxHoehe = 1.5 * 0.2;     // 0.3 m

        // Überprüfung, ob die LKW-Werte die maximalen Werte überschreiten
        return gewicht <= maxGewicht && laenge <= maxLaenge && breite <= maxBreite && hoehe <= maxHoehe;
    }
}