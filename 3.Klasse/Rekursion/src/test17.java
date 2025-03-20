import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class test17Test {

    @Test
    void testUe1Factorial() {
        int input = 5;
        int expected = 120; // 5! = 5 * 4 * 3 * 2 * 1
        int result = Main.ue1Factorial(input);
        assertEquals(expected, result, "Factorial calculation failed");
    }

    @Test
    void testUe2BunnyEars() {
        int input = 3;
        int expected = 6; // 3 bunnies * 2 ears each
        int result = Main.ue2BunnyEars(input);
        assertEquals(expected, result, "Bunny ears calculation failed");
    }

    @Test
    void testUe3Fibonacci() {
        int input = 6;
        int expected = 8; // Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8
        int result = Main.ue3Fibonacci(input);
        assertEquals(expected, result, "Fibonacci calculation failed");
    }

    @Test
    void testUe4BunnyEars2() {
        int input = 3;
        int expected = 5; // 2 ears for odd bunnies, 3 ears for even bunnies
        int result = Main.ue4BunnyEars2(input);
        assertEquals(expected, result, "Bunny ears 2 calculation failed");
    }

    @Test
    void testUe5Triangle() {
        int input = 4;
        int expected = 10; // 4 rows: 1 + 2 + 3 + 4 = 10
        int result = Main.ue5Triangle(input);
        assertEquals(expected, result, "Triangle calculation failed");
    }

    @Test
    void testUe6SumDigits() {
        int input = 123;
        int expected = 6; // 1 + 2 + 3 = 6
        int result = Main.ue6SumDigits(input);
        assertEquals(expected, result, "Sum of digits calculation failed");
    }

    @Test
    void testUe7Count7() {
        int input = 717;
        int expected = 2; // Two occurrences of the digit 7
        int result = Main.ue7Count7(input);
        assertEquals(expected, result, "Count 7 calculation failed");
    }

    @Test
    void testUe8Count8() {
        int input = 8818;
        int expected = 4; // Two 8s together count as 2 + 2 = 4
        int result = Main.ue8Count8(input);
        assertEquals(expected, result, "Count 8 calculation failed");
    }

    @Test
    void testUe9PowerN() {
        int base = 2;
        int exponent = 3;
        int expected = 8; // 2^3 = 8
        int result = Main.ue9PowerN(base, exponent);
        assertEquals(expected, result, "Power calculation failed");
    }

    @Test
    void testUe10Array220() {
        int[] input = {1, 2, 20, 3};
        boolean expected = true; // 20 is 10 times 2
        boolean result = Main.ue10Array220(input, 0);
        assertEquals(expected, result, "Array220 calculation failed");
    }
}