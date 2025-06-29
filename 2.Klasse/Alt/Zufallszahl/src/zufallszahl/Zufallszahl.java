package zufallszahl;

import java.util.Scanner;
//220227

public class Zufallszahl {

    public static void main(String[] args) {
        Scanner yato = new Scanner(System.in);
        System.out.println("Wie oft wollen sie Zahlen generieren lassen?");
        int g = yato.nextInt();
        int liste[] = new int[g];
        for (int i = 0; i < g; i++) {
            double z = Math.random();
            System.out.println("Z:" + z);
            double z1 = 201 * z;
            System.out.println("21:" + z1);
            int z2 = (int) z1; // Type Cast auf int
            System.out.println("TC:" + z2);
            int z3 = z2 - 100; // Verschiebung in Bereich -10 bis +10
            System.out.println("RZ:" + z3);
            liste[i] = z3;
        }

        int m1 = maximum(liste);
        System.out.println("Die größte zuffalszahl war:" + m1);

        int m2 = minimum(liste);
        System.out.println("Die kleinste zuffalszahl war:" + m2);

        double m3 = mittelwert(liste);
        System.out.println("Der mittelwert der Zufallszahlen ist:" + m3);

        //int m4 = minDist(liste);
        //System.out.println("Die größte zuffalszahl war:" + m4);

    }

    public static int maximum(int liste[]) {
        int x = -101;
        for (int i = 0; i < liste.length; i++) {
            if (liste[i] > x) {
                x = liste[i];
            }

        }
        return x;
    }

    public static int minimum(int liste[]) {
        int x = 201;
        for (int i = 0; i < liste.length; i++) {
            if (liste[i] < x) {
                x = liste[i];
            }
 
        }
        return x;
    }

    public static double mittelwert(int liste[]) {
        double x = 0;
        double d = 0;
        for (int i = 0; i < liste.length; i++) {
            x = liste[i] + x;
        }
        d = x / liste.length;
        return d;
    }

    public static int minDist(int liste[]) {

    }

}
