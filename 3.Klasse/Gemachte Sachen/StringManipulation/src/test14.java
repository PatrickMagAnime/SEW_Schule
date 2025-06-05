import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class test14Test {

    @Test
    void testUe1Introduction() {
        String result = Main.ue1Introduction("Patrick", 25, "Pizza");
        assertEquals("Hallo, ich heiße Patrick. Ich bin 25 Jahre alt und mein Lieblingsessen ist Pizza.", result);
    }

    @Test
    void testUe2MiddleCharacters() {
        assertEquals("Hlo", Main.ue2MiddleCharacters("Hello"));
        assertEquals("A", Main.ue2MiddleCharacters("A"));
        assertEquals("", Main.ue2MiddleCharacters(""));
    }

    @Test
    void testUe3CaseInsensitiveSubstringCount() {
        assertEquals(2, Main.ue3CaseInsensitiveSubstringCount("Hello hello", "hello"));
        assertEquals(0, Main.ue3CaseInsensitiveSubstringCount("Hello", "world"));
    }

    @Test
    void testUe4NumberToLetter() {
        assertEquals("A", Main.ue4NumberToLetter(1));
        assertEquals("Z", Main.ue4NumberToLetter(26));
        assertEquals("", Main.ue4NumberToLetter(27));
    }

    @Test
    void testUe5ReverseString() {
        assertEquals("olleH", Main.ue5ReverseString("Hello"));
        assertEquals("", Main.ue5ReverseString(""));
    }

    @Test
    void testUe6PasswordStrengthChecker() {
        assertEquals("Passwort ist zu kurz", Main.ue6PasswordStrengthChecker("Ab1!"));
        assertEquals("Passwort muss mindestens einen Großbuchstaben enthalten", Main.ue6PasswordStrengthChecker("ab1!abcd"));
        assertEquals("Passwort ist stark", Main.ue6PasswordStrengthChecker("Ab1!abcd"));
    }

    @Test
    void testUe7PalindromeChecker() {
        assertTrue(Main.ue7PalindromeChecker("A man a plan a canal Panama"));
        assertFalse(Main.ue7PalindromeChecker("Hello"));
    }

    @Test
    void testUe8DecodeSecretMessage() {
        assertEquals("lcm", Main.ue8DecodeSecretMessage("Welcome"));
        assertEquals("", Main.ue8DecodeSecretMessage("Hi"));
    }

    @Test
    void testUe9CountOccurrences() {
        assertEquals(2, Main.ue9CountOccurrences("Hello hello", "hello"));
        assertEquals(0, Main.ue9CountOccurrences("Hello", "world"));
    }

    @Test
    void testUe10CountCharacters() {
        assertEquals("Buchstaben: 5, Ziffern: 3, Sonderzeichen: 2", Main.ue10CountCharacters("abc12!@3de"));
    }

    @Test
    void testUe11WordFrequencyCounter() {
        assertEquals("{hello=2, world=1}", Main.ue11WordFrequencyCounter("Hello world hello").toLowerCase());
    }

    @Test
    void testUe12CanBuildWord() {
        assertTrue(Main.ue12CanBuildWord("hello", new char[]{'h', 'e', 'l', 'l', 'o'}));
        assertFalse(Main.ue12CanBuildWord("hello", new char[]{'h', 'e', 'l', 'o'}));
    }

    @Test
    void testUe13TextEncryptionDecryption() {
        assertEquals("01001000 01100101 01101100 01101100 01101111", Main.ue13TextEncryptionDecryption("Hello"));
    }

    @Test
    void testUe14URLParser() {
        assertEquals("Protokoll: https, Domain: www.example.com, Pfad: /path, Query: query=test", 
                     Main.ue14URLParser("https://www.example.com/path?query=test"));
        assertEquals("Ungültige URL", Main.ue14URLParser("invalid_url"));
    }

    @Test
    void testUe15AnagramChecker() {
        assertTrue(Main.ue15AnagramChecker("listen", "silent"));
        assertFalse(Main.ue15AnagramChecker("hello", "world"));
    }
}