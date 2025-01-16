
import java.util.ArrayList;
import java.util.Scanner;

public class A13 {

    public static void main(String[] args) {
        ArrayList<Dreieck> dreiecke = new ArrayList<>(); // Hab ArraList von dort gelernt: https://www.w3schools.com/java/java_arraylist.asp
        Scanner yato = new Scanner(System.in);
        boolean g = true;

        while (g) {
            System.out.println("Wählen Sie eine Option:");
            System.out.println("1: Dreieck hinzufügen ");
            System.out.println("2: Seitenlängen ändern ");
            System.out.println("3: Farbe ändern ");
            System.out.println("4: Größe ändern "); 
            System.out.println("6: Dreieck löschen ");
            System.out.println("7: Beenden");
            int option = yato.nextInt();

            switch (option) {
                case 1:
                    //Dreieck hinzufügen + Fehlerbehandlung
                    System.out.println("Geben Sie die 3 Seitenlängen, Farbe und Größe des Dreiecks nacheinander ein:");
                    System.out.print("Seite 1: ");
                    double sA = yato.nextDouble();
                    if (sA <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Seite 1 Erneut eingeben:");
                        sA = yato.nextDouble();
                    }
                    System.out.print("Seite 2: ");
                    double sB = yato.nextDouble();
                    if (sB <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Seite 2 Erneut eingeben:");
                        sB = yato.nextDouble();
                    }
                    System.out.print("Seite 3: ");
                    double sC = yato.nextDouble();
                    if (sC <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Seite 3 Erneut eingeben:");
                        sC = yato.nextDouble();
                    }

                    System.out.print("Farbe: ");
                    String farbe = yato.next();

                    System.out.print("Groesse: ");
                    double groesse = yato.nextDouble();
                    if (groesse <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Groesse Erneut eingeben:");
                        groesse = yato.nextDouble();
                    }

                    Dreieck dreieck = new Dreieck(sA, sB, sC, farbe, groesse); //Aufrufen eigener Methode von der Klasse
                    dreiecke.add(dreieck); //Erstelltes "dreieck" wird in die ArrayList "dreiecke" mit add reingegeben
                    break;
                case 2:
                    //Seitenlängen ändern
                    System.out.println("Geben Sie den Index des Dreiecks und die neuen Seitenlängen ein. Index sollte bei 0 beginnen.:");
                    int index = yato.nextInt();
                    System.out.print("Seite 1: ");
                    sA = yato.nextDouble();
                    if (sA <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Seite 1 Erneut eingeben:");
                        sA = yato.nextDouble();
                    }
                    System.out.print("Seite 2: ");
                    sB = yato.nextDouble();
                    if (sB <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Seite 2 Erneut eingeben:");
                        sB = yato.nextDouble();
                    }
                    System.out.print("Seite 3: ");
                    sC = yato.nextDouble();
                    if (sC <= 0) {
                        System.out.println("Fehlerhafte eingabe!");
                        System.out.println(" Seite 3 Erneut eingeben:");
                        sC = yato.nextDouble();
                    }

                    dreiecke.get(index).setSeiteA(sA);
                    dreiecke.get(index).setSeiteB(sB);
                    dreiecke.get(index).setSeiteC(sC);
                    break;
                case 3:
                    //Farbe ändern
                    System.out.println("Geben Sie den Index des Dreiecks und die neue Farbe ein: Index sollte bei 0 beginnen.");
                    index = yato.nextInt();
                    farbe = yato.next();
                    dreiecke.get(index).setFarbe(farbe);
                    break;
                case 4:
                    //Größe ändern
                    System.out.println("Geben Sie den Index des Dreiecks und die neue Größe ein: Index sollte bei 0 beginnen.");
                    index = yato.nextInt();
                    groesse = yato.nextDouble();
                    dreiecke.get(index).setGroesse(groesse);
                    break;
                case 5:
                    //Alle Dreiecke auflisten
                    System.out.println();
                    for (int i = 0; i < dreiecke.size(); i++) {
                        System.out.println("Dreieck " + i + ": " + dreiecke.get(i).getSeiteA() + ", " + dreiecke.get(i).getSeiteB() + ", " + dreiecke.get(i).getSeiteC() + ", " + dreiecke.get(i).getFarbe() + ", " + dreiecke.get(i).getGroesse());
                        System.out.println();
                    }

                    break;
                case 6:
                    //Dreieck löschen
                    System.out.println("Geben Sie den Index des zu löschenden Dreiecks ein:");
                    index = yato.nextInt();
                    if (index >= 0 && index < dreiecke.size()) {
                        dreiecke.remove(index);
                    } else {
                        System.out.println("Ungültiger Index");
                    }
                    break;
                case 7:
                    // Beenden
                    g = false;
                    System.out.println("Das Programm wurde beendet");
                    break;
                default:
                    System.out.println("Ungültige Option");
            }
        }

    }
}
