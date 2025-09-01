package arrays;

import java.util.Scanner;

//220227
public class Arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welche natürliche Zahl wollen sie suchen?");
        int n = sc.nextInt();

        int[] liste = {11, 22, 9, 6, 35, 0, 2};
        int index = suchen(liste, n);

        if (liste[index] == n) {
            System.out.println("Der Wert " + liste[index] + " wurde an der " + (index + 1) + ". Stelle " + " gefunden.");
        } else {
            System.out.println("Der wert wurde nicht gefunden");
        }
    }

    static int suchen(int[] liste, int wert) {
        int a = liste.length;

        for (int i = 0; i < a; i++) {
            if (liste[i] == wert) {
                return i;
            }
        }
        return 0;
    }
}
