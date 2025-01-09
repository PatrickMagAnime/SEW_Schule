package Bank;

public class SparKonto extends Konto{
    private double zinssatz; //– In Prozent.
    public SparKonto(String kontoinhaber, String kontonummer,double zinssatz) {
        super(kontoinhaber, kontonummer);
        this.zinssatz=zinssatz;
    }
    public void einzahlen(double betrag) {

        try {
            if (betrag < 0) {
                throw new IllegalArgumentException("Betrag darf nicht kleiner als 0 sein");
            }
            kontostand += betrag;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void auszahlen(double betrag){

        try {
            if (betrag < 0) {
                throw new IllegalArgumentException("Betrag darf nicht kleiner als 0 sein");
            }
            if (kontostand < betrag) {
                throw new IllegalArgumentException("Dispolimit überschritten");
            }
            kontostand -= betrag;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
    //Überladene Methode:
    public void auzahlen() {
        // – Überweist einen Standardbetrag von 100€ auf das Bank.Konto.
        einzahlen(50);

    }
    public void zinsenBerechnen(){
        kontostand += kontostand * (zinssatz / 100);
}
}
