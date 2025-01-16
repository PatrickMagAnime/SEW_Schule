
package a11;
//220227
public class Dreieck {
    //hier kommen die atribute hinein
    private double seite1;
    private double seite2;
    private double seite3;
    String farbe;

    
    //setter und getter methoden erstellt + fehlerbehandlung
    public double getSeite1() {
        return seite1;
    }

    public void setSeite1(double seite1) {
        if (seite1 > 0){
            this.seite1 = seite1;
        }else{
            System.out.println("Seitenlaenge 1 muss Positiv sein!");
        }
    }

    public double getSeite2() {
        return seite2;
    }

    public void setSeite2(double seite2) {
       if (seite2 > 0){
            this.seite2 = seite2;
        }else{
            System.out.println("Seitenlaenge 2 muss Positiv sein!");
        }
    }

    public double getSeite3() {
        return seite3;
    }

    public void setSeite3(double seite3) {
        if (seite3 > 0){
            this.seite3 = seite3;
        }else{
            System.out.println("Seitenlaenge 3 muss Positiv sein!");
        }
    }

    
     public String dreieckInformation() {
        System.out.println("Eigenschaften des Dreiecks:");
        System.out.println("Farbe: " +farbe);
        System.out.println("Seite 1: " + getSeite1());
        System.out.println("Seite 2: " + getSeite2());
        System.out.println("Seite 3: " + getSeite3());
        double umfang = getSeite1() + getSeite2() + getSeite3();
        System.out.println("Umfang: " + umfang);
        return null;
    }

    public double umfang() {

        double umfang = getSeite1() + getSeite2() + getSeite3();

        return umfang;
    }

    public void groesseAendern(double ze) {
        setSeite1(getSeite1() * ze);
        setSeite2(getSeite2() * ze);
        setSeite3(getSeite3() * ze);
    }
}
