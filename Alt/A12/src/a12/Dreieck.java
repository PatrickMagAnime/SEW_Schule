
package a12;
//220227

import java.util.Scanner;

public class Dreieck {
    //hier kommen die atribute hinein
    private double s1;
    private double s2;
    private double s3;
    String farbe;

    
    //setter und getter methoden erstellt + fehlerbehandlung
    public double getS1() {
        return s1;
    }

    
    public Dreieck [] dreieckeErzeugen(Scanner yato){
        System.out.println("Wie viele dreiecke wollen sie erstellen?");
        int q=1;
        
        q=yato.nextInt();
        
       if (q<=0) {
            System.out.println("Fehler bei der eingabe! Erneute eingeben");
            q=yato.nextInt();
        }
       
       
       
       
       
            Dreieck[] array = new Dreieck [q];

        System.out.println("Geben sie dessen Werte an");
        for (int i = 0; i < q; i++) {
        
        Dreieck d = array[i];
       
        System.out.println("1.Seitenlaenge: ");
        double x = yato.nextDouble();
        setS1(s1 = x);
        
        System.out.println("2.Seitenlaenge: ");
        x = yato.nextDouble();
        setS1(s2 = x);
        
        System.out.println("3.Seitenlaenge: ");
        x = yato.nextDouble();
        setS1(s3 = x);
        System.out.println("Farbe: ");
        String farben=yato.next();
        setFarbe(farbe=farben);
        }
        return array;
    }
    
    
    
    
    
    
    
   
    
    public void setS1(double s1) {
        if (s1 > 0){
            this.s1 = s1;
        }else{
            System.out.println("Seitenlaenge 1 muss Positiv sein!");
        }
    }

    public double getS2() {
        return s2;
    }

    public void setS2(double s2) {
       if (s2 > 0){
            this.s2 = s2;
        }else{
            System.out.println("Seitenlaenge 2 muss Positiv sein!");
        }
    }

    public double getS3() {
        return s3;
    }

    public void setS3(double s3) {
        if (s3 > 0){
            this.s3 = s3;
        }else{
            System.out.println("Seitenlaenge 3 muss Positiv sein!");
        }
    }

    
     public String dreieckInformation(Dreieck array[]) {
         for (int i = 0; i < array.length; i++) {
             
         }
        System.out.println("Eigenschaften des Dreiecks:");
       
        System.out.println("Seite 1: " + s2);
        System.out.println("Seite 2: " + s3);
        System.out.println("Seite 3: " + s1);
         System.out.println("Farbe: " + farbe);
        
        return null;
    }

    public double umfang() {

        double umfang = getS1() + getS2() + getS3();

        return umfang;
    }

    public void groesseAendern(double ze) {
        setS1(getS1() * ze);
        setS2(getS2() * ze);
        setS3(getS3() * ze);
    }
    
    public String farbeAendern(String farbe){
        setFarbe(farbe);
        return null;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
