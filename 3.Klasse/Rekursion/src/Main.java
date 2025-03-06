import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Übungen: https://codingbat.com/java/Recursion-1
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wähle eine Übung (1-10) oder 0 zum Beenden:");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Gib eine Zahl für factorial ein:");
                    int n1 = scanner.nextInt();
                    int result1 = ue1Factorial(n1);
                    System.out.println("UE1 factorial(" + n1 + ") = " + result1);
                    break;

                case 2:
                    System.out.println("Gib die Anzahl der Hasen für bunnyEars ein:");
                    int bunnies2 = scanner.nextInt();
                    int result2 = ue2BunnyEars(bunnies2);
                    System.out.println("UE2 bunnyEars(" + bunnies2 + ") = " + result2);
                    break;

                case 3:
                    System.out.println("Gib eine Zahl für fibonacci ein:");
                    int n3 = scanner.nextInt();
                    int result3 = ue3Fibonacci(n3);
                    System.out.println("UE3 fibonacci(" + n3 + ") = " + result3);
                    break;

                case 4:
                    System.out.println("Gib die Anzahl der Hasen für bunnyEars2 ein:");
                    int bunnies4 = scanner.nextInt();
                    int result4 = ue4BunnyEars2(bunnies4);
                    System.out.println("UE4 bunnyEars2(" + bunnies4 + ") = " + result4);
                    break;

                case 5:
                    System.out.println("Gib die Anzahl der Reihen für triangle ein:");
                    int rows5 = scanner.nextInt();
                    int result5 = ue5Triangle(rows5);
                    System.out.println("UE5 triangle(" + rows5 + ") = " + result5);
                    break;

                case 6:
                    System.out.println("Gib eine Zahl für sumDigits ein:");
                    int n6 = scanner.nextInt();
                    int result6 = ue6SumDigits(n6);
                    System.out.println("UE6 sumDigits(" + n6 + ") = " + result6);
                    break;

                case 7:
                    System.out.println("Gib eine Zahl für count7 ein:");
                    int n7 = scanner.nextInt();
                    int result7 = ue7Count7(n7);
                    System.out.println("UE7 count7(" + n7 + ") = " + result7);
                    break;

                case 8:
                    System.out.println("Gib eine Zahl für count8 ein:");
                    int n8 = scanner.nextInt();
                    int result8 = ue8Count8(n8);
                    System.out.println("UE8 count8(" + n8 + ") = " + result8);
                    break;

                case 9:
                    System.out.println("Gib die Basis und den Exponenten für powerN ein (zwei Zahlen):");
                    int base9 = scanner.nextInt();
                    int exp9 = scanner.nextInt();
                    int result9 = ue9PowerN(base9, exp9);
                    System.out.println("UE9 powerN(" + base9 + ", " + exp9 + ") = " + result9);
                    break;

                case 10:
                    System.out.println("Gib die Länge des Arrays und dann die Elemente für array220 ein:");
                    int length = scanner.nextInt();
                    int[] nums = new int[length];
                    for (int i = 0; i < length; i++) {
                        nums[i] = scanner.nextInt();
                    }
                    System.out.println("Gib den Startindex ein:");
                    int index10 = scanner.nextInt();
                    boolean resultBool = ue10Array220(nums, index10);
                    System.out.println("UE10 array220(" + Arrays.toString(nums) + ", " + index10 + ") = " + resultBool);
                    break;

                default:
                    System.out.println("Ungültige Auswahl. Bitte wähle eine Nummer zwischen 1 und 10 oder 0 zum Beenden.");
            }
        }
    }


    /**
     * Aufgabe: Berechnet die Fakultät einer gegebenen Zahl n (n ≥ 1).
     * Die Fakultät wird definiert als n * (n-1) * (n-2) * ... * 1.
     * Die Berechnung soll rekursiv (ohne Schleifen) erfolgen.
     *
     * Beispiele:
     *   Input: 1
     *   Erwartete Ausgabe: 1
     *
     *   Input: 2
     *   Erwartete Ausgabe: 2
     *
     *   Input: 3
     *   Erwartete Ausgabe: 6
     */
    public static int ue1Factorial(int n) {
        if (n == 0) {
            return 1; // Basisfall
        } else {
            return n * ue1Factorial(n - 1); //rekursiver
        }
    }

    /**
     * Aufgabe: Wir haben eine Anzahl von Hasen (bunnies), wobei jeder Hase zwei große Schlappohren besitzt.
     * Die Gesamtzahl der Ohren soll rekursiv (ohne Schleifen oder Multiplikation) berechnet werden.
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 2
     *
     *   Input: 2
     *   Erwartete Ausgabe: 4
     */
    public static int ue2BunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0; // Basisfall
        } else {
            return 2 + ue2BunnyEars(bunnies - 1); // rekursiver Fall
        }
    }

    /**
     * Aufgabe: Berechnet den n-ten Fibonacci-Wert rekursiv (ohne Schleifen).
     * Die Fibonacci-Reihe beginnt mit 0 und 1 (für n=0 bzw. n=1).
     * Jeder weitere Wert ist die Summe der beiden vorherigen Werte: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 1
     *
     *   Input: 2
     *   Erwartete Ausgabe: 1
     */
    public static int ue3Fibonacci(int n) {
        if (n == 0) {
            return 0; // Basisfall
        } else if (n == 1) {
            return 1; // Basisfall
        } else {
            return ue3Fibonacci(n - 1) + ue3Fibonacci(n - 2); // rekursiver Fall
        }
    }

    /**
     * Aufgabe: Wir betrachten Hasen in einer Reihe (1, 2, 3, ...).
     * Ungerade Hasen (1, 3, 5, ...) haben 2 Ohren, gerade Hasen (2, 4, 6, ...) haben 3 Ohren (wegen eines hochgestreckten Fußes).
     * Bestimme die Gesamtanzahl der Ohren rekursiv (ohne Schleifen oder Multiplikation).
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 2
     *
     *   Input: 2
     *   Erwartete Ausgabe: 5
     */
    public static int ue4BunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0; // Basisfall
        } else if (bunnies % 2 == 0) {
            return 3 + ue4BunnyEars2(bunnies - 1); // rekursiver Fall für gerade Hasen
        } else {
            return 2 + ue4BunnyEars2(bunnies - 1); // rekursiver Fall für ungerade Hasen
        }
    }

    /**
     * Aufgabe: Gegeben ist eine Dreiecksform, bei der die oberste Reihe 1 Block hat,
     * die nächste Reihe 2 Blöcke, dann 3 Blöcke und so weiter.
     * Bestimme rekursiv (ohne Schleifen oder Multiplikation) die Gesamtanzahl der Blöcke
     * für eine gegebene Anzahl von Reihen.
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 1
     *
     *   Input: 2
     *   Erwartete Ausgabe: 3
     */
    public static int ue5Triangle(int rows) {
        if (rows == 0) {
            return 0; // Basisfall
        } else {
            return rows + ue5Triangle(rows - 1); // rekursiver Fall
        }
    }

    /**
     * Aufgabe: Gib die Summe der Ziffern einer nicht-negativen ganzen Zahl n zurück,
     * berechnet rekursiv (ohne Schleifen).
     * Hinweis: n % 10 liefert die letzte Ziffer, n / 10 entfernt die letzte Ziffer.
     *
     * Beispiele:
     *   Input: 126
     *   Erwartete Ausgabe: 9
     *
     *   Input: 49
     *   Erwartete Ausgabe: 13
     *
     *   Input: 12
     *   Erwartete Ausgabe: 3
     */
    public static int ue6SumDigits(int n) {
        if (n == 0) {
            return 0; // Basisfall
        } else {
            return n % 10 + ue6SumDigits(n / 10); // rekursiver Fall
        }
    }

    /**
     * Aufgabe: Zähle die Anzahl der Vorkommen der Ziffer 7 in einer nicht-negativen ganzen Zahl n,
     * berechnet rekursiv (ohne Schleifen).
     * Beispiel: 717 enthält die Ziffer 7 genau 2-mal.
     * Hinweis: n % 10 liefert die letzte Ziffer, n / 10 entfernt die letzte Ziffer.
     *
     * Beispiele:
     *   Input: 717
     *   Erwartete Ausgabe: 2
     *
     *   Input: 7
     *   Erwartete Ausgabe: 1
     *
     *   Input: 123
     *   Erwartete Ausgabe: 0
     */
    public static int ue7Count7(int n) {
        if (n == 0) {
            return 0; // Basisfall
        } else if (n % 10 == 7) {
            return 1 + ue7Count7(n / 10); // rekursiver Fall, Ziffer 7 gefunden
        } else {
            return ue7Count7(n / 10); // rekursiver Fall, keine 7 gefunden
        }
    }

    /**
     * Aufgabe: Zähle die Anzahl der Vorkommen der Ziffer 8 in einer nicht-negativen ganzen Zahl n,
     * berechnet rekursiv (ohne Schleifen).
     * Achtung: Steht eine 8 direkt neben einer weiteren 8 (z.B. "88"),
     * so zählt die zweite 8 doppelt.
     * Hinweis: n % 10 liefert die letzte Ziffer, n / 10 entfernt die letzte Ziffer.
     *
     * Beispiele:
     *   Input: 8
     *   Erwartete Ausgabe: 1
     *
     *   Input: 818
     *   Erwartete Ausgabe: 2
     *
     *   Input: 8818
     *   Erwartete Ausgabe: 4
     */
    public static int ue8Count8(int n) {
        if (n == 0) {
            return 0; // Basisfall
        } else if (n % 10 == 8) {
            if ((n / 10) % 10 == 8) {
                return 2 + ue8Count8(n / 10); // rekursiver Fall, doppelte 8 gefunden
            } else {
                return 1 + ue8Count8(n / 10); // rekursiver Fall, einfache 8 gefunden
            }
        } else {
            return ue8Count8(n / 10); // rekursiver Fall, keine 8 gefunden
        }
    }

    /**
     * Aufgabe: Berechnet rekursiv (ohne Schleifen) die Potenz base^n,
     * wobei base ≥ 1 und n ≥ 1 ist.
     * Beispiel: powerN(3, 2) = 3^2 = 9.
     *
     * Beispiele:
     *   Input: 3, 1
     *   Erwartete Ausgabe: 3
     *
     *   Input: 3, 2
     *   Erwartete Ausgabe: 9
     *
     *   Input: 3, 3
     *   Erwartete Ausgabe: 27
     */
    public static int ue9PowerN(int base, int n) {
        if (n == 0) {
            return 1; // Basisfall
        } else {
            return base * ue9PowerN(base, n - 1); // rekursiver Fall
        }
    }

    /**
     * Aufgabe: Gegeben ein Array von ganzen Zahlen (nums), prüfe rekursiv (ohne Schleifen),
     * ob irgendwo in diesem Array ein Wert vorkommt, auf den direkt sein 10-faches folgt.
     * Die Suche beginnt ab dem Index 'index' und soll in jedem rekursiven Schritt um 1 erhöht werden.
     *
     * Beispiele:
     *   Input: [1, 2, 20], 0
     *   Erwartete Ausgabe: true (2 gefolgt von 20)
     *
     *   Input: [3, 30], 0
     *   Erwartete Ausgabe: true (3 gefolgt von 30)
     *
     *   Input: [3], 0
     *   Erwartete Ausgabe: false (kein Folgewert vorhanden)
     */
    public static boolean ue10Array220(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return false; // Basisfall
        } else if (nums[index] * 10 == nums[index + 1]) {
            return true; // rekursiver Fall, Bedingung erfüllt
        } else {
            return ue10Array220(nums, index + 1); // rekursiver Fall, weiter suchen
        }
    }
}