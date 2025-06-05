package pkgextends;

import java.util.ArrayList;

/**
 * @author riedl
 */
public class Extends {

    public static void main(String[] args) {
        //ArrayList erstellen // tüp von oberster klasse gegeben
        ArrayList<Fahrzeug> fz = new ArrayList <>();

        //wie man werte anderer objekte ändert
        Auto auto = new Auto(120,4);
        auto.setGeschwindigkeit(25);
        //oder //super methode braucht setter und/oder getter
        Fahrrad fahrrad = new Fahrrad(50,true);
        fahrrad.geschwindigkeit=15;




        //ausgabe
        System.out.println("Das Auto fährt mit "+auto.geschwindigkeit+"km/h und hat "+auto.anzahlTueren+" Tueren");
        System.out.println("Das Fahrrad fährt mit "+fahrrad.geschwindigkeit+"km/h und hat eine Klingel: "+fahrrad.hatKlingel);

        //Liste der objekte hinzufügen
        fz.add(auto);
        fz.add(fahrrad); // array list hat dann verschiedene objekt klassen

        for (int i=0;i<fz.size();i++){
            Fahrzeug f = fz.get(i);
            System.out.println("Geschwindigkeit: " + f.getGeschwindigkeit());
        }
        for(Fahrzeug i : fz) {
            System.out.println("Geschwindigkeit: " + i.getGeschwindigkeit()); //i ist hier der zähler
        }
    }
    
}
