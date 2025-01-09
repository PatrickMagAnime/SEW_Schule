package Bank;

public class GiroKonto extends Konto {
    private double dispoLimit;

    public GiroKonto(String kontoinhaber, String kontonummer,double dispoLimit) {
        super(kontoinhaber, kontonummer);
        this.dispoLimit=dispoLimit;
    }

    //kommentare sind aus der angabe kopiert!
    @Override
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
                if (kontostand - betrag < dispoLimit) {
                    throw new IllegalArgumentException("Dispolimit überschritten");
                }
                kontostand -= betrag;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        //Überladene Methode:
        public void einzahlen() {
            // – Überweist einen Standardbetrag von 100€ auf das Bank.Konto.
            einzahlen(100);

        }
    }

