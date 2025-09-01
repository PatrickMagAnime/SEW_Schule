
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean wiederholen = true;

        while (wiederholen) {

            System.out.println("Bitte geben Sie eine Folge von Worten ein:");

            String eingabe = sc.next();

            String[] worte = eingabe.split(" ");

            String ergebnis = worttausch(worte);

            System.out.println("Der umgedrehte Text ist: " + ergebnis);

            System.out.println("Möchten Sie die Methode erneut testen? (ja / nein)");

            String antwort = sc.next();

            if (antwort.equalsIgnoreCase("nein")) {
                wiederholen = false;
            }
        }

    }

    public static String worttausch(String[] worte) {

        StringBuilder sb = new StringBuilder();

        for (int i = worte.length - 1; i >= 0; i--) {

            sb.append(worte[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
