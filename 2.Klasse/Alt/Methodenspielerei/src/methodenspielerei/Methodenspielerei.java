package methodenspielerei;

import java.util.Scanner;

//220227 
public class Methodenspielerei {

    public static void main(String[] args) {
        Scanner yato = new Scanner(System.in);
        int g;
        System.out.println("Wollen sie Sie in ganzen Zahlen (1) eingeben oder in Dezimal (0)? <1|0>");
        g = yato.nextInt();
        while (g < 0 || g > 1) {
            System.out.println("Fehler,Eingabe war falsch!");
            main(args);
        }
        if (g == 1) {
            int a, b;
            System.out.println("Geben sie die erste ganze zahl ein");
            a = yato.nextInt();
            System.out.println("Geben sie die zweite ganze zahl ein");
            b = yato.nextInt();
            int summ = add(a, b);
            System.out.println("Die summe bider zahlen ist:" + summ);
            int arith = meanA(a, b);
            System.out.println("das arithmetische mittel beider zahlen ist:" + arith);
            int geo = meanG(a, b);
            System.out.println("der geometrische mittelwert beider zahlen ist:" + geo);
        }

        if (g == 0) {
            double a, b;
            System.out.println("Geben sie die erste ganze zahl ein");
            a = yato.nextInt();
            System.out.println("Geben sie die zweite ganze zahl ein");
            b = yato.nextInt();
            double summ = addD(a, b);
            System.out.println("Die summe bider zahlen ist:" + summ);
            double arith = meanAd(a, b);
            System.out.println("das arithmetische mittel beider zahlen ist:" + arith);
            double geo = meanGd(a, b);
            System.out.println("der geometrische mittelwert beider zahlen ist:" + geo);
        }

    }

    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int meanA(int a, int b) {
        int c = (a + b) / 2;
        return c;
    }

    public static int meanG(int a, int b) {
        int c = (int) Math.sqrt(a * b);
        return c;
    }

    public static double addD(double a, double b) {
        double c = a + b;
        return c;
    }

    public static double meanAd(double a, double b) {
        double c = (a + b) / 2;
        return c;
    }

    public static double meanGd(double a, double b) {
        double c = Math.sqrt(a * b);
        return c;
    }

}
