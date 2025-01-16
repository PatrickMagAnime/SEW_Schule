package ggt;

import java.util.Scanner;
//220227

public class GGT {

    public static void main(String[] args) {
        int a, b;
        Scanner yato = new Scanner(System.in);
        System.out.println("Geben sie ihre 1. Zahl ein:");
        a = yato.nextInt();
        System.out.println("Geben sie ihre 2. Zahl ein:");
        b = yato.nextInt();

        if (a == 0) {
            System.out.println("Der GGT ist:" + b);
        } else {
            while (b != 0) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("Der GGT ist:" + a);
        }
    }
}
