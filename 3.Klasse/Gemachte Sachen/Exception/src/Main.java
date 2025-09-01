public class Main {
    public static void main(String[] args) {

            int age = 10;
            if (age < 18) {
                throw new InvalidAgeException("Unter 18 Jahre");
            }
            try {
                double result=10/0

        }catch (ArithmeticException e){
                System.out.println("Fehler");
            }finally{
                System.out.println("Das wird immer ausgeführt werden");
            }
    }
}