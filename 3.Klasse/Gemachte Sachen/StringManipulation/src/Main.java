import java.util.*;

public class Main {
//220227
    //shortened ver.
    public static void main(String[] args) {
        Scanner yuri = new Scanner(System.in);

        System.out.println("Willkommen zum String-Manipulations-Übungsprogramm!");
        System.out.println("Bitte wähle eine Übung (1-15) aus:");
        System.out.println("1: ue1Introduction");
        System.out.println("2: ue2MiddleCharacters");
        System.out.println("3: ue3CaseInsensitiveSubstringCount");
        System.out.println("4: ue4NumberToLetter");
        System.out.println("5: ue5ReverseString");
        System.out.println("6: ue6PasswordStrengthChecker");
        System.out.println("7: ue7PalindromeChecker");
        System.out.println("8: ue8DecodeSecretMessage");
        System.out.println("9: ue9CountOccurrences");
        System.out.println("10: ue10CountCharacters");
        System.out.println("11: ue11WordFrequencyCounter");
        System.out.println("12: ue12CanBuildWord");
        System.out.println("13: ue13TextEncryptionDecryption");
        System.out.println("14: ue14URLParser");
        System.out.println("15: ue15AnagramChecker");
        System.out.print("Deine Wahl: ");
        int choice = yuri.nextInt();
        yuri.nextLine(); // Zeilenumbruch verzehren

        switch(choice) {
            case 1: {
                System.out.println("Bitte gib deinen Namen ein:");
                String name = yuri.nextLine();
                System.out.println("Bitte gib dein Alter ein:");
                int age = yuri.nextInt();
                yuri.nextLine();
                System.out.println("Bitte gib dein Lieblingsessen ein:");
                String favouriteFood = yuri.nextLine();
                String result = ue1Introduction(name, age, favouriteFood);
                System.out.println("Ergebnis UE1: " + result);
                break;
            }
            case 2: {
                System.out.println("Bitte gib einen String ein:");
                String input = yuri.nextLine();
                String result = ue2MiddleCharacters(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 3: {
                System.out.println("Bitte gib einen Text ein:");
                String text = yuri.nextLine();
                System.out.println("Bitte gib einen Suchbegriff ein:");
                String substring = yuri.nextLine();
                int result = ue3CaseInsensitiveSubstringCount(text, substring);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 4: {
                System.out.println("Bitte gib eine Zahl zwischen 1 und 26 ein:");
                int number = yuri.nextInt();
                String result = ue4NumberToLetter(number);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 5: {
                System.out.println("Bitte gib einen String ein:");
                String input = yuri.nextLine();
                String result = ue5ReverseString(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 6: {
                System.out.println("Bitte gib ein Passwort ein:");
                String password = yuri.nextLine();
                String result = ue6PasswordStrengthChecker(password);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 7: {
                System.out.println("Bitte gib einen String ein:");
                String pallindrome = yuri.nextLine();
                boolean result = ue7PalindromeChecker(pallindrome);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 8: {
                System.out.println("Bitte gib eine verschlüsselte Nachricht ein:");
                String verschluesselteNachricht = yuri.nextLine();
                String result = ue8DecodeSecretMessage(verschluesselteNachricht);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 9: {
                System.out.println("Bitte gib einen Text ein:");
                String text = yuri.nextLine();
                System.out.println("Bitte gib einen Namen ein:");
                String name = yuri.nextLine();
                int result = ue9CountOccurrences(text, name);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 10: {
                System.out.println("Bitte gib einen String ein:");
                String input = yuri.nextLine();
                String result = ue10CountCharacters(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 11: {
                System.out.println("Bitte gib einen Text ein:");
                String text = yuri.nextLine();
                String result = ue11WordFrequencyCounter(text);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 12: {
                System.out.println("Bitte gib ein Wort ein:");
                String word = yuri.nextLine();
                System.out.println("Bitte gib eine Zeichenliste ein (z.B. 'h,e,l,l,o'):");
                String[] lettersInput = yuri.nextLine().split(",");
                char[] letters = new char[lettersInput.length];
                for (int i = 0; i < lettersInput.length; i++) {
                    letters[i] = lettersInput[i].charAt(0);
                }
                boolean result = ue12CanBuildWord(word, letters);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 13: {
                System.out.println("Bitte gib einen Text ein:");
                String text = yuri.nextLine();
                String result = ue13TextEncryptionDecryption(text);
                System.out.println("Ergebnis (verschlüsselt): " + result);
                break;
            }
            case 14: {
                System.out.println("Bitte gib eine URL ein:");
                String url = yuri.nextLine();
                String result = ue14URLParser(url);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 15: {
                System.out.println("Bitte gib den ersten String ein:");
                String s1 = yuri.nextLine();
                System.out.println("Bitte gib den zweiten String ein:");
                String s2 = yuri.nextLine();
                boolean result = ue15AnagramChecker(s1, s2);
                System.out.println("Ergebnis: " + result);
                break;
            }
            default:
                System.out.println("Ungültige Auswahl!");
                break;
        }

        yuri.close();
    }

    public static String ue1Introduction(String name, int age, String favouriteFood) {
        return "Hallo, ich heiße " + name + ". Ich bin " + age + " Jahre alt und mein Lieblingsessen ist " + favouriteFood + ".";
    }

    public static String ue2MiddleCharacters(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        int middleIndex = input.length() / 2;
        return "" + input.charAt(0) + input.charAt(middleIndex) + input.charAt(input.length() - 1);
    }

    public static int ue3CaseInsensitiveSubstringCount(String text, String substring) {
        text = text.toLowerCase();
        substring = substring.toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public static String ue4NumberToLetter(int number) {
        if (number < 1 || number > 26) {
            return "";
        }
        return String.valueOf((char) ('A' + number - 1));
    }

    public static String ue5ReverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String ue6PasswordStrengthChecker(String password) {
        if (password.length() < 8) return "Passwort ist zu kurz";
        if (!password.matches(".*[A-Z].*")) return "Passwort muss mindestens einen Großbuchstaben enthalten";
        if (!password.matches(".*[a-z].*")) return "Passwort muss mindestens einen Kleinbuchstaben enthalten";
        if (!password.matches(".*\\d.*")) return "Passwort muss mindestens eine Ziffer enthalten";
        if (!password.matches(".*[!@#$%^&*()].*")) return "Passwort muss mindestens ein Sonderzeichen enthalten";
        return "Passwort ist stark";
    }

    public static boolean ue7PalindromeChecker(String input) {
        String cleanedInput = input.replaceAll("[\\W_]", "").toLowerCase();
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();
        return cleanedInput.equals(reversedInput);
    }

    public static String ue8DecodeSecretMessage(String secretMessage) {
        StringBuilder decodedMessage = new StringBuilder();
        for (int i = 3; i < secretMessage.length(); i += 2) {
            decodedMessage.append(secretMessage.charAt(i));
        }
        return decodedMessage.toString();
    }

    public static int ue9CountOccurrences(String text, String name) {
        text = text.toLowerCase();
        name = name.toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(name, index)) != -1) {
            count++;
            index += name.length();
        }
        return count;
    }

    public static String ue10CountCharacters(String input) {
        int letters = 0, digits = 0, special = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                special++;
            }
        }
        return "Buchstaben: " + letters + ", Ziffern: " + digits + ", Sonderzeichen: " + special;
    }

    public static String ue11WordFrequencyCounter(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        String[] words = text.toLowerCase().split("\\W+");
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap.toString();
    }

    public static boolean ue12CanBuildWord(String word, char[] letters) {
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char letter : letters) {
            letterMap.put(letter, letterMap.getOrDefault(letter, 0) + 1);
        }
        for (char c : word.toCharArray()) {
            if (!letterMap.containsKey(c) || letterMap.get(c) == 0) {
                return false;
            }
            letterMap.put(c, letterMap.get(c) - 1);
        }
        return true;
    }

    public static String ue13TextEncryptionDecryption(String text) {
        StringBuilder binaryText = new StringBuilder();
        for (char c : text.toCharArray()) {
            binaryText.append(String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0")).append(" ");
        }
        return binaryText.toString().trim();
    }

    public static String ue14URLParser(String url) {
        try {
            URL urlObj = new URL(url);
            String protocol = urlObj.getProtocol();
            String domain = urlObj.getHost();
            String path = urlObj.getPath();
            String query = urlObj.getQuery();
            return "Protokoll: " + protocol + ", Domain: " + domain + ", Pfad: " + path + ", Query: " + query;
        } catch (MalformedURLException e) {
            return "Ungültige URL";
        }
    }

    public static boolean ue15AnagramChecker(String s1, String s2) {
        char[] charArray1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] charArray2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
