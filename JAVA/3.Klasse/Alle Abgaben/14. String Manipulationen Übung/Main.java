import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zum String-Manipulations-Übungsprogramm!");
        System.out.println("Bitte wähle eine Übung (1-15) aus:");  //finished
        System.out.println("1: ue1Introduction");                  //finished
        System.out.println("2: ue2MiddleCharacters");              //finished
        System.out.println("3: ue3CaseInsensitiveSubstringCount"); //finished
        System.out.println("4: ue4NumberToLetter");                //finished
        System.out.println("5: ue5ReverseString");                 //finished
        System.out.println("6: ue6PasswordStrengthChecker");       //finished
        System.out.println("7: ue7PalindromeChecker");             //finished
        System.out.println("8: ue8DecodeSecretMessage");           //finished
        System.out.println("9: ue9CountOccurrences");              //finished
        System.out.println("10: ue10CountCharacters");             //finished
        System.out.println("11: ue11WordFrequencyCounter");        //finished
        System.out.println("12: ue12CanBuildWord");                //finished
        System.out.println("13: ue13TextEncryptionDecryption");    //unfinished
        System.out.println("14: ue14URLParser");                   //unfinished
        System.out.println("15: ue15AnagramChecker");              //unfinished
        System.out.print("Deine Wahl: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Zeilenumbruch verzehren

        switch(choice) {
            case 1: {
                // ue1Introduction: Übergabeparameter: name, age, favouriteFood
                System.out.println("Bitte gib deinen Namen ein:");
                String name = scanner.nextLine();
                System.out.println("Bitte gib dein Alter ein:");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Bitte gib dein Lieblingsessen ein:");
                String favouriteFood = scanner.nextLine();
                String result = ue1Introduction(name, age, favouriteFood);
                System.out.println("Ergebnis UE1: " + result);
                break;
            }
            case 2: {
                // ue2MiddleCharacters: Übergabeparameter: String
                System.out.println("Bitte gib einen String ein:");
                String input = scanner.nextLine();
                String result = ue2MiddleCharacters(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 3: {
                // ue3CaseInsensitiveSubstringCount: Übergabeparameter: Text und Suchbegriff
                System.out.println("Bitte gib einen Text ein:");
                String text = scanner.nextLine();
                System.out.println("Bitte gib einen Suchbegriff ein:");
                String substring = scanner.nextLine();
                int result = ue3CaseInsensitiveSubstringCount(text, substring);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 4: {
                // ue4NumberToLetter: Übergabeparameter: Zahl
                System.out.println("Bitte gib eine Zahl zwischen 1 und 26 ein:");
                int number = scanner.nextInt();
                String result = ue4NumberToLetter(number);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 5: {
                // ue5ReverseString: Übergabeparameter: String
                System.out.println("Bitte gib einen String ein:");
                String input = scanner.nextLine();
                String result = ue5ReverseString(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 6: {
                // ue6PasswordStrengthChecker: Übergabeparameter: Passwort
                System.out.println("Bitte gib ein Passwort ein:");
                String password = scanner.nextLine();
                String result = ue6PasswordStrengthChecker(password);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 7: {
                // ue7PalindromeChecker: Übergabeparameter: String
                System.out.println("Bitte gib einen String ein:");
                String pallindrome = scanner.nextLine();
                boolean result = ue7PalindromeChecker(pallindrome);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 8: {
                // ue8DecodeSecretMessage: Übergabeparameter: verschlüsselte Nachricht
                System.out.println("Bitte gib eine verschlüsselte Nachricht ein:");
                String verschluesselteNachricht = scanner.nextLine();
                String result = ue8DecodeSecretMessage(verschluesselteNachricht);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 9: {
                // ue9CountOccurrences: Übergabeparameter: Text und Name
                int result = ue9CountOccurrences("Anna und Maria sind Freunde. Anna besucht Maria oft.", "Anna");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 10: {
                // ue10CountCharacters: Übergabeparameter: String
                String result = ue10CountCharacters("Hello, World! 123");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 11: {
                // ue11WordFrequencyCounter: Übergabeparameter: Text
                String result = ue11WordFrequencyCounter("Die Katze Katze sitzt auf der Matte. Die Katze ist hungrig.");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 12: {
                // ue12CanBuildWord: Übergabeparameter: Wort und Zeichenliste (als char-Array)
                boolean result = ue12CanBuildWord("hello", new char[] {'h','e','l','l','o'});
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 13: {
                // ue13TextEncryptionDecryption: Übergabeparameter: Text
                String result = ue13TextEncryptionDecryption("Hallo");
                System.out.println("Ergebnis (verschlüsselt): " + result);
                break;
            }
            case 14: {
                // ue14URLParser: Übergabeparameter: URL
                String result = ue14URLParser("https://www.beispiel.de/pfad?param=wert");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 15: {
                // ue15AnagramChecker: Übergabeparameter: Zwei Strings
                boolean result = ue15AnagramChecker("Listen", "Silent");
                System.out.println("Ergebnis: " + result);
                break;
            }
            default:
                System.out.println("Ungültige Auswahl!");
                break;
        }

        scanner.close();
    }

    /**
     * Aufgabe: Erstelle einen Vorstellungs-String, der Informationen über Name, Alter und Lieblingsessen enthält.
     * Beispiel:
     *   Input: name = "Mark", age = 27, favouriteFood = "Pizza"
     *   Erwartete Ausgabe: "Hallo! Ich heiße Mark. Ich bin 27 Jahre alt und mein Lieblingsessen ist Pizza."
     */
    public static String ue1Introduction(String name, int age, String favouriteFood) {
        String a = ("Hallo, ich heiße "+name+". Ich bin "+age+" Jahre alt und mein lieblingsessen ist "+favouriteFood);
        String a1 = "Hallo, ich heiße ".concat(name).concat(". Ich bin ").concat(Integer.toString(age)).concat(" Jahre alt und mein lieblingsessen ist ").concat(favouriteFood).concat(".");
        return a;
    }

    /**
     * Aufgabe: Erstelle einen neuen String aus dem ersten, mittleren und letzten Zeichen eines gegebenen Strings.
     * Beispiel:
     *   Input: "3AHITN"
     *   Erwartete Ausgabe: "3IN"
     */
    public static String ue2MiddleCharacters(String input) {
        char anf = input.charAt(0);
        int midm = input.length()/2;
        char mid=input.charAt(midm);
        char end=input.charAt(input.length()-1);
        return ""+anf+mid+end;
    }

    /**
     * Aufgabe: Zähle alle Vorkommen eines Teilstrings in einem gegebenen String, ohne auf Groß- und Kleinschreibung zu achten.
     * Beispiel:
     *   Input: Text = "Hallo Welt, hallo Java", Suchbegriff = "hallo"
     *   Erwartete Ausgabe: 2
     */
    public static int ue3CaseInsensitiveSubstringCount(String text, String substring) {
        text = text.toLowerCase();
        substring = substring.toLowerCase();
        int i = 0;
        int index = text.indexOf(substring);
        while (index != -1) {
            i++;
            index = text.indexOf(substring, index + 1);
        }
        return i;
    }

    /**
     * Aufgabe: Wandelt eine Zahl (1 bis 26) in den entsprechenden Großbuchstaben des Alphabets um.
     * Beispiel:
     *   Input: 1
     *   Erwartete Ausgabe: "A"
     *
     *   Input: 3
     *   Erwartete Ausgabe: "C"
     *
     *   Input: 30
     *   Erwartete Ausgabe: ""
     */
    public static String ue4NumberToLetter(int number) {
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alphabet.add(ch);
        }
        if (number < 1 || number > 26) {
            return "";
        }
        return String.valueOf(alphabet.get(number - 1));
    }


    /**
     * Aufgabe: Kehre einen gegebenen String um.
     * Beispiel:
     *   Input: "PYnative"
     *   Erwartete Ausgabe: "evitanYP"
     */
    public static String ue5ReverseString(String input) {
        StringBuilder reverse = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse.append(input.charAt(i));
        }
        return reverse.toString();
    }

    /**
     * Aufgabe: Überprüfe, ob ein eingegebenes Passwort bestimmte Kriterien erfüllt:
     *           - Mindestlänge von 8 Zeichen
     *           - Mindestens ein Großbuchstabe
     *           - Mindestens ein Kleinbuchstabe
     *           - Mindestens eine Ziffer
     *           - Mindestens ein Sonderzeichen
     * Beispiel:
     *   Input: "Abc!1234"
     *   Erwartete Ausgabe: "Passwort ist stark" (wenn alle Kriterien erfüllt sind)
     */
    public static String ue6PasswordStrengthChecker(String password) {


        // Ich habe .matches(".*[A-Z].*") im internet recherchiert
        if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*")){
            return "Das Passwort ist sicher";
        }else{
            return "Schwaches Passwort";
        }
    }

    /**
     * Aufgabe: Überprüfe, ob ein gegebener String ein Palindrom ist (nach Entfernung von Leerzeichen und Satzzeichen).
     * Beispiel:
     *   Input: "Eine Horde bedrohe nie"
     *   Erwartete Ausgabe: true
     */
    public static boolean ue7PalindromeChecker(String input) {
        String cleaned = input.replaceAll("[^a-zA-ZäöüÄÖÜß0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Aufgabe: Dekodiere eine geheime Nachricht, indem die ersten drei Zeichen übersprungen und anschließend jedes zweite Zeichen genommen wird.
     * Beispiel:
     *   Input: "aS!Ir waQm  VL!eDafrcnXi n=gS .J,ayvaa.!"
     *   Erwartete Ausgabe: "I am Learning Java!"
     */
    public static String ue8DecodeSecretMessage(String secretMessage) {
        //entfernen der ersten 3zeichen
        String trimmedMessage = secretMessage.substring(3);
        //dann jedes 2te zeichen nehmen
        StringBuilder decodedMessage = new StringBuilder();
        for (int i = 0; i < trimmedMessage.length(); i += 2) {
            decodedMessage.append(trimmedMessage.charAt(i));
        }
        return decodedMessage.toString();
    }

    /**
     * Aufgabe: Zähle die Anzahl der Vorkommen eines bestimmten Namens in einem gegebenen Text (ohne Beachtung der Groß- und Kleinschreibung).
     * Beispiel:
     *   Input: Text = "Anna und Maria sind Freunde. Anna besucht Maria oft.", Name = "Anna"
     *   Erwartete Ausgabe: 2
     */
    public static int ue9CountOccurrences(String text, String name) {
        //entfernen aller großbuchstaben
        String lowerText = text.toLowerCase();
        String lowerName = name.toLowerCase();
        //zählen des gesuchten textes
        String[] words = lowerText.split("\\b" + lowerName + "\\b");
        //die gefundenen wörter -1 ist die anzahl der wörter im satz
        return words.length - 1;
    }

    /**
     * Aufgabe: Ermittle in einem gegebenen String die Anzahl der Buchstaben, Ziffern und Sonderzeichen.
     * Beispiel:
     *   Input: "Hello, World! 123"
     *   Erwartete Ausgabe: Buchstaben: 10, Ziffern: 3, Sonderzeichen: 3
     */
    public static String ue10CountCharacters(String input) {
        int l = 0, d = 0, s = 0;

        //durchlaufen des strings mit foreach und if-else verzweigung
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                l++;
            } else if (Character.isDigit(c)) {
                d++;
            } else if (!Character.isWhitespace(c)) {
                s++;
            }
        }

        //w3schools carried
        return String.format("Buchstaben: %d, Ziffern: %d, Sonderzeichen: %d", l, d, s);
    }

    /**
     * Aufgabe: Zähle die Häufigkeit jedes Wortes in einem Text (unabhängig von der Groß- und Kleinschreibung) und gib das Ergebnis als Schlüssel-Wert-Paare aus.
     * Beispiel:
     *   Input: "Die Katze Katze sitzt auf der Matte. Die Katze ist hungrig."
     *   Erwartete Ausgabe: {die=2, katze=3, sitzt=1, auf=1, der=1, matte=1, ist=1, hungrig=1}
     */
    public static String ue11WordFrequencyCounter(String text) {
        //kleinbuchstaben
        text = text.toLowerCase().replaceAll("[^a-zäöüß ]", "");
        //teilen in wörter
        String[] words = text.split("\\s+");
        //ein array für wort und andere für zählen
        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int count = 0;
        //zählung der wörter
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean found = false;
            //wort wurde schon gezählt
            for (int j = 0; j < count; j++) {
                if (uniqueWords[j].equals(word)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            //falls ein neues wort da ist abspeichern
            if (!found) {
                uniqueWords[count] = word;
                counts[count] = 1;
                count++;
            }
        }
        //string bauen :)
        String result = "{";
        for (int i = 0; i < count; i++) {
            result += uniqueWords[i] + "=" + counts[i];
            if (i < count - 1) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }//Die aufgabe war schwer

    /**
     * Aufgabe: Überprüfe, ob ein gegebenes Wort aus einer Liste von Zeichen gebildet werden kann, ohne ein Zeichen mehrfach zu verwenden.
     * Beispiel:
     *   Input: Wort = "hello", Zeichenliste = ['h', 'e', 'l', 'l', 'o']
     *   Erwartete Ausgabe: true
     *
     *   Input: Wort = "hello", Zeichenliste = ['h', 'e', 'l', 'o']
     *   Erwartete Ausgabe: false
     */
    public static boolean ue12CanBuildWord(String word, char[] letters) {
        //in array reingeben
        char[] wordChars = word.toCharArray();
        //boolean arralist
        boolean[] used = new boolean[letters.length];
        //prüfung jedes zeichens
        for (char c : wordChars) {
            boolean found = false;
            //zeichen suche
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == c && !used[i]) { //zeichen finden auf benutzung
                    used[i] = true; //setzt jeden boolean wert auf true falls es schon benutzt wurde
                    found = true;
                    break;
                }
            }
            //falls die zeichen nicht gefunden wurden und das wort nicht zustande kam
            if (!found) {
                return false;
            }
        }
        return true; //alle zeichen wurden gefunden
    }
 
    /**
     * Aufgabe: Verschlüssele einen gegebenen Text, indem jeder Buchstabe in seine 8-Bit-Binärdarstellung umgewandelt wird. Implementiere
     * auch eine Funktion zur Entschlüsselung.
     * Beispiel:
     *   Input: "Hallo"
     *   Erwartete Ausgabe (verschlüsselt): "01001000 01100001 01101100 01101100 01101111"
     */
    public static String ue13TextEncryptionDecryption(String text) {
        // TODO: Implementiere die Logik
        return "ue13TextEncryptionDecryption: Funktion noch nicht implementiert.";
    }

    /**
     * Aufgabe: Zerlege eine URL in ihre Bestandteile: Protokoll, Domain, Pfad und Query-Parameter.
     * Beispiel:
     *   Input: "https://www.beispiel.de/pfad?param=wert"
     *   Erwartete Ausgabe: Protokoll: "https", Domain: "www.beispiel.de", Pfad: "pfad", Query: "param=wert"
     */
    public static String ue14URLParser(String url) {
        // TODO: Implementiere die Logik
        return "ue14URLParser: Funktion noch nicht implementiert.";
    }

    /**
     * Aufgabe: Überprüfe, ob zwei gegebene Strings Anagramme voneinander sind.
     * Beispiel:
     *   Input: "Listen", "Silent"
     *   Erwartete Ausgabe: true
     *
     *   Input: "Hello", "World"
     *   Erwartete Ausgabe: false
     */
    public static boolean ue15AnagramChecker(String s1, String s2) {
        // TODO: Implementiere die Logik
        return false;
    }
}
