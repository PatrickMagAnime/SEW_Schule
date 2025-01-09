package BankAnwendung;
import Bank.Konto;
import Bank.GiroKonto;
import Bank.SparKonto;
// imports der packages
import java.util.Scanner;
import java.util.ArrayList;
public class BankAnwendung {
    public static void main(String[] args) {
        // arraylist für die speicherung der konten
       ArrayList <Konto> konten=new ArrayList<>();
       // sacanner zum einlesen der daten
        Scanner yuri = new Scanner(System.in);
        //boolean um das programm zu wiederholen
        boolean a=true;
        while(a) {
            System.out.println("Dies hier ist eine Bankanwendung");
            System.out.println("Wählen sie aus was sie machen möchten:");
            System.out.println("1.Konto erstellen");
            System.out.println("2.Einzahlen");
            System.out.println("3.Auszahlen");
            System.out.println("4.Kontostand Anzeigen");
            System.out.println("5.Programm beenden");
            int x = yuri.nextInt();
            switch (x) {
                case 1 -> {
                    kontoerstellen(konten,yuri);
                }
                case 2 -> {
                    einzahlen(konten,yuri);
                }
                case 3 -> {
                    auszahlen(konten,yuri);
                }
                case 4 -> {
                    kontostandAnzeigen(konten,yuri);
                }
                case 5 -> {
                    a=false;
                }
                default -> {
                    throw new IllegalStateException("Falsche Antwort: " + x);

                }
            }
        }
    }

    // konto erstelen
    // abfrage nach konto art
    // kontonummer
    // art des kontos
    // zinssatz bei spar
    // dann in die arraylist einfügen
    private static void kontoerstellen(ArrayList<Konto> konten, Scanner yato) {
        System.out.print("Kontoinhaber: ");
        String kontoinhaber = yato.next();
        System.out.print("Kontonummer: ");
        String kontonummer = yato.next();

        System.out.println("Kontoart:");
        System.out.println("1. Sparkonto");
        System.out.println("2. Girokonto");
        int kontoart = yato.nextInt();

        if (kontoart == 1) {
            System.out.print("Zinssatz (%): ");
            double zinssatz = yato.nextDouble();
            konten.add(new SparKonto(kontoinhaber, kontonummer, zinssatz));
            System.out.println("Sparkonto erstellt.");
        } else if (kontoart == 2) {
            System.out.print("Dispo-Limit: ");
            double dispoLimit = yato.nextDouble();
            konten.add(new GiroKonto(kontoinhaber, kontonummer, dispoLimit));
            System.out.println("Girokonto erstellt.");
        } else {
            System.err.println("Ungültige Eigabe");
        }
    }

    // geht die array liste durch bis es konto findet
    // wenn gefunden, dann weis man wem das konto anhand der nummer gehört
    // bringt nichts bei der aufgabe daher der inhaber nie den namen nennen muss um ein/auszuzahlen
    private static Konto findeKonto(ArrayList<Konto> konten, String kontonummer) {
        for (Konto konto : konten) {
            if (konto.getKontonummer().equals(kontonummer)) {
                return konto;
            }
        }
        return null;
    }

    // eingabe der kontunummer
    //dann abfrage
    // danach kontonummer herausfinden
    //fehlerbehen´bung mit illegal arguments
    //wenn gefunden, dann ausgabe mit neuem kontostand
    private static void einzahlen(ArrayList<Konto> konten, Scanner himori) {
        System.out.print("Kontonummer eingeben: ");
        String kontoNummer = himori.next();

        Konto konto = findeKonto(konten, kontoNummer);
        if (konto != null) {
            System.out.print("Wie viel möchten Sie einzahlen? ");
            double betrag = himori.nextDouble();
            try {
                konto.einzahlen(betrag);
                System.out.println("Einzahlung erfolgreich. Neuer Kontostand: " + konto.getKontostand() + "€");
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler bei der Einzahlung: " + e.getMessage());
            }
        } else {
            System.out.println("Konto mit der Nummer " + kontoNummer + " wurde nicht gefunden.");
        }
    }
    // selbe wie einzahlen
    // auf die classen der anderen packete wird zugegriffen und dem konto die werte zugewiesen

    private static void auszahlen(ArrayList<Konto> konten, Scanner sumori) {
        System.out.print("Kontonummer eingeben: ");
        String kontoNummer = sumori.next();

        Konto konto = findeKonto(konten, kontoNummer);
        if (konto != null) {
            System.out.print("Wie viel möchten Sie auszahlen? ");
            double betrag = sumori.nextDouble();
            try {
                konto.auszahlen(betrag);
                System.out.println("Auszahlung erfolgreich. Neuer Kontostand: " + konto.getKontostand() + "€");
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler bei der Auszahlung: " + e.getMessage());
            }
        } else {
            System.out.println("Konto mit der Nummer " + kontoNummer + " wurde nicht gefunden.");
        }
    }

    //konto name eingeben
    //konto wird gesucht
    //konto(nummer) wird dann mit getKontostand(); ausgegeben
    private static void kontostandAnzeigen(ArrayList<Konto> konten, Scanner himori) {
        System.out.print("Kontonummer eingeben: ");
        String kontoNummer = himori.next();

        Konto konto = findeKonto(konten, kontoNummer);
        if (konto != null) {
            System.out.println("Der aktuelle Kontostand beträgt: " + konto.getKontostand() + "€");
        } else {
            System.out.println("Konto mit der Nummer " + kontoNummer + " wurde nicht gefunden.");
        }
    }





}
