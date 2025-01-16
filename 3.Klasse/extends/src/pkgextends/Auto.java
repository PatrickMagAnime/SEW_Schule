package pkgextends;

/**
 *
 * @author riedl
 */
public class Auto extends Fahrzeug {
    //objekt
    public int anzahlTueren = 4;

    //konstruktor fürdie klasse fahrrad mit geerbten geschwindikeit
    public Auto(double geschwindigkeit, int anzahlTueren){
        super(geschwindigkeit);
        this.anzahlTueren=anzahlTueren;
    }

    //überschreiben
    @Override
    public void fahren(){
        System.out.println("Das auto fährt mit km/h "+super.getGeschwindigkeit());
    }
        

}
