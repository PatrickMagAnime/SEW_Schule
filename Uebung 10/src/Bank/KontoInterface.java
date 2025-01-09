package Bank;

public interface KontoInterface {
    void einzahlen(double betrag);
    void auszahlen(double betrag);
    double getKontostand();
}
