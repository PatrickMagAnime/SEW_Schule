package pkgextends;

/**
 *
 * @author riedl
 */
public class Fahrrad extends Fahrzeug {
    protected boolean hatKlingel = true;
    
    //konstruktor fürdie klasse fahrrad mit geerbten geschwindikeit
    public Fahrrad(double geschwindigkeit, boolean hatKlingel){
        super(geschwindigkeit);
        this.hatKlingel=hatKlingel;
    }
//überschreiben
    @Override
    public void fahren(){
        System.out.println("Das auto fährt mit km/h "+super.getGeschwindigkeit());
    }

    
}
