package a12;

import java.util.Scanner;
//220227

public class A12 {
 
    public static void main(String[] args) {
        Scanner yato = new Scanner(System.in);
        Dreieck d1 = new Dreieck();//dreieck wurde erstellt (wie Scanner)

        
        d1.dreieckeErzeugen(yato);
        
        double ze;
        boolean j = true;
        int g;
        while (j == true) {

            System.out.println("Wählen sie aus:");

            System.out.println("1. seitenlänge eines deiecks andern");
            System.out.println("2. farbe eines dreieck andern");
            System.out.println("3. grosse andern eines dreiecks");
            System.out.println("4. tabbelarische auflistung aler dreiecke");
            System.out.println("5. neues array mit dreiecken erstelen");
            System.out.println("6. Programm beenden");
            g = yato.nextInt();
 
            switch (g) {
                case 1 -> {
                    //ab hier unfertig
                    double umfang = d1.umfang();
                    System.out.println(umfang);
                    d1.dreieckInformation();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Um welchen faktor soll das Dreieck Vergrößert werden?");
                    ze = yato.nextDouble();
                    d1.groesseAendern(ze);
                    d1.dreieckInformation();
                    System.out.println();
                }
                case 3 -> {
                    d1.dreieckInformation();
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Welche farbe soll das dreieck haben?");
                    String farbeAendern = yato.next();
                    d1.farbeAendern(farbeAendern);
                }
                case 5 -> {
                    
                }  
                case 6 -> j = false;
                default -> {
                        System.out.println("Fehler bei der eingabe! Erneut eingeben");
                        g = yato.nextInt();
                }
            }

        }
    }

}
