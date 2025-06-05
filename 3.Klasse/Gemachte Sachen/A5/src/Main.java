import java.util.*;

public class Main {
    public static void main(String[] args) {
//Scanner für eingabe
     Scanner sc =new Scanner(System.in);
     //verschiedene auswahlmöglichkeiten der zahlungen
        System.out.println("Welche Zahlungsmethode wollen Sie verwenden?");
        System.out.println("1.CreditCard");
        System.out.println("2.PayPal");
        System.out.println("3.BankTransfer");
       int x=sc.nextInt();
     //einzahlung erfolgt hier
        System.out.println("Wie viel wolen Sie einzahlen?");
        double amount = sc.nextDouble();
        //der klasse musste man einen wert initialisieren, weil die sonst nicht ging
       IPaymentMethod paymentMethod=null;
        switch(x){
            case 1:
                paymentMethod = new CreditCardPayment();
                break;

            case 2:
                paymentMethod = new PayPalPayment();
                break;

            case 3:
                paymentMethod = new BankTransferPayment();
                break;

            default:
                System.out.println("Falsche ausgabe, bitte erneut eingeben");
                System.exit(727272727);
            }
            //ausgabe der ausgewählten zahlungsmethode mit dem eingegebenen amount
            PaymentProcessor prozessor = new PaymentProcessor();
prozessor.process(paymentMethod,amount);
        }
    }
