import java.util.Scanner;

public class Bankanwendung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Neues Konto erstellen
            System.out.print("Geben Sie den Namen des Kontoinhabers ein: ");
            String name = sc.nextLine();
            System.out.print("Geben Sie Ihren Betrag ein: ");
            double initialBalance = sc.nextDouble();
            BankAccount account = new BankAccount(name, initialBalance);

            BankAccount otherAccount = new BankAccount("Zweites Konto", 1000);

            while (true) {
                System.out.println("1. Einzahlen");
                System.out.println("2. Abheben");
                System.out.println("3. Überweisen");
                System.out.println("4. Kontodetails anzeigen");
                System.out.println("5. Beenden");
                System.out.print("Option: ");
                int g = sc.nextInt();

                switch (g) {
                    case 1: // Einzahlung
                        System.out.print("Betrag eingeben: ");
                        double depositAmount = sc.nextDouble();
                        try {
                            account.deposit(depositAmount);
                            System.out.println("Einzahlung erfolgreich.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Fehler: " + e.getMessage());
                        }
                        break;

                    case 2: // Abhebung
                        System.out.print("Betrag eingeben: ");
                        double withdrawAmount = sc.nextDouble();
                        try {
                            account.withdraw(withdrawAmount);
                            System.out.println("Abhebung erfolgreich.");
                        } catch (IllegalArgumentException | InsufficientFundsException e) {
                            System.out.println("Fehler: " + e.getMessage());
                        }
                        break;

                    case 3: // Überweisung
                        System.out.println("Name des Zieltraegers: ");
                        String Traeger = sc.next();
                        System.out.print("Betrag eingeben: ");
                        double transferAmount = sc.nextDouble();
                        try {
                            account.transfer(otherAccount, transferAmount);
                            System.out.println("Überweisung erfolgreich.");
                        } catch (InvalidAccountException | IllegalArgumentException | InsufficientFundsException e) {
                            System.out.println("Fehler: " + e.getMessage());
                        }
                        break;

                    case 4: // Kontodetails anzeigen
                        account.printAccountDetails();
                        break;

                    case 5: // Beenden
                        System.out.println("Programm beendet.");
                        return;

                    default:
                        System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
