public class TailRecursionExample {

    public static int factorial(int n) {
        return factorialHelper(n, 1);
    }

    private static int factorialHelper(int n, int result) {
        if (n == 0) {
            return result;
        }
        return factorialHelper(n - 1, n * result);
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial of " + number + " is: " + factorial(number));
    }
}