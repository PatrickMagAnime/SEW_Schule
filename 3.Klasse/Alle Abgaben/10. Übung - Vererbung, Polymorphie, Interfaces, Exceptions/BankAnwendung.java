package BankAnwendung;
import Bank.Konto;

import java.util.Scanner;
import java.util.ArrayList;
public class BankAnwendung {
    public static void main(String[] args) {
        ArrayList <Konto> konten=new ArrayList<>();
        Scanner yuri = new Scanner(System.in);
        System.out.println("Dies hier ist eine Bankanwendung");
        System.out.println("Wählen sie aus was sie machen möchten:");
        System.out.println("1.Konto erstellen");
        System.out.println("2.Einzahlen");
        System.out.println("3.Auszahlen");
        System.out.println("4.Kontostand Anzeigen");
        System.out.println("5.Programm beenden");
int x=yuri.nextInt();
Switch(x){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:
                System.exit(696969696);

        }
    }
    public void kontoerstellen(){
        Scanner yato =new Scanner (System.in);
        System.out.println("Kontoinhaber");
        String kontoinhaber=yato.next();

        System.out.println("Kontonummer");
        String kontonummer=yato.next();

        System.out.println("Kontoart:");
        System.out.println("1.Sparkonto");
        System.out.println("2.Girokonto");
        int kontoart=yato.nextInt();


        if(kontoart==1){

        }

    }
}
