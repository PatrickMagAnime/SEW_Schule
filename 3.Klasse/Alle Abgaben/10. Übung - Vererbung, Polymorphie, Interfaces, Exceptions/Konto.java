package Bank;

public abstract class Konto implements KontoInterface {
   protected String kontoinhaber,kontonummer;
   protected double kontostand;
    public Konto(String kontoinhaber,String kontonummer){
        this.kontoinhaber=kontoinhaber;
        this.kontonummer=kontonummer;
        this.kontostand=0;
    }
    @Override
    public double getKontostand(){
        //Gibt den aktuellen Kontostand zurück.
        return kontostand;
    }
    @Override
    public abstract void einzahlen(double betrag);
    @Override
    public abstract void auszahlen(double betrag);
}
