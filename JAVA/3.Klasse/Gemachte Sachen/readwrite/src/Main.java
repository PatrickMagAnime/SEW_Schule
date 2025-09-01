import java.io.*; // Importiert alle Klassen für Input und Output
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dieses Programm erstellt eine Datei"); // Ausgabe zur Info für den Benutzer

        // Der Pfad für die zu erstellende Ausgabedatei
        System.out.println("Wie soll ihre txt Datei heissen");
        String name = sc.next();
        while(name.equals(null)){
            System.out.println("Falsche eingabe");
            System.out.println("Nochmal: ");
            name = sc.next();
        }
        String outputfilepath = name;

        // Eine Datei wird erstellt und in diese geschrieben
        writeToFile(outputfilepath);

        // Der Inhalt der Datei wird gelesen und ausgegeben
        readToFile(outputfilepath);
    }

    private static void writeToFile(String inputfilepath) {
        try {
            // BufferedWriter um Text in eine Datei zu schreiben
            // FileWriter erstellt oder überschreibt die Datei am angegebenen Pfad
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputfilepath));

            // Inhalt wird in die Datei geschrieben
            writer.write("Hallo Welt!");
            System.out.println("File successfully written"); // Erfolgsnachricht

            // Der Buffer wird geschlossen, damit die Datei richtig gespeichert wird
            writer.close();
        } catch (IOException e) { // Fehlerbehandlung, falls Dateioperation fehlschlägt
            System.err.println(e.getMessage()); // Fehlermeldung wird ausgegeben
        }
    }


    private static void readToFile(String outputfilepath) {
        try {
            // BufferedReader um Text aus einer Datei zu lesen
            // FileReader öffnet die Datei zum Lesen
            BufferedReader reader = new BufferedReader(new FileReader(outputfilepath));

            String line; // Variable für jede gelesene Zeile

            System.out.println("Reading from file"); // Ausgabe zur Info für den Benutzer

            // Schleife liest die Datei Zeile für Zeile
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Jede Zeile wird ausgegeben
            }

            // Der Buffer wird geschlossen, um Ressourcen freizugeben
            reader.close();
        } catch (IOException e) { // Fehlerbehandlung, falls Dateioperation fehlschlägt
            System.err.println(e.getMessage()); // Fehlermeldung wird ausgegeben
        }
    }
}
