package a11;

import java.util.Scanner;
//220227

public class A11 {

    public static void main(String[] args) {
        Scanner yato = new Scanner(System.in);
        Dreieck d1 = new Dreieck();//dreieck wurde erstellt (wie Scanner)

        System.out.println("Gegeben ist ein Dreieck");
        System.out.println("Geben sie dessen Werte an");
        System.out.println("Farbe: ");
        String farbe = yato.next();
        d1.farbe = farbe;

        System.out.println("1.Seitenlaenge: ");
        double x = yato.nextDouble();
        d1.setSeite1(x);
        System.out.println("2.Seitenlaenge: ");
        double y = yato.nextDouble();
        d1.setSeite2(y);
        System.out.println("3.Seitenlaenge: ");
        double z = yato.nextDouble();
        d1.setSeite3(z);
        double ze;
        boolean j = true;
        int g;
        while (j == true) {

            System.out.println("Wählen sie aus:");
            
            System.out.println("1. Umfang anzeigen");
            System.out.println("2. Groese aendern");
            System.out.println("3. Informationen anzeigen");
            System.out.println("4. Programm beenden");
            g = yato.nextInt();
            if (g == 4) {
                j = false;
            }

            if (g == 1) {
                double umfang = d1.umfang();
                System.out.println(umfang);
            }

            if (g == 2) {
                System.out.println("Um welchen faktor soll das Dreieck Vergrößert werden?");
                ze = yato.nextDouble();
                d1.groesseAendern(ze);
            }

            if (g == 3) {
               d1. dreieckInformation();

            }

        }
    }
        
    

   
}
